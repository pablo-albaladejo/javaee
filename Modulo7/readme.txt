/////////////////////////////////////////////////////////////////////////////////////
Version 7: Se elimina JDBC y se implementa el patron Domain Store mediante JPA.
------------------------- Modulo EJB -----------------------------------------
DTO (Data Transfer Objects):
- En esta vesion se ha querido mejorar el diseno de la arquitectura, haciendo explicita al diferencia entre DTOs de cliente(vista) y de negocio(dominio).
- Con ello se intenta desacoplar los detalles de la implementacion con los de la vista (y viceversa). De esta manera un cambio en la capa de persistenia no afecta a la vista (y viceversa).
- Espcialmente util por lazy binding y otros conceptos de ORMs.
- Por ello se han definido dos DTO principales
 + Bean: Son los objetos de transferencia entre la fachada y el cliente. 
  - Son serializables y estan diseñados como Java Beans.
 + DO (Domian Object): son los objetos de transferencia entre el modelo y la facha
  - Son objetos anotados como Entity y son los almacenados en el ORMs.
Logica de negocio:
- DTOMapper: Mappeo entre objetos del dominio y de la presentacion
Integracion:
- Uso de TransactionManager + NamedQuerys
Persistencia:
- Cambio de la capa de persistencia. Se introduce el uso de JPA (EclipseLink + MySQL)
- Uso del patron Almacen del Dominio (Domain Store).
- Implementacion en modo desconectado, multi-cliente y multi-hilo
------------------------- Modulo Cliente - JAR -------------------------------
Identico a la version 6, a excepcion de los nuevos imports.
------------------------- Modulo WEB - WAR -----------------------------------
Identico a la version 6, a excepcion de los nuevos imports.
------------------------------------------------------------------------------

No se ha modificado la estructura de la BBDD.
Se ha generado nuevo JavaDoc (uno nuevo por cada modulo).
/////////////////////////////////////////////////////////////////////////////////////
Version 6:
Version EJB de los versiones 1 y 4 de la practica:
------------------------- Modulo EJB -----------------------------------------
El modulo EJB ha dividio en 4 capas (obtenido la version 4) encapsulando:
Bean:
-Se sigue manteniendo como JavaBean las clase BookBean (objetos generados mediante factoria abstracta)
-La clase Cart pasa a ser un EJB Stateful remoto. Se gestiona mediate Inyeccion de Dependencia.
Logica de negocio:
-Se mantiene el Patron Facade + Singletone se implmenta ahora con un EJB Stateless remoto mediante Inyeccion de Dependencias.
-Se elimina de la del servicio de la aplicacion el acceso a la Facha del Negocio, que para a ser de uso solo interno.
Integracion:
-Se matienen los Data Access Object (BookDAO)
-Se mantiene la DAOFactory
Persistencia:
-Se mantiene la implementacion mediate pool de transacciones
------------------------- Modulo Cliente - JAR -------------------------------
Extraido de la version 1. Se eliminan el todas las capa menos:
Presentacion:
- Se sigue manteniendo el patron MVC.
- En el controlador, las llamadas a la logica de negocio (servicio de la aplicacion) a traves de la Fachada de Negocio,
pasan a hacerse a traves del EJB Facade definido el el Modulo EJB.
- La obtencion de los EJB se hace mediante llamadas al servicio JNDI (no se puede aplicar Inyeccion de Dependencias en clases no gestionadas por el contenedor)
- Se mantiene la clase de medoto main Test con identico resultado que en la version 1.
------------------------- Modulo WEB - WAR -----------------------------------
El diseno y el codigo usado es exactamente el de la version 4, a excepcion de:
Capa de Presentacion:
SERVER:
-En cada Servlet se cambia la llamada al Servicio de la aplicacion por una llamada al EJB remoto Facade.
-La gestion del carrito se hace ahora atraves de un EJB Stateful que se guarda en la sesion del cliente web.
-Dicho EJB se realiza se obtiene mediante JNDI debido a que la Inyeccion de Dependencias no se puede hacer a nivel de metodo,
y se necesita que el bean no sea un atributo de la clase servlet, puesto que si no se compartiria con todas lo exploradores que solicitasen el servlet.
(solo una bean de estado para un unico serlet, pero que se compartiria con todos lo hilos de ejecucion del servlet, esto es, con todas las peticiones de todos los clientes web)

