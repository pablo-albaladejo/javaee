package ejb.bean.book;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * This class implements the
 * <code>{@link IBookBean}</code> interface.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Entity
@Table(name = "libros")
@NamedQueries({
    @NamedQuery(name = "BookBean.findAll", query = "SELECT n FROM BookBean n")})
public class BookBean implements IBookBean {

    private Integer ID;
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
    
    public BookBean() {
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
    public BookBean(int ID, String title, String author, String editorial, String ISBN, int publicationYear, double price, String description) {
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
    @Id
    @Column(name = "ID")
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
    @Column(name = "TITULO")
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
    @Column(name = "AUTOR")
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
    @Column(name = "EDITORIAL")
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
    @Column(name = "ISBN")
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
    @Column(name = "PUBLICACION")
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
    @Column(name = "PRECIO")
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
    @Column(name = "DESCRIPCION")
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

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof BookBean)) return false;
        return (this.ISBN == null ? ((BookBean)obj).ISBN == null : this.ISBN.equals(((BookBean)obj).ISBN));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.ID;
        hash = 47 * hash + Objects.hashCode(this.title);
        hash = 47 * hash + Objects.hashCode(this.author);
        hash = 47 * hash + Objects.hashCode(this.editorial);
        hash = 47 * hash + Objects.hashCode(this.ISBN);
        hash = 47 * hash + this.publicationYear;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.description);
        return hash;
    }
    
}
