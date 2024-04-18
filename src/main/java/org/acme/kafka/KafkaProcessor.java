package org.acme.kafka;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.quarkus.logging.Log;

/**
 * A bean consuming data from the "quote-requests" Kafka topic (mapped to "requests" channel) and giving out a random quote.
 * The result is pushed to the "quotes" Kafka topic.
 */
@ApplicationScoped
public class KafkaProcessor {

    @Incoming("my-topic-insurance-incoming")   
    public void processInsurance(String vehicle) throws InterruptedException {
        Log.info(vehicle);
        // simulate some hard working task
        Thread.sleep(200);

    }
}