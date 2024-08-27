package com.example.BookstoreAPI.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class BookstoreMetrics {

    @SuppressWarnings("unused")
    private final MeterRegistry meterRegistry;

    public BookstoreMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        // Initialize custom metrics
        meterRegistry.gauge("books.count", this, BookstoreMetrics::getBookCount);
    }

    public double getBookCount() {
        // Replace with actual logic to count books
        return 100.0; // Example static value
    }
}
