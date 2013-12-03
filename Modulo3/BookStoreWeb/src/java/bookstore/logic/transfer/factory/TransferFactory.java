package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;

/**
 * Implements the Abstract Factory and Singeltone Pattern
 * All the Transfer objects should be generated form this
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class TransferFactory {
    static private TransferFactory instance;
    
    /**
     * Provides a unique instance of the Factory implementation
     * @return <code>{@link TransferFactoryImp}</code>
     */
    static public TransferFactory getInstance(){
        if(instance == null) instance = new TransferFactoryImp();
        return instance;
    }
    
    /**
     * Provides an object of the Book entity Transfer pattern
     * @return <code>{@link ITBook}</code>
     */
    abstract public ITBook getBookTransfer();

}
