FROM flink:1.20.0

# Install wget
RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/*

# Create Hadoop Directory, Download Dependencies, & Generate Hadoop Classpath
RUN mkdir -p /opt/hadoop/lib && mkdir -p /opt/hadoop/conf && cd /opt/hadoop/lib && \
  wget https://repo.maven.apache.org/maven2/org/apache/hadoop/hadoop-client/3.4.1/hadoop-client-3.4.1.jar && \
  wget https://repo.maven.apache.org/maven2/org/apache/hadoop/hadoop-client-api/3.4.1/hadoop-client-api-3.4.1.jar && \
  wget https://repo.maven.apache.org/maven2/org/apache/hadoop/hadoop-client-runtime/3.4.1/hadoop-client-runtime-3.4.1.jar && \
  wget https://repo1.maven.org/maven2/org/apache/flink/flink-json/1.20.0/flink-json-1.20.0.jar

# Download Hadoop AWS dependencies
RUN cd /opt/flink/lib/ && \
    wget https://repo1.maven.org/maven2/org/apache/iceberg/iceberg-flink-runtime-1.20/1.7.1/iceberg-flink-runtime-1.20-1.7.1.jar && \
    wget https://repo1.maven.org/maven2/software/amazon/awssdk/bundle/2.30.16/bundle-2.30.16.jar && \
    wget https://repo1.maven.org/maven2/org/apache/flink/flink-s3-fs-presto/1.20.0/flink-s3-fs-presto-1.20.0.jar


# Set HADOOP_CLASSPATH directly with the known paths
ENV HADOOP_CLASSPATH=/opt/hadoop/lib/hadoop-client-3.4.1.jar:/opt/hadoop/lib/hadoop-client-api-3.4.1.jar:/opt/hadoop/lib/hadoop-client-runtime-3.4.1.jar

CMD ["sleep", "infinity"] 
