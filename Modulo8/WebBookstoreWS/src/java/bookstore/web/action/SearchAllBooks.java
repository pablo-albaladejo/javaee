package bookstore.web.action;

import bookstore.web.ws.WSManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.dto.bean.book.IBookBean;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class SearchAllBooks extends HttpServlet {
    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<IBookBean> list = new ArrayList<IBookBean>(Arrays.asList(WSManager.getInstance().getPort().getAllBooks()));
        request.setAttribute("list", list);
              
        request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
    }
}
