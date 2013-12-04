package bookstore.presentation.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
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
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class HTMLHelper {
    
    public static String getHTMLActionButton(String caption, String action) {
        Element button = openDocument("form");
        button.setAttribute("action", action);

        Element input = createNode(button, "input");
        List<String[]> attributes = new ArrayList<String[]>();
        attributes.add(new String[]{"type", "submit"});
        attributes.add(new String[]{"value", caption});
        setAttributes(input, attributes);

        button.appendChild(input);
        return nodeToString(button);
    }

    public static String getHTMLparagraph(String text) {
        Element paragraph = openDocument("p");
        paragraph.setTextContent(text);
        return nodeToString(paragraph);
    }

    public static String getHTMLButton(String caption, List<String[]> attributes) {
        Element button = openDocument("button");

        button.setTextContent(caption);
        setAttributes(button, attributes);

        return nodeToString(button);
    }

    public static String getHTMLHeader(String header, int size) {
        if (size > 6) {
            size = 6;
        }
        if (size < 1) {
            size = 1;
        }

        Element h = openDocument("h" + Integer.toString(size));
        h.setTextContent(header);

        return nodeToString(h);
    }

    public static String getHTMLSelect(List<String[]> elements) {
        return getHTMLSelect(elements, null);
    }

    public static String getHTMLSelect(List<String[]> elements, List<String[]> attributes) {
        Element select = openDocument("select");

        setAttributes(select, attributes);

        for (String[] values : elements) {
            Element option = createNode(select, "option");
            option.setAttribute("value", values[0]);
            option.setTextContent(values[1]);
            select.appendChild(option);
        }

        return nodeToString(select);
    }

    public static String getHTMLTable(List<String> headers, List<List<String>> rows) {
        Element table = openDocument("table");
        //table.setAttribute("border", "1"); //TO BE REMOVED!!

        //Headers
        Element tr = createNode(table, "tr");
        for (String header : headers) {
            addNode(tr, "th", header);
        }
        table.appendChild(tr);

        //rows
        boolean odd = true;
        for (List<String> row : rows) {
            tr = createNode(table, "tr");
            String css = "odd"; if(!odd) css ="even"; odd = !odd;
            tr.setAttribute("class", css);
            //cells
            for (String cell : row) {
                Element td = createNode(table, "td");
                td.setTextContent(cell);
                tr.appendChild(td);
            }
            table.appendChild(tr);
        }

        return nodeToString(table);
    }

    private static Element openDocument(String name) {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, name, null);
        } catch (ParserConfigurationException ex) {
            return null;
        }
        return document.getDocumentElement();
    }

    private static Element createNode(Element element, String name) {
        return element.getOwnerDocument().createElement(name);
    }

    private static void addNode(Element element, String name, String value) {
        Text text = element.getOwnerDocument().createTextNode(value);
        Element node = element.getOwnerDocument().createElement(name);
        node.appendChild(text);
        element.appendChild(node);
    }

    private static String nodeToString(Node node) {
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

    private static void setAttributes(Element element, List<String[]> attributes) {
        if (attributes != null) {
            for (String[] attribute : attributes) {
                element.setAttribute(attribute[0], attribute[1]);
            }
        }
    }
}
