package org.example;

import org.example.model.S3_ops;

public class Main {
    public static void main(String[] args) {

        S3_ops s3Ops = new S3_ops();
        s3Ops.listBuckets();

        String bucketName = "technical-report-2023";
        s3Ops.createBucket(bucketName);

        String objectKey = "technical_report_first_quarter.pdf";
        String objectPath = "/Users/mac/Documents/technical_report_first_quarter.pdf";
        s3Ops.putObj(bucketName, objectKey,objectPath);
    }
}