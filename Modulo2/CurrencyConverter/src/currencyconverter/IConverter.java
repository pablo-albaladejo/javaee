package currencyconverter;

import java.rmi.RemoteException;

/**
 *
 * @author <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public interface IConverter extends java.rmi.Remote{
    public double fromPesetasToPounds(double pesetas) throws RemoteException;
    public double fromPesetasToEuros(double pesetas) throws RemoteException;
    public double fromPesetasToDollars(double pesetas) throws RemoteException;
    
    public double fromPoundsToPesetas(double pounds) throws RemoteException;
    public double fromPoundsToEuros(double pounds) throws RemoteException;
    public double fromPoundsToDollars(double pounds) throws RemoteException;
    
    public double fromEurosToPesetas(double euros) throws RemoteException  ;
    public double fromEurosToPounds(double euros) throws RemoteException;
    public double fromEurosToDollars(double euros) throws RemoteException;
    
    public double fromDollarsToPesetas(double dollars) throws RemoteException;
    public double fromDollarsToPounds(double dollars) throws RemoteException;
    public double fromDollarsToEuros(double dollars) throws RemoteException;
}
