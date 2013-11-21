package currencyconverter;

import java.rmi.RMISecurityManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class Server {
    public static final int port = 1099;
    public static void main(String[] args) {
        
        try {
            //1 - Crear administrador de seguridad
            System.setSecurityManager(new RMISecurityManager());
        
            //2 - Registar el objeto remoto
            java.rmi.registry.LocateRegistry.createRegistry(port);
            ConverterImp myConverter = new ConverterImp();
            java.rmi.Naming.rebind("CurrencyConverter", myConverter);
            
            //3 - Mensaje de objeto publicado
            System.out.println("Objeto publicado");
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
