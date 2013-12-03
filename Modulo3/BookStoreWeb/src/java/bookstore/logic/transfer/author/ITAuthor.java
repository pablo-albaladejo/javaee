package bookstore.logic.transfer.author;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface ITAuthor {
    /**
     * ID getter
     * @return the Author ID
     */
    int getID();
    /**
     * ID setter
     * @param ID the Author ID
     */
    void setID(int ID);
    
    /**
     * Name getter
     * @return the Author name
     */
    String getName();
    /**
     * Name setter
     * @param name the Author name
     */
    void setName(String name);
}
