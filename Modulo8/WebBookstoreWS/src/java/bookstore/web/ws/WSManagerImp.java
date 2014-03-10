/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.web.ws;

import static java.lang.System.exit;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.logic.facade.IBusinessFacade;

/**
 *
 * @author palbaladejo
 */
public class WSManagerImp extends WSManager{

    private IBusinessFacade port;
    
    public WSManagerImp() {
        try {
            URL url = new URL("http://127.0.0.1:9876/bookstore");
            QName qname = new QName("http://facade.logic.ws/","BusinessFacadeService");
            Service service = Service.create(url,qname);
            port = service.getPort(IBusinessFacade.class);
        } catch (MalformedURLException ex) {
            exit(-1);
        }
    }

    @Override
    public IBusinessFacade getPort() {
        return this.port;
    }
    
}
