package ws.publish;

import javax.xml.ws.Endpoint;
import ws.logic.facade.BusinessFacade;

/**
 *
 * @author palbaladejo
 */
public class PublishWebservice {
    public static void main(String[] args) {
        String address = "http://127.0.0.1:9876/bookstore";
        Endpoint.publish(address, new BusinessFacade());   
    }
}
