package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class TransferFactory {
    static private TransferFactory instance;
    
    /**
     *
     * @return
     */
    static public TransferFactory getInstance(){
        if(instance == null) instance = new TransferFactoryImp();
        return instance;
    }
    
    /**
     *
     * @return
     */
    abstract public ITBook getBookTransfer();
}
