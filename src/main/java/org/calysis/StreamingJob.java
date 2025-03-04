package org.calysis;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

public class StreamingJob {
    public static void main(String[] args) throws Exception {
        // Set up the execution environment with local configuration
        Configuration config = new Configuration();
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(config);

        // Generate a simple sequence of numbers
        DataStream<Long> numbers = env.fromSequence(1, 100);

        // Apply a simple transformation
        DataStream<String> result = numbers
            .map(n -> "Number: " + n)
            .filter(str -> !str.endsWith("0")); // Filter out multiples of 10

        // Print the results
        result.print();

        // Execute the job
        env.execute("Flink Streaming Java API Skeleton");
    }
}
