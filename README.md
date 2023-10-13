# S3 Operations

## Overview

The S3 Operations project is a Java-based solution that leverages the Amazon S3 API to perform a variety of operations related to Amazon S3 buckets and objects. This project provides a set of functionalities to create S3 buckets, upload objects to these buckets, and list buckets. It follows best practices by securely handling AWS credentials and utilizes the S3Client builder for a streamlined and reliable approach to interacting with Amazon S3 services.

## Features

- **Bucket Creation:** Easily create new Amazon S3 buckets through a simple and intuitive Java interface.

- **Object Upload:** Seamlessly upload objects to S3 buckets, making it convenient to store and manage your data in the cloud.

- **Object Listing:** Retrieve a list of buckets, facilitating efficient data management.

## Usage

The project utilizes the recommended approach for securing AWS credentials, ensuring the security of your AWS resources.

To get started, simply initialize an object for the provided S3_ops class, and then call the relevant methods for your specific S3 operations.

Example:

```java
// Initialize S3 client
S3_ops s3Ops = new S3_ops();

// Create a new S3 bucket
s3Ops.createBucket(bucketName); // globally unique bucketName 

// Upload an object to the S3 bucket
s3Ops.putObj(bucketName, objectKey,objectPath); // objectKey is a file name to be uploaded,
                                                // objectPath is the path of the file

// List buckets
s3Ops.listBuckets(); // prints names of S3 buckets to the console
```

## Prerequisites

- Java development environment.
- AWS account with access to S3.
- AWS credentials configured using the recommended approach.

## Installation

To use this project, clone the repository and import it into your Java development environment.

```shell
git clone (https://github.com/amanuelararso/S3_operations.git)
```

## Contribution

Contributions to this project are welcome! Feel free to submit issues, pull requests, or suggestions for improvement.

## License

This project is open-source and available under the MIT License.

---

Start managing your Amazon S3 resources efficiently with the S3 Operations project. If you have any questions or need assistance, please don't hesitate to contact me.
