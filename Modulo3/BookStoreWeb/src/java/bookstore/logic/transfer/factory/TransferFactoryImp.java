package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;
import bookstore.logic.transfer.book.TBook;

/**
 * This class implements the <code>{@link TransferFactory}</code>
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TransferFactoryImp extends TransferFactory{
    
    /**
     * Return a Book object wich implements <code>{@link ITBook}</code> 
     * @return <code>{@link ITBook}</code>
     */
    @Override
    public ITBook getBookTransfer(){
        return new TBook();
    }
}
