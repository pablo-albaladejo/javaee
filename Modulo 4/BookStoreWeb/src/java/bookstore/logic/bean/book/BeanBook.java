package bookstore.logic.bean.book;

/**
 * This class implements the
 * <code>{@link IBeanBook}</code> interface.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BeanBook implements IBeanBook {

    private int ID;
    private String title;
    private String author;
    private String editorial;
    private String ISBN;
    private int publicationYear;
    private double price;
    private String description;

    /**
     * Empty default contructor
     */
    
    public BeanBook() {
    }

    /**
     * Full default contructor
     * @param ID
     * @param title
     * @param author
     * @param editorial
     * @param ISBN
     * @param publicationYear
     * @param price
     * @param description
     */
    public BeanBook(int ID, String title, String author, String editorial, String ISBN, int publicationYear, double price, String description) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.price = price;
        this.description = description;
    }

    /**
     * ID getter
     *
     * @return the Book ID
     */
    @Override
    public int getID() {
        return this.ID;
    }

    /**
     * ID setter
     *
     * @param ID the Book ID
     */
    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Title getter
     *
     * @return the Book Title
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * Title setter
     *
     * @param title the Book Title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Author getter
     * @return the Author
     */
    @Override
    public String getAuthor() {
        return this.author;
    }

    /**
     * Author setter
     * @param author the Author
     */
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Editorial getter
     *
     * @return the Book Editorial
     */
    @Override
    public String getEditorial() {
        return this.editorial;
    }

    /**
     * Book setter
     *
     * @param editorial the Book Editorial
     */
    @Override
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * ISBN getter
     *
     * @return the Book ISNB
     */
    @Override
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * ISBN setter
     *
     * @param ISBN the Book ISBN
     */
    @Override
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Publication Year getter
     *
     * @return the Book Publication Year
     */
    @Override
    public int getPublicationYear() {
        return this.publicationYear;
    }

    /**
     * Publication Year setter
     *
     * @param publicationYear the Book Publication Year
     */
    @Override
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Price getter
     *
     * @return the Book Price
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * Price setter
     *
     * @param price the Book Price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Description getter
     *
     * @return the Book Description
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Description setter
     *
     * @param description the Book Description
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  this.ID + ", "
                + this.title + ", "
                + this.author + ", "
                + this.editorial + ", "
                + this.ISBN + ", "
                + this.publicationYear + ", "
                + this.price + ", "
                + this.description;
    }
}
