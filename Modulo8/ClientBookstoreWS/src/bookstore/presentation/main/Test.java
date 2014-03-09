package bookstore.presentation.main;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.dto.bean.book.BookBean;
import ws.dto.bean.book.IBookBean;
import ws.dto.factory.DTOFactory;
import ws.logic.facade.IBusinessFacade;

/**
 *
 * @author palbaladejo
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:9876/bookstore");
        
        QName qname = new QName("http://facade.logic.ws/","BusinessFacadeService");
        
        Service service = Service.create(url,qname);
        
        IBusinessFacade port = service.getPort(IBusinessFacade.class);
        
//         String[] list = port.getAllEditorials();
//         BookBean[] books = port.getBookByEditorial(list[0]);
//        
//        System.out.println("editorial:" + list[0]);
//        System.out.println("libros: "+ books[0]);
        
        
        
        BookBean Book1 = (BookBean)DTOFactory.getInstance().getBookBean();            
        Book1.setTitle("Titulo");
        Book1.setAuthor("Autor 1");
        Book1.setEditorial("Editorial 1");
        Book1.setISBN("ISNB 1");
        Book1.setPrice(1.0);
        Book1.setPublicationYear(1);
        Book1.setDescription("Descripcion 1");
            
        BookBean Book2 = (BookBean)DTOFactory.getInstance().getBookBean();
        Book2.setTitle("Titulo");
        Book2.setAuthor("Autor 2");
        Book2.setEditorial("Editorial 2");
        Book2.setISBN("ISNB 2");
        Book2.setPrice(2.0);
        Book2.setPublicationYear(2);
        Book2.setDescription("Descripcion 2");
            
            
        IBookBean Book3 = null;
        boolean result = false;

        //Como precondición del test, se considera la BBDD creada y vacia.

        //Para comporbar el estado inicial de la BBDD
        listaLibros(port);

        //INSERT
        System.out.println("------------------------------");
        System.out.println("TESTANDO FUNCION ALTA LIBRO");
        System.out.print("\tInsertando libro... ");
            
            //Prueba Insert Nuevo Libro inexistente
            result = port.NewBook(Book1);
            if(!result){
                System.out.println("Error insertando!");
                System.out.println("FUNCION ALTA LIBRO KO!!");
            }else{
                System.out.println("Libro insertado con éxito!");
                
                //Prueba Insert Nuevo Libro ya existente
                System.out.print("\tInsertando el mismo libro otra vez... ");
                result = port.NewBook(Book1);
                if(!result){
                    System.out.println("Error insertando!");
                    System.out.print("\tInsertando el otro libro nuevo... ");
                    result = port.NewBook(Book2);
                    if(result){
                        System.out.println("Libro insertado con éxito!");
                        System.out.println("FUNCION ALTA LIBRO OK!!");
                    }else{
                        System.out.println("Error insertando!");
                        System.out.println("FUNCION ALTA LIBRO KO!!");
                    }
                }else{
                    System.out.println("Libro insertado con éxito!");
                    System.out.println("FUNCION ALTA LIBRO KO!!");
                }                
            }
            
            //Para comprobar que se han insertado los dos libros            
            listaLibros(port);
            
            //SEARCH BY TITLE
            listaLibrosPorTitulo(port,Book1.getTitle());
                        
            //DELETE
            System.out.println("------------------------------");
            System.out.println("TESTANDO FUNCION BAJA LIBRO");
            System.out.print("\tBorrando libro ya existente... ");
            result = port.DeleteBook(Book1.getISBN());
            if(result){
                System.out.println("Libro borrado con éxito!");
                //Probamos a borrar un libro inexsistente
                System.out.print("\tBorrando libro no existente... ");
                result = port.DeleteBook(Book1.getISBN());
                if(result){
                    System.out.println("Libro borrado con éxito!");
                    System.out.println("FUNCION BAJA LIBRO KO!!");    
                }else{
                    System.out.println("Error borrando!");
                    System.out.println("FUNCION BAJA LIBRO OK!!");
                }
            }else{
                System.out.println("Error borrando!");
                System.out.println("FUNCION BAJA LIBRO KO!!");
            }
            
            //Para comprobar que se ha borrado el primer libro
            listaLibros(port);
            
            //Modifica Precio
            System.out.println("------------------------------");
            System.out.println("TESTANDO FUNCION MODIFICA PRECIO POR ISBN");
            System.out.print("\tModificando precio de libro inexistente por ISBN... ");
            result = port.ModifyBookPrice(Book1.getISBN(), 1.1);
            if(result){
                System.out.println("Precio modificado!");
                System.out.println("FUNCION MODIFICA PRECIO POR ISBN KO!!");
            }else{
                System.out.println("Precio no modificado!");
                System.out.print("\tModificando precio de libro existente por ISBN... ");
                result = port.ModifyBookPrice(Book2.getISBN(), 2.2);
                if(result){
                    System.out.println("Precio modificado!");
                    System.out.println("FUNCION MODIFICA PRECIO POR ISBN OK!!");
                }else{
                    System.out.println("Precio no modificado!");
                    System.out.println("FUNCION MODIFICA PRECIO POR ISBN KO!!");
                }
            }
            //Para comprobar que se ha modificado el precio
            listaLibrosPorTitulo(port,Book2.getTitle());
            
            //SELECT BY ISBN
            System.out.println("------------------------------");
            System.out.println("TESTANDO FUNCION CONSULTA ISBN");
            System.out.print("\tSolicitando libro inexistente por ISBN... ");
            Book3 = port.getBookByISBN(Book1.getISBN());
            if(Book3 != null){
                System.out.println("Libro encontrado!");
                System.out.println("FUNCION CONSULTA ISBN KO!!");
            }else{
                System.out.println("Libro NO encontrado!");
                System.out.print("\tSolicitando libro existente por ISBN... ");
                Book3 = port.getBookByISBN(Book2.getISBN());
                if(Book3 == null){
                    System.out.println("Libro NO encontrado!");
                    System.out.println("FUNCION CONSULTA ISBN KO!!");
                }else{
                    System.out.println("Libro encontrado!");
                    System.out.println("FUNCION CONSULTA ISBN OK!!");
                }
            }
	}
        
        private static void listaLibros(IBusinessFacade port){
            BookBean BookList [] = null;
            
            //SELECT
            System.out.println("------------------------------");
            System.out.print("Buscando TODOS los libros... ");
            BookList = port.getAllBooks();
            if(BookList == null){
                System.out.println("No se han encontrado libros!");
            }else{
                System.out.println("Se han encontrado "+BookList.length +" libros");
                System.out.println("\tListado de Libros encontrados:");
                for(IBookBean Book : BookList){
                    System.out.println("\t\t"+Book);
                }    
            }
        }
        
        private static void listaLibrosPorTitulo(IBusinessFacade port, String Title){
            BookBean [] BookList = null;
            
            //SELECT
            System.out.println("------------------------------");
            System.out.print("Buscando TODOS los libros con título \"" + Title + "\"... ");
            BookList = port.getBookByTitle(Title);
            if(BookList == null){
                System.out.println("No se han encontrado libros!");
            }else{
                System.out.println("Se han encontrado "+BookList.length +" libros");
                System.out.println("\tListado de Libros encontrados:");
                for(IBookBean Book : BookList){
                    System.out.println("\t\t"+Book);
                }    
            }
        }
    
}
