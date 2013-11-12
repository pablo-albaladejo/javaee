package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
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
