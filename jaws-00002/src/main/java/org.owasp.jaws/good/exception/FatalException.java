package org.owasp.jaws.good.exception;

/**
 * @author Sam Theys
 */
public class FatalException extends RuntimeException {

    public FatalException(String message) {
        super(message);
    }

    public FatalException(String message, Throwable cause) {
        super(message, cause);
    }
}
