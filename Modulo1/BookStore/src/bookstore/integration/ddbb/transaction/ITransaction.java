package bookstore.integration.ddbb.transaction;

import bookstore.integration.ddbb.exception.TransactionException;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
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