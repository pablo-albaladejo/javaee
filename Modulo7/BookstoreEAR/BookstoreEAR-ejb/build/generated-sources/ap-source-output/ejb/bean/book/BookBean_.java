package ejb.bean.book;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-02-17T01:05:14")
@StaticMetamodel(BookBean.class)
public class BookBean_ { 

    public static volatile SingularAttribute<BookBean, String> author;
    public static volatile SingularAttribute<BookBean, String> title;
    public static volatile SingularAttribute<BookBean, Double> price;
    public static volatile SingularAttribute<BookBean, String> editorial;
    public static volatile SingularAttribute<BookBean, String> ISBN;
    public static volatile SingularAttribute<BookBean, String> description;
    public static volatile SingularAttribute<BookBean, Integer> ID;
    public static volatile SingularAttribute<BookBean, Integer> publicationYear;

}