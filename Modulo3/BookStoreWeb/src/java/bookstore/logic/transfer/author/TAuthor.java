package bookstore.logic.transfer.author;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TAuthor implements ITAuthor{
    private int ID;
    private String name;
    
    /**
     * ID getter
     * @return the Author ID
     */
    @Override
    public int getID() {
        return this.ID;
    }
    /**
     * ID setter
     * @param ID the Author ID
     */
    @Override
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Name getter
     * @return the Author name
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * Name setter
     * @param name the Author name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

}
