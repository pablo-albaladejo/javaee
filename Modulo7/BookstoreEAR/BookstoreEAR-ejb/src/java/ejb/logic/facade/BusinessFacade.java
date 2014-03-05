package ejb.logic.facade;


import java.util.List;
import ejb.bean.book.IBookBean;
import ejb.logic.service.ServiceFactory;
import javax.ejb.Stateless;



/**
 * This class implements the
 * <code>{@link IBusinessFacade}</code>. It also implements the Facade Pattern
 * and provides a single view from the logic layer to the presentation layer.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
@Stateless(name="Facade")
public class BusinessFacade implements IBusinessFacade { 
    
     public BusinessFacade() {
    }

    /**
     * Adds a new Book to the DDBB
     *
     * @param Book The Book transfer to be added
     * @return  <code>true</code> if the book is propertly added;
     * <code>false</code> otherwise
     */
    @Override
    public boolean NewBook(IBookBean Book) {
        return ServiceFactory.getInstance().getBookService().NewBook(Book);
    }

    /**
     * Removes a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return  <code>true</code> if the Book is propertly deleted;
     * <code>flase</code> otherwise
     */
    @Override
    public boolean DeleteBook(String ISBN) {
        return ServiceFactory.getInstance().getBookService().DeleteBook(ISBN);
    }

    /**
     * Searches all the Books stored at the persistence
     *
     * @return The <code>{@link IBookBean}</code> list including all the Books;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getAllBooks() {
        return ServiceFactory.getInstance().getBookService().getAllBooks();
    }

    /**
     * Searches a Book from the persistence identified by the ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @return The <code>{@link IBookBean}</code> if it is found; <code>null</code>
     * if the Book is not found.
     */
    @Override
    public IBookBean getBookByISBN(String ISBN) {
        return ServiceFactory.getInstance().getBookService().getBookByISBN(ISBN);
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Title
     *
     * @param title The Book title
     * @return The <code>{@link IBookBean}</code> list filtered by title;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByTitle(String title) {
        return ServiceFactory.getInstance().getBookService().getBookByTitle(title);
    }

    /**
     * Modifies the price of the Book identified by the provded ISBN
     *
     * @param ISBN The string which defines a unique Book identifier
     * @param price The new price to be updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBookPrice(String ISBN, double price) {
        return ServiceFactory.getInstance().getBookService().ModifyBookPrice(ISBN, price);
    }

    /**
     * Modifies the whole data stored into the DDBB
     *
     * @param Book The <code>{@link IBookBean}</code> to including the data to be
     * updated
     * @return <code>true</code> if the books is updated; <code>false</code>
     * otherwise
     */
    @Override
    public boolean ModifyBook(IBookBean Book) {
        return ServiceFactory.getInstance().getBookService().ModifyBook(Book);
    }

    /**
     * Searches all the Authors stored at the persistence
     *
     * @return The <code>String</code> list including all the Authors;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllAuthors() {
        return ServiceFactory.getInstance().getBookService().getAllAuthors();
    }

    /**
     * Searches a list of existing Books at the persistence identified by the
     * Author
     *
     * @param name The Book author
     * @return The <code>{@link IBookBean}</code> list filtered by author;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByAuthor(String name) {
        return ServiceFactory.getInstance().getBookService().getBookByAuthor(name);
    }

    /**
     * Searches all the Editorials stored at the persistence
     *
     * @return The <code>String</code> list including all the Editorials;
     * <code>null</code> if no Author is found.
     */
    @Override
    public List<String> getAllEditorials(){
        return ServiceFactory.getInstance().getBookService().getAllEditorials();
    }
    
    /**
     * Searches a list of existing Books at the persistence identified by the
     * Editorial
     *
     * @param editorial The Book editorial
     * @return The <code>{@link IBookBean}</code> list filtered by editorial;
     * <code>null</code> if no Book is found.
     */
    @Override
    public List<IBookBean> getBookByEditorial(String editorial) {
        return ServiceFactory.getInstance().getBookService().getBookByEditorial(editorial);
    }
    
    
//    private EntityManagerFactory emf; 
//    
//    @PostConstruct
//    public void InitEntityManagerFactory() {
//        emf = Persistence.createEntityManagerFactory("BookstorePU");
//    }
//
//    
//    public BusinessFacade() {
//        
//    }
//
//    /**
//     * Adds a new Book to the DDBB
//     *
//     * @param Book The Book transfer to be added
//     * @return  <code>true</code> if the book is propertly added;
//     * <code>false</code> otherwise
//     */
//    @Override
//    public boolean NewBook(IBookBean Book) {
//        boolean result = true;
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        try{
//            et.begin();
//            em.persist(Book);
//            et.commit();
//        }catch(Exception e){
//            result = false;
//            try{
//                et.rollback();
//            }catch(Exception ee){
//            }
//        }finally{
//            em.close();
//        }
//        return result;
//    }
//
//    /**
//     * Removes a Book from the persistence identified by the ISBN
//     *
//     * @param ISBN The string which defines a unique Book identifier
//     * @return  <code>true</code> if the Book is propertly deleted;
//     * <code>flase</code> otherwise
//     */
//    @Override
//    public boolean DeleteBook(String ISBN) {
//        boolean result = true;
//        if(this.getBookByISBN(ISBN) == null){
//            result = false;
//        }else{
//            EntityManager em = emf.createEntityManager();
//            EntityTransaction et = em.getTransaction();
//            try{
//                et.begin();
//                em.createNamedQuery("BookBean.deleteByIsbn")
//                    .setParameter("ISBN", ISBN)
//                    .executeUpdate();
//                et.commit();
//            }catch(Exception e){
//                result = false;
//                try{
//                    et.rollback();
//                }catch(Exception ee){
//                }
//            }finally{
//                em.close();
//            }
//        }
//        return result;
//    }
//
//    /**
//     * Searches all the Books stored at the persistence
//     *
//     * @return The <code>{@link BookBean}</code> list including all the Books;
//     * <code>null</code> if no Book is found.
//     */
//    @Override
//    public List<IBookBean> getAllBooks() {
//        EntityManager em = emf.createEntityManager();
//            
//        List<IBookBean> list = em.createNamedQuery("BookBean.findAll").getResultList();
//        
//        em.close();
//        
//        return list;
//    }
//
//    /**
//     * Searches a Book from the persistence identified by the ISBN
//     *
//     * @param ISBN The string which defines a unique Book identifier
//     * @return The <code>{@link BookBean}</code> if it is found; <code>null</code>
//     * if the Book is not found.
//     */
//    @Override
//    public IBookBean getBookByISBN(String ISBN) {
//        EntityManager em = emf.createEntityManager();
//            
//        List<IBookBean> list = em.createNamedQuery("BookBean.findByIsbn")
//                .setParameter("ISBN", ISBN)
//                .getResultList();
//        em.close();
//        if(list.isEmpty()){
//            return null;
//        }else{
//            return list.get(0);
//        }
//    }
//
//    /**
//     * Searches a list of existing Books at the persistence identified by the
//     * Title
//     *
//     * @param title The Book title
//     * @return The <code>{@link IBookBean}</code> list filtered by title;
//     * <code>null</code> if no Book is found.
//     */
//    @Override
//    public List<IBookBean> getBookByTitle(String title) {
//        EntityManager em = emf.createEntityManager();
//            
//        List<IBookBean> list = em.createNamedQuery("BookBean.findByTitle")
//                                .setParameter("title", "%" + title + "%")
//                                .getResultList();        
//        em.close();
//        
//        return list;
//    }
//
//    /**
//     * Modifies the price of the Book identified by the provded ISBN
//     *
//     * @param ISBN The string which defines a unique Book identifier
//     * @param price The new price to be updated
//     * @return <code>true</code> if the books is updated; <code>false</code>
//     * otherwise
//     */
//    @Override
//    public boolean ModifyBookPrice(String ISBN, double price) {
//        boolean result = true;
//        if(this.getBookByISBN(ISBN) == null){
//            result = false;
//        }else{
//            EntityManager em = emf.createEntityManager();
//            EntityTransaction et = em.getTransaction();
//            try{
//                et.begin();
//                em.createNamedQuery("BookBean.modifyPrice")
//                        .setParameter("ISBN", ISBN)
//                        .setParameter("price", price)
//                        .executeUpdate();
//                et.commit();
//            }catch(Exception e){
//                result = false;
//                try{
//                    et.rollback();
//                }catch(Exception ee){
//                }
//            }finally{
//                em.close();
//            }
//        }
//        return result;
//    }
//
//    /**
//     * Modifies the whole data stored into the DDBB
//     *
//     * @param Book The <code>{@link IBookBean}</code> to including the data to be
//     * updated
//     * @return <code>true</code> if the books is updated; <code>false</code>
//     * otherwise
//     */
//    @Override
//    public boolean ModifyBook(IBookBean Book) {
//        boolean result = true;
//        IBookBean OldBook = this.getBookByISBN(Book.getISBN());
//        if(OldBook == null){
//            result = false;
//        }else{
//            CopyBean(Book,OldBook);
//            EntityManager em = emf.createEntityManager();
//            EntityTransaction et = em.getTransaction();
//            try{
//                et.begin();
//                em.merge(OldBook);
//                et.commit();
//            }catch(Exception e){
//                result = false;
//                e.printStackTrace();
//                try{
//                    et.rollback();
//                }catch(Exception ee){
//                }
//            }finally{
//                em.close();
//            }
//        }
//        return result;
//    }
//
//    /**
//     * Searches all the Authors stored at the persistence
//     *
//     * @return The <code>String</code> list including all the Authors;
//     * <code>null</code> if no Author is found.
//     */
//    @Override
//    public List<String> getAllAuthors() {
//        EntityManager em = emf.createEntityManager();
//            
//        List<String> list = em.createNamedQuery("BookBean.findAllAuthors")
//                                .getResultList();
//        
//        em.close();
//        
//        return list;
//    }
//
//    /**
//     * Searches a list of existing Books at the persistence identified by the
//     * Author
//     *
//     * @param author The Book author
//     * @return The <code>{@link BookBean}</code> list filtered by author;
//     * <code>null</code> if no Book is found.
//     */
//    @Override
//    public List<IBookBean> getBookByAuthor(String author) {
//        EntityManager em = emf.createEntityManager();
//            
//        List<IBookBean> list = em.createNamedQuery("BookBean.findByAuthor")
//                                .setParameter("author", "%" + author + "%")
//                                .getResultList();
//        
//        em.close();
//        
//        return list;
//    }
//
//    /**
//     * Searches all the Editorials stored at the persistence
//     *
//     * @return The <code>String</code> list including all the Editorials;
//     * <code>null</code> if no Author is found.
//     */
//    @Override
//    public List<String> getAllEditorials(){
//        EntityManager em = emf.createEntityManager();
//            
//        List<String> list = em.createNamedQuery("BookBean.findAllEditorials").getResultList();
//        
//        em.close();
//        
//        return list;
//    }
//    
//    /**
//     * Searches a list of existing Books at the persistence identified by the
//     * Editorial
//     *
//     * @param editorial The Book editorial
//     * @return The <code>{@link BookBean}</code> list filtered by editorial;
//     * <code>null</code> if no Book is found.
//     */
//    @Override
//    public List<IBookBean> getBookByEditorial(String editorial) {
//        EntityManager em = emf.createEntityManager();
//            
//        List<IBookBean> list = em.createNamedQuery("BookBean.findByEditorial")
//                .setParameter("editorial", "%" + editorial + "%")
//                .getResultList();
//        
//        em.close();
//        
//        return list;
//    }
//    
//    private void CopyBean(IBookBean source, IBookBean copy){
//        copy.setAuthor(source.getAuthor());
//        copy.setDescription(source.getDescription());
//        copy.setEditorial(source.getEditorial());
//        copy.setISBN(source.getISBN());
//        copy.setPrice(source.getPrice());
//        copy.setPublicationYear(source.getPublicationYear());
//        copy.setTitle(source.getTitle());
//    }
}
