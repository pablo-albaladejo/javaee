package ejb.bean.book;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T01:05:14")
@StaticMetamodel(Libros.class)
public class Libros_ { 

    public static volatile SingularAttribute<Libros, Integer> id;
    public static volatile SingularAttribute<Libros, String> titulo;
    public static volatile SingularAttribute<Libros, String> autor;
    public static volatile SingularAttribute<Libros, String> editorial;
    public static volatile SingularAttribute<Libros, Double> precio;
    public static volatile SingularAttribute<Libros, String> isbn;
    public static volatile SingularAttribute<Libros, Integer> publicacion;
    public static volatile SingularAttribute<Libros, String> descripcion;

}