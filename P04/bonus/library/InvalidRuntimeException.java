class InvalidRuntimeException extends ArithmeticException {

    public InvalidRuntimeException(String message) {
        super(message);
    }

    public InvalidRuntimeException(String title, int runtime) {
        this(title + " has invalid runtime " + runtime);
    }
}

