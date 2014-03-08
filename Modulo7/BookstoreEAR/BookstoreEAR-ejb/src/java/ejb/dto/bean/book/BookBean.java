/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.bean.book;

import java.util.Objects;

/**
 *
 * @author palbaladejo
 */
public class BookBean implements IBookBean{
    private static final long serialVersionUID = 1L;
    
    private String title;
    private String author;
    private String editorial;
    private String ISBN;
    private Integer publicationYear;
    private Double price;
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
    public BookBean(String title, String author, String editorial, String ISBN, int publicationYear, double price, String description) {
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.price = price;
        this.description = description;
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
        return  this.title + ", "
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.title);
        hash = 23 * hash + Objects.hashCode(this.author);
        hash = 23 * hash + Objects.hashCode(this.editorial);
        hash = 23 * hash + Objects.hashCode(this.ISBN);
        hash = 23 * hash + Objects.hashCode(this.publicationYear);
        hash = 23 * hash + Objects.hashCode(this.price);
        hash = 23 * hash + Objects.hashCode(this.description);
        return hash;
    }

    

    
}
