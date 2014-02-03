/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstorejar;

import bookstore.logic.facade.BusinessFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.naming.NamingException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @EJB(beanName="Saludo")
    static BusinessFacade businessFacade;
        
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here            
        List list = businessFacade.getAllBooks();
        
        System.out.println(list);
        
    }
    
}
