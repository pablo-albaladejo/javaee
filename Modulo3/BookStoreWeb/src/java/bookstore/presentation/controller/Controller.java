/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.presentation.controller;

import bookstore.logic.service.ServiceFactory;
import bookstore.logic.transfer.book.ITBook;
import bookstore.presentation.controller.events.BusinessEvent;
import bookstore.presentation.controller.events.GUIEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class Controller extends HttpServlet {

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

        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int action = 0;
        
        Element data = openResponse();

        switch (Integer.parseInt(request.getParameter("action"))) {
            case BusinessEvent.GET_ALL_BOOKS:
                List<ITBook> list = ServiceFactory.getInstance().getBusinessFacade().getAllBooks();
                for (ITBook book : list) {
                    data.appendChild(bookToXML(data.getOwnerDocument(), book));
                }
                action = GUIEvent.REFRESH_ALL_BOOKS;
                break;
            default:
                break;
        }
        closeResponse(data,action);
        
        out.println(nodeToString(data.getOwnerDocument().getDocumentElement()));
    }

    private Element openResponse() {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "response", null);
        } catch (ParserConfigurationException ex) {
        }

        return createNode(document.getDocumentElement(), "data");
    }
    
    private void closeResponse(Element object, int action){
        addNode(object.getOwnerDocument().getDocumentElement(), "action", Integer.toString(action));
        object.getOwnerDocument().getDocumentElement().appendChild(object);
    }

    private Element bookToXML(Document document, ITBook book) {
        Element node = document.createElement("book");
        addNode(node, "title", book.getTitle());
        addNode(node, "author", book.getAuthor());
        addNode(node, "editorial", book.getEditorial());
        addNode(node, "ISBN", book.getISBN());
        addNode(node, "publicationYear", Integer.toString(book.getPublicationYear()));
        addNode(node, "price", Double.toString(book.getPrice()));
        addNode(node, "description", book.getDescription());
        node.setAttribute("id", Integer.toString(book.getID()));
        return node;
    }

    private void addNode(Element element, String name, String value) {
        Text text = element.getOwnerDocument().createTextNode(value);
        Element node = element.getOwnerDocument().createElement(name);
        node.appendChild(text);
        element.appendChild(node);
    }

    private Element createNode(Element element, String name) {
        return element.getOwnerDocument().createElement(name);
    }

    public static String nodeToString(Node node) {
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (Exception e) {
            return "";
        }
        return sw.toString();
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
