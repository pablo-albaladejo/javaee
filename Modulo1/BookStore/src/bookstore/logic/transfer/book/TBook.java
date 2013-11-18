package bookstore.logic.transfer.book;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class TBook implements ITBook{
    private int ID;
    private String title;
    private String author;
    private String editorial;
    private String ISBN;
    private int publicationYear;
    private double price;
    private String description;
    
    /**
     *
     * @return
     */
    @Override
    public int getID(){
        return this.ID;
    }
    /**
     *
     * @param ID
     */
    @Override
    public void setID(int ID){
        this.ID = ID;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle(){
        return this.title;
    }
    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title){
        this.title = title;
    }

    /**
     *
     * @return
     */
    @Override
    public String getAuthor(){
        return this.author;
    }
    /**
     *
     * @param author
     */
    @Override
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     *
     * @return
     */
    @Override
    public String getEditorial(){
        return this.editorial;
    }
    /**
     *
     * @param editorial
     */
    @Override
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }

    /**
     *
     * @return
     */
    @Override
    public String getISBN(){
        return this.ISBN;
    }
    /**
     *
     * @param ISBN
     */
    @Override
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    /**
     *
     * @return
     */
    @Override
    public int getPublicationYear(){
        return this.publicationYear;
    }
    /**
     *
     * @param publicationYear
     */
    @Override
    public void setPublicationYear(int publicationYear){
        this.publicationYear = publicationYear;
    }

    /**
     *
     * @return
     */
    @Override
    public double getPrice(){
        return this.price;
    }
    /**
     *
     * @param price
     */
    @Override
    public void setPrice(double price){
        this.price = price;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription(){
        return this.description;
    }
    /**
     *
     * @param description
     */
    @Override
    public void setDescription(String description){
        this.description = description;
    }
    
    @Override
    public String toString(){
        return this.title + ", " + 
                this.author + ", " +
                this.editorial + ", " +
                this.ISBN + ", " +
                this.publicationYear + ", " +
                this.price + ", " +
                this.description;
    }
}
