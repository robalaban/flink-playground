-- Create Catalog

CREATE CATALOG iceberg_catalog WITH (
  'type'='iceberg',
  'warehouse'='s3://sandbox-lakehouse-91779879',
  'catalog-impl'='org.apache.iceberg.aws.glue.GlueCatalog',
  'io-impl'='org.apache.iceberg.aws.s3.S3FileIO'
);

-- Use the catalog
USE catalog iceberg_catalog;
