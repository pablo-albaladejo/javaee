package currencyconverter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Esta clase implementa el conversor de moneda. Para mayor consistencia 
 * y mantenibilidad del software, solo las relaciones de dolar con el resto de
 * monedas son declaradas y el resto son inferidas.
 * Para las conversiones entre monedas que no implican el dolar, se hace una
 * conversión intermedia a dolares. De esta manera, ante nuevas cotizaciones,
 * solo deben modificarse una relación y las demás son automáticamente inferidas.
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class ConverterImp extends UnicastRemoteObject implements IConverter{

    private final double dollarsPerPeseta = 0.0081296952941884; //1 pta =  0.0081296952941884 dollar
    private final double dollarsPerPound = 1.6089; // 1 pound  = 1.6089 dollar
    private final double dollarsPerEuro = 1.3429; // 1 euro = 1.3429 dollar
    private final double pesetasPerDollar = 1.0/dollarsPerPeseta;
    private final double poudsPerDollar = 1.0/dollarsPerPound;
    private final double eurosPerDollar = 1.0/dollarsPerEuro;
    
    public ConverterImp() throws RemoteException{
        super();
    }
    
    @Override
    public double fromPesetasToPounds(double pesetas) throws RemoteException {
        return this.fromPesetasToDollars(pesetas)*this.poudsPerDollar;
    }

    @Override
    public double fromPesetasToEuros(double pesetas) throws RemoteException {
        return this.fromPesetasToDollars(pesetas)*this.eurosPerDollar;
    }

    @Override
    public double fromPesetasToDollars(double pesetas) throws RemoteException {
        return pesetas*this.dollarsPerPeseta;
    }

    @Override
    public double fromPoundsToPesetas(double pounds) throws RemoteException {
        return this.fromPoundsToDollars(pounds)*this.pesetasPerDollar;
    }

    @Override
    public double fromPoundsToEuros(double pounds) throws RemoteException {
        return this.fromPoundsToDollars(pounds)*this.eurosPerDollar;
    }

    @Override
    public double fromPoundsToDollars(double pounds) throws RemoteException {
        return pounds*this.dollarsPerPound;
    }

    @Override
    public double fromEurosToPesetas(double euros) throws RemoteException {
        return this.fromEurosToDollars(euros)*this.pesetasPerDollar;
    }

    @Override
    public double fromEurosToPounds(double euros) throws RemoteException {
        return this.fromEurosToDollars(euros)*this.poudsPerDollar;
    }

    @Override
    public double fromEurosToDollars(double euros) throws RemoteException {
        return euros*this.dollarsPerEuro;
    }

    @Override
    public double fromDollarsToPesetas(double dollars) throws RemoteException {
        return dollars*this.pesetasPerDollar;
    }

    @Override
    public double fromDollarsToPounds(double dollars) throws RemoteException {
        return dollars*this.poudsPerDollar;
    }

    @Override
    public double fromDollarsToEuros(double dollars) throws RemoteException {
        return dollars*this.eurosPerDollar;
    }
}
