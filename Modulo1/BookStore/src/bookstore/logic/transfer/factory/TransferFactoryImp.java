package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;
import bookstore.logic.transfer.book.TBook;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TransferFactoryImp extends TransferFactory{
    
    /**
     *
     * @return
     */
    @Override
    public ITBook getBookTransfer(){
        return new TBook();
    }
}
