package com.pm.backendspringboot.exceptions;

import java.time.Instant;

/**
 * @description Error message for exception handling.
 * @param status
 * @param timestamp
 * @param message
 * @param path
 */
public record ErrorMessage(Integer status, Instant timestamp, String message, String path) {}
