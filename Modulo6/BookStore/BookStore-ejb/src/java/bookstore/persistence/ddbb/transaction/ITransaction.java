package bookstore.persistence.ddbb.transaction;

import bookstore.persistence.ddbb.exception.TransactionException;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface ITransaction {
    /**
     *
     * @throws TransactionException
     */
    public void commit() throws TransactionException;
    /**
     *
     * @throws TransactionException
     */
    public void rollback() throws TransactionException;
    /**
     *
     * @throws TransactionException
     */
    public void begin() throws TransactionException;
    /**
     *
     * @throws TransactionException
     */
    public void close() throws TransactionException;
    /**
     *
     * @return
     */
    public Object getConexion();
}
