/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.web.action;

import bookstore.logic.service.ServiceFactory;
import bookstore.model.book.IBookBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
        request.setAttribute("list", list);
              
        request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
    }
}
