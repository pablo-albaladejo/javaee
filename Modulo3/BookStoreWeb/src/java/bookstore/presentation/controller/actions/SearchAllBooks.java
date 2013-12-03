/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.presentation.controller.actions;

import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.book.ITBook;
import bookstore.presentation.controller.HTMLHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String HTMLresponse = "";
        
        List<ITBook> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();

        List<String> headers = new ArrayList<String>();
        headers.add("Title");
        headers.add("Author");
        headers.add("Editorial");
        headers.add("ISBN");
        headers.add("Publication Year");
        headers.add("Price");
        headers.add("Descripcion");

        List<List<String>> rows = new ArrayList<>();

        for (ITBook book : list) {
            List<String> cells = new ArrayList<String>();
            cells.add(book.getTitle());
            cells.add(book.getAuthor());
            cells.add(book.getEditorial());
            cells.add(book.getISBN());
            cells.add(Integer.toString(book.getPublicationYear()));
            cells.add(Double.toString(book.getPrice()));
            cells.add(book.getDescription());
            rows.add(cells);
        }
        HTMLresponse += HTMLHelper.getHTMLTable(headers, rows);
        
        HTMLresponse += HTMLHelper.getHTMLActionButton("Back","../");
        out.println(HTMLresponse);

        out.close();
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
