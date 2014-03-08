/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.dto.domain.book;

/**
 *
 * @author palbaladejo
 */
public interface IBookDO {
    /**
     * ID getter
     * @return the Book ID
     */
    int getID();
    /**
     * ID setter
     * @param ID the Book ID 
     */
   void setID(int ID);

    /**
     * Title getter
     * @return the Book Title
     */
    String getTitle();
    /**
     * Title setter
     * @param title the Book Title
     */
    void setTitle(String title);

    /**
     * Author getter
     * @return the Author
     */
    String getAuthor();
    /**
     * Author setter
     * @param author the Author
     */
    void setAuthor(String author);

    /**
     * Editorial getter
     * @return the Book Editorial
     */
    String getEditorial();
    /**
     * Book setter
     * @param editorial the Book Editorial
     */
    void setEditorial(String editorial);

    /**
     * ISBN getter
     * @return the Book ISNB
     */
    String getISBN();
    /**
     * ISBN setter
     * @param ISBN the Book ISBN
     */
    void setISBN(String ISBN);

    /**
     * Publication Year getter
     * @return the Book Publication Year
     */
    int getPublicationYear();
    /**
     * Publication Year setter
     * @param publicationYear the Book Publication Year
     */
    void setPublicationYear(int publicationYear);

    /**
     * Price getter
     * @return the Book Price
     */
    double getPrice();
    /**
     * Price setter
     * @param price the Book Price
     */
    void setPrice(double price);

    /** 
     * Description getter
     * @return the Book Description
     */
    String getDescription();
    /**
     * Description setter
     * @param description the Book Description
     */
    void setDescription(String description);
}