CLIENTE:
-Los jsp no se modifican
------------------------------------------------------------------------------

No se ha modificado la estructura de la BBDD.
Se ha generado nuevo JavaDoc (uno nuevo por cada modulo).
/////////////////////////////////////////////////////////////////////////////////////
Version 5:
Se incluye el Framework Struts 1 (v1.2.7). Se ha adaptado todo el desarrollo para poder usar TODAS las funcionalidades del framework.
El diseno y el codigo usado es exactamente el de la version 4, a excepcion de:

Capa de Presentacion:
SERVER:
La implementacion de FrontController deja de hacerse por el Servlet (se elimina fichero) y se sustituye por el ActionServlet de struts.
Se elimina el registro del resto de servlets de web.xml y se anaden a struts-config.xml como actions.
Todos los servelts creados en el paquete actions, dejan de heredar de HttpServlet para heredar de Action (sustituyendo su metodo doPost por execute).

Para hacer mas facil el uso de ValidatorForms, se desconpone la accion y vista ManageDDBB en AddBook y en ModifyBook(edit y remove).
Se crea BookValidatorForm para ser usado en AddBook y ModifyBook.

Se anade un action SetLocale para poder gestionar la localizazion de la vista, 
y se anade un tipo de excepion personalizada AlreadyExistsException y un GenericExceptionHandler para poder hacer uso la capa de excepciones globales/locales que provee Struts.

Se crea un paquete util para almacenar los mapas de mensajes properties.

CLIENTE:
La valicacion de datos de entrada en los formularios ha pasado a hacerse usando el plugin de Struts, generando el codigo js.
Se ha implementado el uso de plantillas para todas las paginas (excepto index y errors, por ser diferentes).
Se ha localizado la pagina totalmente, tanto el interfaz de usuario como los mensajes de error/excepciones, que se muestran segun el lenguaje por defecto elegido. (Se puede cambiar en el index)

Capa de logica:
Sin cambios

Capa de integracion:
Sin cambios.

No se ha modificado la estructura de la BBDD.
Se ha generado nuevo JavaDoc.
/////////////////////////////////////////////////////////////////////////////////////
Version 4:
El diseno y el codigo usado es exactamente el de la version 3, a excepcion de:

Capa de presentacion:
SERVER
+Se ha reemplazado la tecnologia AJAX (acceso a como respuesta PrintWriter, objecto XMLHttpRequest y JavaScript asincrono), por el uso de beans y sesiones
+Se ha anadido un ContextListener que recoge como parametro inicial de aplicacion un ISBN y lo guarda en el contexto de la aplicacion. 
En la pagina principal se muestra un texto que carga su titulo, autor y editorial.
+Se ha anadido un filtro Encoding que se asegura que la codificacion de los parametros en el metodo POST sea UTF-8 o los recodifica (se anade fichero de configuracion glassfish)
+Se ha anaiddo un filtro Timing que genera trazas por consola para medir los tiempos de respuesta de las solicitudes
El filtro Timing actua antes que Encoding, para tener en cuenta este tiempo de recodificacion.
+En el paquete action se han anadido los servelts nuevos para implementar las nuevas funcionalidades
CLIENTE
+Nueva carpeta rsc que contiente los archivos de imagen utilizados en las vistas (carrito y editor de BBDD).
+Se han anadido las nuevas paginas JSP para cubrir las nuevas funcionalidades. He ha encapsulado el header y footer comunes en dos ficheros (include en cada jsp)
+Uso unificado de unicamente JSTL (core lib), Beans y Expression Language.
+Se ha elimindado el fichero XHR.js (AJAX removido) y se crea common.js que incluye las funcionalidades comunes.
+Fichero css actualizado para nuevos elementos.

