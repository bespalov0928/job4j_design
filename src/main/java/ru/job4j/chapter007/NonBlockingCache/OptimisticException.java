package ru.job4j.chapter007.NonBlockingCache;

public class OptimisticException extends RuntimeException {
    public OptimisticException(String message) {
        super(message);
    }
}
