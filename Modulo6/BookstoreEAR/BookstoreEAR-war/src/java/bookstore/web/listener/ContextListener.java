package bookstore.web.listener;

import ejb.logic.facade.IBusinessFacade;
import ejb.model.book.IBookBean;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
@WebListener()
public class ContextListener implements ServletContextListener {

    @EJB(beanName="Facade")
    private IBusinessFacade facade;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String initParameter =  sce.getServletContext().getInitParameter("BookSuggestion");
        if(initParameter != null){
            IBookBean book = facade.getBookByISBN(initParameter);
            if(book != null){
                String msg = book.getTitle() +
                                " (" + book.getAuthor() + 
                                " , " + book.getEditorial() + ")";
                sce.getServletContext().setAttribute("BookSuggestion", msg);
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
