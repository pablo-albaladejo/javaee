package bookstore.logic.transfer.book;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface ITBook {
    /**
     *
     * @return
     */
    int getID();
    /**
     *
     * @param ID
     */
    void setID(int ID);

    /**
     *
     * @return
     */
    String getTitle();
    /**
     *
     * @param title
     */
    void setTitle(String title);

    /**
     *
     * @return
     */
    String getAuthor();
    /**
     *
     * @param author
     */
    void setAuthor(String author);

    /**
     *
     * @return
     */
    String getEditorial();
    /**
     *
     * @param editorial
     */
    void setEditorial(String editorial);

    /**
     *
     * @return
     */
    String getISBN();
    /**
     *
     * @param ISBN
     */
    void setISBN(String ISBN);

    /**
     *
     * @return
     */
    int getPublicationYear();
    /**
     *
     * @param publicationYear
     */
    void setPublicationYear(int publicationYear);

    /**
     *
     * @return
     */
    double getPrice();
    /**
     *
     * @param price
     */
    void setPrice(double price);

    /**
     *
     * @return
     */
    String getDescription();
    /**
     *
     * @param description
     */
    void setDescription(String description);
}