Capa de logica:
+Se ha cambiado el nombre de Transfer por el de Bean (ITBook por IBookBean y sucesivos)
+Se ha sobreescrito el metodo equal para poder eliminar mediate el metodo remove del objeto que implemente la interfaz List.
+Se ha anadido un nuevo Bean a la Factoria de Beans llamado Cart
+Los Beans han implementado la interfaz Serializable y condiciones necesarias para utilizarlos como JavaBeans

Capa de integracion:
Sin cambios.

No se ha modificado la estructura de la BBDD.
Se ha generado nuevo JavaDoc.

Nota: No se ha considerado el caso de reactualizar el Carrito cuando se modifican los productos. Es decir, si se borra de la BBDD no se borra del carrito, 
asimismo los cambios en el nobre, editorial, precio, etc de un producto no son reflejados en los articulos del carrito. 
Se considera que esta gestion se debe de realizar en el momento de la validacion de la compra (asi como aplicar otros conceptos como iva o descuentos).

/////////////////////////////////////////////////////////////////////////////////////
Version 3:
El diseno y el codigo usado es exactamente el de la version 1, a excepcion de:

Capa de presentacion:
+Controlador: Se ha susituido por un servlet que centraliza todas las peticiones del cliente, y reenvia a sub-servelts especificos para cada accion
+View: se ha sustituido los JFrames por JSP. Se ha anadido un fichero para las funciones JavaScript y otro para el diseno CSS.

Capa de logica:
Debido a que nuevas funcionalidades son requeridas, tanto en la facha de negocio, como en el servicio de la aplicacion se anaden la nueva logica.

Capa de integracion:
Nuevas consulta en los DAOs para implementar las consultas sobre autor y editorial.
Ningun cambio en la persistencia.

Se ha generado nuevo JavaDoc.
/////////////////////////////////////////////////////////////////////////////////////
Version 1:
-------------------------------------------------------------------------------------
Documentacion

Adjunto al proyecto, se incluye un directorio con el JavaDoc generado a partir de los comentarios anadidos al codigo
-------------------------------------------------------------------------------------
Persitencia (DDBB)
- MySql 5.0, motor MyISAM
- JDBC: mysql-connector-java-5.1.6-bin (incluido en el proyecto)
- Creacion (SQL script):

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

