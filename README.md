# Flink SQL Client with Iceberg

A project demonstrating Flink SQL Client integration with Apache Iceberg using AWS Glue catalog.

## Requirements

- Java 17
- Gradle
- Docker

## Getting Started

1. Create a `.env` file with AWS credentials:

```sh
AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_region
```

2. Build and start the containers:

```sh
docker compose build
docker compose up -d
```

For SQL Client, you can use the following command to jump into the container and initialize the catalog. The `init.sql` file is located in the `sql-client` directory. 

```sh
docker exec -it flink-sql-client-1 ./bin/sql-client.sh
```


## Troubleshooting

If you see Hadoop/AWS-related errors:

- Verify AWS credentials in .env
- Check if HADOOP_CLASSPATH is set correctly in the container
- Ensure all required JARs are in the correct location

For permission issues with S3:

- Verify your AWS credentials have the necessary permissions
- Check if the bucket exists and is accessible

For catalog creation issues:

- Ensure Glue catalog permissions are configured
- Verify the warehouse path is correct and accessible


## References

- [Flink SQL Client with Iceberg](https://docs.apache.org/en/latest/flink/sql-client.html)
- [Apache Iceberg](https://iceberg.apache.org/)
