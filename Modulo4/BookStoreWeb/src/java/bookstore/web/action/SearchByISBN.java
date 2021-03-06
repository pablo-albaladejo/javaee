package bookstore.web.action;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.service.ServiceFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class SearchByISBN extends HttpServlet {

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String ISBN = request.getParameter("ISBN");
        if(ISBN != null){
            IBookBean book = ServiceFactory.getInstance().getBusinessFacade().getBookByISBN(ISBN);
            if(book != null){
                List<IBookBean> list = new ArrayList<IBookBean>();
                list.add(book);
                request.setAttribute("list", list);
            }            
            request.setAttribute("ISBN", ISBN);            
            request.getRequestDispatcher("/jsp/BooksList.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/jsp/ISBNSearchForm.jsp").forward(request, response);
        }
    }

}
