package org.example.model;



import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

import java.io.File;


public class S3_ops {

    private static S3Client s3ClientBuilder() {
        // specify the region my aws account is currently operating
        Region region = Region.US_WEST_2;

        // credentials are saved in '~/.aws/credential' file locally
        // config file is saved in '~/.aws/config' file locally, which I got from https://<myusername>.awsapps.com/start#/
        // 413708395000_PowerUserAccess: custom profile name for my account
        return S3Client.builder()
                .credentialsProvider(ProfileCredentialsProvider.create("413708395000_PowerUserAccess"))
                .region(region)
                .build();
    }
    public void putObj(String bucketName, String objectKey, String objectPath) {

        S3Client s3Client = s3ClientBuilder();


        try {


            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(objectKey)
                    .build();

            s3Client.putObject(putOb, RequestBody.fromFile(new File(objectPath)));
            System.out.println("Successfully placed " + objectKey + " into bucket " + bucketName);
        } catch (S3Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

    }
    public void listBuckets() {
        S3Client s3Client = s3ClientBuilder();

        // List buckets
        ListBucketsRequest listBucketsRequest = ListBucketsRequest.builder().build();
        ListBucketsResponse listBucketsResponse = s3Client.listBuckets(listBucketsRequest);
        listBucketsResponse.buckets().stream().forEach(x -> System.out.println(x.name()));

    }

    // Create a bucket by using a S3Waiter object
    public void createBucket(String bucketName) {

        S3Client s3Client = s3ClientBuilder();
        try {
            S3Waiter s3Waiter = s3Client.waiter();
            CreateBucketRequest bucketRequest = CreateBucketRequest.builder()
                    .bucket(bucketName)
                    .build();

            s3Client.createBucket(bucketRequest);
            HeadBucketRequest bucketRequestWait = HeadBucketRequest.builder()
                    .bucket(bucketName)
                    .build();

            // Wait until the bucket is created and print out the response.
            WaiterResponse<HeadBucketResponse> waiterResponse = s3Waiter.waitUntilBucketExists(bucketRequestWait);
            waiterResponse.matched().response().ifPresent(System.out::println);
            System.out.println(bucketName +" is ready");

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

}
