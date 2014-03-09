package ws.dto.domain.book;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class implements the
 * <code>{@link IBookDO}</code> interface.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookDO.findAll", query = "SELECT b FROM BookDO b"),
    @NamedQuery(name = "BookDO.deleteByIsbn", query = "DELETE FROM BookDO b WHERE b.ISBN = :ISBN"),
    @NamedQuery(name = "BookDO.findByIsbn", query = "SELECT b FROM BookDO b WHERE b.ISBN = :ISBN"),
    @NamedQuery(name = "BookDO.findByTitle", query = "SELECT b FROM BookDO b WHERE b.title like :title"),
    @NamedQuery(name = "BookDO.findByAuthor", query = "SELECT b FROM BookDO b WHERE b.author like :author"),
    @NamedQuery(name = "BookDO.findByEditorial", query = "SELECT b FROM BookDO b WHERE b.editorial like :editorial"),
    @NamedQuery(name = "BookDO.modifyPrice", query = "UPDATE BookDO b SET b.price= :price WHERE b.ISBN= :ISBN"),
    @NamedQuery(name = "BookDO.modifyBook", query = "UPDATE BookDO b SET b.author = :author, b.title= :title, b.editorial= :editorial, b.publicationYear= :publicationYear, b.price= :price, b.description = :description WHERE b.ISBN= :ISBN"),
    @NamedQuery(name = "BookDO.findAllAuthors", query = "SELECT DISTINCT b.author FROM BookDO AS b"),
    @NamedQuery(name = "BookDO.findAllEditorials", query = "SELECT DISTINCT b.editorial FROM BookDO AS b")
})
public class BookDO implements IBookDO{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ID;
    //@Size(max = 50)
    @Column(name = "TITULO")
    private String title;
    //@Size(max = 50)
    @Column(name = "AUTOR")
    private String author;
    //@Size(max = 50)
    @Column(name = "EDITORIAL")
    private String editorial;
    //@Size(max = 20)
    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "PUBLICACION")
    private Integer publicationYear;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double price;
    //@Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String description;
    
    
    /**
     * Empty default contructor
     */
    public BookDO() {
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
    public BookDO(int ID, String title, String author, String editorial, String ISBN, int publicationYear, double price, String description) {
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
    
    public int getID() {
        return this.ID;
    }

    /**
     * ID setter
     *
     * @param ID the Book ID
     */
    
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Title getter
     *
     * @return the Book Title
     */
    
    public String getTitle() {
        return this.title;
    }

    /**
     * Title setter
     *
     * @param title the Book Title
     */
    
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Author getter
     * @return the Author
     */
    
    public String getAuthor() {
        return this.author;
    }

    /**
     * Author setter
     * @param author the Author
     */
    
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Editorial getter
     *
     * @return the Book Editorial
     */
    
    public String getEditorial() {
        return this.editorial;
    }

    /**
     * Book setter
     *
     * @param editorial the Book Editorial
     */
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * ISBN getter
     *
     * @return the Book ISNB
     */
    
    public String getISBN() {
        return this.ISBN;
    }

    /**
     * ISBN setter
     *
     * @param ISBN the Book ISBN
     */
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Publication Year getter
     *
     * @return the Book Publication Year
     */
    
    public int getPublicationYear() {
        return this.publicationYear;
    }

    /**
     * Publication Year setter
     *
     * @param publicationYear the Book Publication Year
     */
    
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Price getter
     *
     * @return the Book Price
     */
    
    public double getPrice() {
        return this.price;
    }

    /**
     * Price setter
     *
     * @param price the Book Price
     */
    
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Description getter
     *
     * @return the Book Description
     */
    
    public String getDescription() {
        return this.description;
    }

    /**
     * Description setter
     *
     * @param description the Book Description
     */
    
    public void setDescription(String description) {
        this.description = description;
    }

    
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

    
    public boolean equals(Object obj) {
        if(!(obj instanceof BookDO)) return false;
        return (this.ISBN == null ? ((BookDO)obj).ISBN == null : this.ISBN.equals(((BookDO)obj).ISBN));
    }

    
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