CREATE TABLE `libros` (
  `ID` int(11) NOT NULL auto_increment,
  `TITULO` varchar(50) default NULL,
  `AUTOR` varchar(50) default NULL,
  `EDITORIAL` varchar(50) default NULL,
  `ISBN` varchar(20) default NULL,
  `PUBLICACION` int(11) default NULL,
  `PRECIO` double default NULL,
  `DESCRIPCION` varchar(200) default NULL,
  PRIMARY KEY  (`ID`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

- Insertar algunos elementos
INSERT INTO `libros` VALUES (1, 'Historia de dos ciudades', 'Charles Dickens', 'Catedra', '9788437619538', 2004, 20, 'La historia transcurre entre dos ciudades, Londres y París, durante la época de la Revolución Francesa. La indiferencia de Dickens por la política y su desprecio por los políticos alejan la novela ');
INSERT INTO `libros` VALUES (2, 'El Senor de los Anillos', 'JRR Tolkien', 'Minotauro', '9788445071793', 2002, 54, 'Versión Ilustrada.');
INSERT INTO `libros` VALUES (3, 'El Senor de los Anillos', 'JRR Tolkien', 'Círulo de Lectores', '8422616335', 1995, 6, 'Tapa Dura');
INSERT INTO `libros` VALUES (4, 'El Senor de los Anillos', 'JRR Tolkien', 'Círulo de Lectores', '842261633', 1995, 35, 'Tapa Dura');
-------------------------------------------------------------------------------------
Diseno
Se ha disenado una aplicación multicapa: presentacion - logica del modelo - persistencia

+presentacion
- patron Modelo-Vista-Controlador
- Controlador -> Patron Singleton
- Enlace entre la capa de presentacion y logica de negocio mediante patron Facade (Servicio de la Aplicacion)

+logica
- BussinessFacade -> Patron Facade: actualmente solo hay un tipo de servicio referente a la Entidad libro, pero agruparia todos los servicios de la aplicación en el caso de mas entidades, como clientes, proveedores, pedidos, factuas, haciendolo transparente a la capa de presentacion
- ServiceFactory -> Patron AbstracFactory junto a Singleton: solo un objeto de logica de negocio es creado (si se require) en el modelo, indepentientemente el numero de solicitudes. Abria uno para cada entidad.
- BookApplicationService -> Agrupa las operaciones atonicas de la entidad y hace de enlace con la persistencia. En esta práctica, todas las operaciones son atomicas, pero seria util en operaciones compuestas (dar de baja un proveedor y eliminar todos sus productos). En un sistema transactional, aqui se gestionarian los commit y rollback. 
Las excepciones obtenidas del acceso a la persistencia son tratadas a este nivel, y no se transmmiten a niveles superiores.
- Transfer -> Patron transfer para unificar el tipo de dato compuesto que se intercambia entre capas.
- TransferFactory -> Patron Factoria abstracta: Se encarga de crear los objetos Transfer solicitados. Si hubiera que modificar el tipo de instancia de los transfer, con hacerlo aqui, tendria efecto en todo el desarrollo.

+ Persistencia
- DAOFactory -> Idem que TransferFactory, pero con los DAOs.
- BookDAO -> Patron Data Access Object. Centraliza todo el codigo de gestion con la DDBB.
-+ ddbb package
-- TransactionManager: Factoria Abstracta + Singleton: Clase encargada de la gestion de transacciones. En ella se establecen los parámetros de conexion a la BBDD y el tipo de motor
--- Las transacciones solo activan commit/rollback en caso de BBDD transactional. MyISAN no es de estas, (InnoDB si es un ejemplo).
--- Su uso puede activarse/desactivarse en 
public static final boolean transactionalDDBB  = flase; 
--- TransactionManagerImp -> gestiona las transacciones metidante un pool de transacciones. En este caso, solo hay un usuario activo, pero en el caso de que la capa de presentación fuese distribuida, o varias transacciones fueres requeridas por un mismo usario a la vez, gestionaria las transacciones existentes para intentar optimizar los accesos a la BBDD.
--- TransactionException: Excepcion personalizada que controla las excepciones relacionadas con el acceso a la BBDD (además del las que pueda generar SQL)
-------------------------------------------------------------------------------------
Ejecucion:
package bookstore.presentation.main

Dos clases:
+ Test
- La clase de prueba como se pide en el ejecicio, con los souts.
- La salida esperada es:

------------------------------
Buscando TODOS los libros... Se han encontrado 4 libros
	Listado de Libros encontrados:
		Historia de dos ciudades, Charles Dickens, Catedra, 9788437619538, 2004, 20.0, La historia transcurre entre dos ciudades, Londres y París, durante la época de la Revolución Francesa. La indiferencia de Dickens por la política y su desprecio por los políticos alejan la novela 
		El Senor de los Anillos, JRR Tolkien, Minotauro, 9788445071793, 2002, 54.0, Versión Ilustrada.
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 8422616335, 1995, 6.0, Tapa Dura
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 842261633, 1995, 35.0, Tapa Dura
------------------------------
TESTANDO FUNCION ALTA LIBRO
	Insertando libro... Libro insertado con éxito!
	Insertando el mismo libro otra vez... Error insertando!
	Insertando el otro libro nuevo... Libro insertado con éxito!
FUNCION ALTA LIBRO OK!!
------------------------------
Buscando TODOS los libros... Se han encontrado 6 libros
	Listado de Libros encontrados:
		Historia de dos ciudades, Charles Dickens, Catedra, 9788437619538, 2004, 20.0, La historia transcurre entre dos ciudades, Londres y París, durante la época de la Revolución Francesa. La indiferencia de Dickens por la política y su desprecio por los políticos alejan la novela 
		El Senor de los Anillos, JRR Tolkien, Minotauro, 9788445071793, 2002, 54.0, Versión Ilustrada.
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 8422616335, 1995, 6.0, Tapa Dura
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 842261633, 1995, 35.0, Tapa Dura
		Titulo, Autor 1, Editorial 1, ISNB 1, 1, 1.0, Descripcion 1
		Titulo, Autor 2, Editorial 2, ISNB 2, 2, 2.0, Descripcion 2
------------------------------
Buscando TODOS los libros con título "Titulo"... Se han encontrado 2 libros
	Listado de Libros encontrados:
		Titulo, Autor 1, Editorial 1, ISNB 1, 1, 1.0, Descripcion 1
		Titulo, Autor 2, Editorial 2, ISNB 2, 2, 2.0, Descripcion 2
------------------------------
TESTANDO FUNCION BAJA LIBRO
	Borrando libro ya existente... Libro borrado con éxito!
	Borrando libro no existente... Error borrando!
FUNCION BAJA LIBRO OK!!
------------------------------
Buscando TODOS los libros... Se han encontrado 5 libros
	Listado de Libros encontrados:
		Historia de dos ciudades, Charles Dickens, Catedra, 9788437619538, 2004, 20.0, La historia transcurre entre dos ciudades, Londres y París, durante la época de la Revolución Francesa. La indiferencia de Dickens por la política y su desprecio por los políticos alejan la novela 
		El Senor de los Anillos, JRR Tolkien, Minotauro, 9788445071793, 2002, 54.0, Versión Ilustrada.
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 8422616335, 1995, 6.0, Tapa Dura
		El Senor de los Anillos, JRR Tolkien, Círulo de Lectores, 842261633, 1995, 35.0, Tapa Dura
		Titulo, Autor 2, Editorial 2, ISNB 2, 2, 2.0, Descripcion 2
------------------------------
TESTANDO FUNCION MODIFICA PRECIO POR ISBN
	Modificando precio de libro inexistente por ISBN... Precio no modificado!
	Modificando precio de libro existente por ISBN... Precio modificado!
FUNCION MODIFICA PRECIO POR ISBN OK!!
------------------------------
Buscando TODOS los libros con título "Titulo"... Se han encontrado 1 libros
	Listado de Libros encontrados:
		Titulo, Autor 2, Editorial 2, ISNB 2, 2, 2.2, Descripcion 2
------------------------------
TESTANDO FUNCION CONSULTA ISBN
	Solicitando libro inexistente por ISBN... Libro NO encontrado!
	Solicitando libro existente por ISBN... Libro encontrado!
FUNCION CONSULTA ISBN OK!!


+ Main (main por defecto del proyecto)
- Invoca la GUI
- El idioma de los mensajes se puede elegir entre Espanol/Inglés cambiando

private int Language = LocationManager.Language.ENGLISH;

en la linea 23 del package bookstore.presentation.view, clase BookStoreGUIImp.

- La aplicación arranca con una lectura inicial de la BBDD
- Para acceder al detalle de cada libro, pulsar con el raton (o moverse con el teclado) sobre la fila del Gird
- Usar los botones Delete/Modify/Add para modificar la BBDD
- No se pueden anadir dos libros con el mismo ISBN
- Modificar aplica a todos los datos del formulario (no solo al precio), excepto al ISBN.
- Se generan mensjes de error/ok para cada acción.

