/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.presentation.controller.actions;

import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.author.ITAuthor;
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
public class SearchByAuthor extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String HTMLresponse = "";

        String name = request.getParameter("name");

        if (name == null) {//all authors
            
            HTMLresponse += HTMLHelper.getHTMLparagraph("Choose an Author:");
                    
            List<ITAuthor> list = ServiceFactory.getInstance().getBusinessFacade().getAllAuthors();

            List<String[]> attributes = new ArrayList<String[]>();
            attributes.add(new String[]{"id", "authors"});
            attributes.add(new String[]{"onChange", "searchAuthor(this.options[this.value].innerHTML);"});

            List<String[]> options = new ArrayList<String[]>();
            options.add(new String[]{"0", ""});

            for (ITAuthor author : list) {
                options.add(new String[]{Integer.toString(author.getID()), author.getName()});
            }
            HTMLresponse += HTMLHelper.getHTMLSelect(options, attributes);
        } else {//author books

            HTMLresponse += HTMLHelper.getHTMLHeader(name, 1);

            List<ITBook> list = ServiceFactory.getInstance().getBusinessFacade().getBookByAuthor(name);

            List<String> headers = new ArrayList<String>();
            headers.add("Titulo");
            headers.add("Editorial");
            headers.add("ISBN");
            headers.add("Publicacion");
            headers.add("Precio");
            headers.add("Descripcion");

            List<List<String>> rows = new ArrayList<>();

            for (ITBook book : list) {
                List<String> cells = new ArrayList<String>();
                cells.add(book.getTitle());
                cells.add(book.getEditorial());
                cells.add(book.getISBN());
                cells.add(Integer.toString(book.getPublicationYear()));
                cells.add(Double.toString(book.getPrice()));
                cells.add(book.getDescription());
                rows.add(cells);
            }

            HTMLresponse += HTMLHelper.getHTMLTable(headers, rows);
            
            List<String[]> attributes = new ArrayList<String[]>();
            attributes.add(new String[]{"onClick", "searchAuthor();"});
            
            HTMLresponse += HTMLHelper.getHTMLButton("Back",attributes);
            
        }
        out.println(HTMLresponse);
    }

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
        throw new ServletException("GET method not allowed");
    }
}
