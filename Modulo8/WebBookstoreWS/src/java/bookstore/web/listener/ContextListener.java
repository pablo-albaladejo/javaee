package bookstore.web.listener;

import bookstore.web.ws.WSManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import ws.dto.bean.book.IBookBean;

/**
 * Web application lifecycle listener.
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
@WebListener()
public class ContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String initParameter =  sce.getServletContext().getInitParameter("BookSuggestion");
        if(initParameter != null){
            IBookBean book = WSManager.getInstance().getPort().getBookByISBN(initParameter);
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
