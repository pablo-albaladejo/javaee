package bookstore.presentation.controller.actions;

import bookstore.logic.bean.book.IBookBean;
import bookstore.logic.service.ServiceFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class ManageDDBB extends HttpServlet {

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
        String action = request.getParameter("action");
        if(action != null){
            
        }else{
            List<IBookBean> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/jsp/ManageDDBB.jsp").forward(request, response);
        }
    }

}
