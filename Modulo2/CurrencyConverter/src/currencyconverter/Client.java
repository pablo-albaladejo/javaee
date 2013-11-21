package currencyconverter;

import java.rmi.Naming;
import java.rmi.Remote;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class Client {
    public static final int port = 1099;
    public static void main(String[] args) {
        try{
            Remote remoteObject = Naming.lookup("rmi://localhost:"+port+"/CurrencyConverter");
            IConverter myConverter = (IConverter)remoteObject;
           
            double units = 1;
            double result;
            
            System.out.println("------------Dollars-----------------");
            result = myConverter.fromDollarsToEuros(units);
            System.out.println(units + " dollar(s) -> " + result + " euro(s)");
            
            result = myConverter.fromDollarsToPesetas(units);
            System.out.println(units + " dollar(s) -> " + result + " peseta(s)");
            
            result = myConverter.fromDollarsToPounds(units);
            System.out.println(units + " dollar(s) -> " + result + " pound(s)");
            
            System.out.println("------------Pounds-----------------");
            result = myConverter.fromPoundsToEuros(units);
            System.out.println(units + " pound(s) -> " + result + " euro(s)");
            
            result = myConverter.fromPoundsToPesetas(units);
            System.out.println(units + " pound(s) -> " + result + " peseta(s)");
            
            result = myConverter.fromPoundsToDollars(units);
            System.out.println(units + " pound(s) -> " + result + " dollar(s)");
            
            System.out.println("------------Euros-----------------");
            result = myConverter.fromEurosToPounds(units);
            System.out.println(units + " euros(s) -> " + result + " pound(s)");
            
            result = myConverter.fromEurosToPesetas(units);
            System.out.println(units + " euros(s) -> " + result + " peseta(s)");
            
            result = myConverter.fromEurosToDollars(units);
            System.out.println(units + " euros(s) -> " + result + " dollar(s)");
            
            System.out.println("------------Pesetas-----------------");
            result = myConverter.fromPesetasToPounds(units);
            System.out.println(units + " peseta(s) -> " + result + " pound(s)");
            
            result = myConverter.fromPesetasToEuros(units);
            System.out.println(units + " peseta(s) -> " + result + " euro(s)");
            
            result = myConverter.fromPesetasToDollars(units);
            System.out.println(units + " peseta(s) -> " + result + " dollar(s)");
            
        }catch(Exception ex){
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
