package bookstore.integration.ddbb.exception;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TransactionException extends Exception{
    private static final long serialVersionUID = 1L;
    private String message;

    /**
     *
     */
    public TransactionException(){}

    /**
     *
     * @param error
     */
    public TransactionException(String error) {
            this.message = error;
    }

    /**
     *
     * @param ex
     */
    public TransactionException(Exception ex) {
            this.setStackTrace(ex.getStackTrace());
    }

    /**
     *
     * @param ex
     * @param error
     */
    public TransactionException(Exception ex, String error) {
            this.setStackTrace(ex.getStackTrace());
            this.message = error;
    }

    @Override
    public String getMessage() {
            return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
            this.message = message;
    }
}
