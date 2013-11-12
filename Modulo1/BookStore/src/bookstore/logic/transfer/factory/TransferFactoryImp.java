package bookstore.logic.transfer.factory;

import bookstore.logic.transfer.book.ITBook;
import bookstore.logic.transfer.book.TBook;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
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
