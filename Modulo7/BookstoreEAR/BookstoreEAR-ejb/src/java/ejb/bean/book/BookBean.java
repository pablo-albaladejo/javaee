package ejb.bean.book;

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
 * <code>{@link IBookBean}</code> interface.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Entity
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookBean.findAll", query = "SELECT b FROM BookBean b"),
    @NamedQuery(name = "BookBean.deleteByIsbn", query = "DELETE FROM BookBean b WHERE b.ISBN = :ISBN"),
    @NamedQuery(name = "BookBean.findByIsbn", query = "SELECT b FROM BookBean b WHERE b.ISBN = :ISBN"),
    @NamedQuery(name = "BookBean.findByTitle", query = "SELECT b FROM BookBean b WHERE b.title like :title"),
    @NamedQuery(name = "BookBean.findByAuthor", query = "SELECT b FROM BookBean b WHERE b.author like :author"),
    @NamedQuery(name = "BookBean.findByEditorial", query = "SELECT b FROM BookBean b WHERE b.editorial like :editorial"),
    @NamedQuery(name = "BookBean.modifyPrice", query = "UPDATE BookBean b SET b.price= :price WHERE b.ISBN= :ISBN"),
    @NamedQuery(name = "BookBean.modifyBook", query = "UPDATE BookBean b SET b.author = :author, b.title= :title, b.editorial= :editorial, b.publicationYear= :publicationYear, b.price= :price, b.description = :description WHERE b.ISBN= :ISBN"),
    @NamedQuery(name = "BookBean.findAllAuthors", query = "SELECT DISTINCT b.author FROM BookBean AS b"),
    @NamedQuery(name = "BookBean.findAllEditorials", query = "SELECT DISTINCT b.editorial FROM BookBean AS b")
    
})
public class BookBean implements IBookBean {

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