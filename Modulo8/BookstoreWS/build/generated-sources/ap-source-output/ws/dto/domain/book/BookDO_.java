package ws.dto.domain.book;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-10T18:48:29")
@StaticMetamodel(BookDO.class)
public class BookDO_ { 

    public static volatile SingularAttribute<BookDO, String> author;
    public static volatile SingularAttribute<BookDO, String> title;
    public static volatile SingularAttribute<BookDO, Double> price;
    public static volatile SingularAttribute<BookDO, String> editorial;
    public static volatile SingularAttribute<BookDO, String> ISBN;
    public static volatile SingularAttribute<BookDO, String> description;
    public static volatile SingularAttribute<BookDO, Integer> ID;
    public static volatile SingularAttribute<BookDO, Integer> publicationYear;

}