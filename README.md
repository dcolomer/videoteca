# Aplicación Web Java
## CRUD avanzado gestión de películas
> ### Subida de ficheros con API Servlet 3.1

## Introducción
Se trata de una aplicación que muestra cómo realizar una gestión de una videoteca mediante tecnología API Servlet. Además del típico CRUD, podemos:
- Subir al servidor las imágenes de las carátulas de las películas, las cuales se almacenan en la propia base de datos de la aplicación.
- Obtener estadísticas sobre las películas (cuántas hay de cada género).
- Realizar búsquedas (título, director, actor, etc).
- Mostrar las películas ordenadas por algún criterio (código, título, director, etc).

## Tecnologías
- Frontend: HTML, CSS, JavaScript 
- Backend: Java/Servlets/JSP (Tomcat 8.5)
- Frameworks: no
- Pool de conexiones
- Base de datos: MySQL 8
- Construcción proyecto: Maven 3.5

## Capturas de pantalla
A continuación se muestra visualmente las principales funcionalidades de la aplicación.

### Inicio de la aplicación
Se accede a la aplicación mediante la URL http://localhost:8080/videoteca/  

![Inicio](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/00.png)

### Listar y editar películas
Mediante la opción "Listar y editar" obtendremos un listado paginado de las películas. Estas se muestran de diez en diez. La información que aparece es un resumen de cada película. En cualquier momento podremos:
- Buscar: Ir a la pantalla de búsqueda de películas
- Añadir: Dar de alta un nueva película
- Ordenar: Obtener un listado de películas ordenado por algún criterio
- Inicio: Acceder directamente a la pantalla de bienvenida
- Retroceder: Regresar a la pantalla anterior (que en muchos casos coincidirá con la pantalla de bienvenida)

![Listar peliculas](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/01-listar.png)

#### Ficha del video
Si pulsamos sobre el título de una película iremos a la ficha del video, que no es más que información detallada de una película, esto es, la misma información que se mostraba previamente en el listado más otra que no se mostraba por falta de espacio, más la imagen de la carátula si la hubiere:

![Ficha del video](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/02a-detalle.png)

 O una imagen con el mensaje "No disponible" en caso de que la imagen no tenga asociada una carátula:
 
![Ficha del video sin caratula](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/02-detalle.png)

Opciones disponibles en la pantalla "Ficha del video":
- Modificar: Permite la edición de la película (incluyendo el cambio de carátula)
- Eliminar: Borra la película de la base de datos (cuidado! se trata de un borrado físico)
- Inicio: Acceder directamente a la pantalla de bienvenida
- Retroceder: Regresar a la pantalla anterior (pantalla "Listar y editar")

#### Modificar video
En esta pantalla podemos cambiar cualquier atributo de la película a excepción de su código.  
En las siguientes imágenes se muestra el caso en que modificamos una película que previamente no disponía de carátula. El proceso comienza cuando pulsamos en el botón "Seleccionar archivo" y seleccionamos una imagen de algún directorio. Una vez seleccionada la imagen con el mensaje "No disponible" aparece atenuada y más abajo aparece la nueva imagen, la cual sustituirá a la actual una vez que confirmemos los cambios.

![Modificar video 1](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/03-modificar.png)
![Modificar video 2](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/04-cambiar-imagen.png)
![Modificar video 3](https://github.com/dcolomer/videoteca/blob/master/src/main/snapshots/05-cambiar-imagen2.png)

## Bases de datos
La base de datos se llama 'videoteca' y en el directorio src/main/db se proporciona un archivo comprimido de tipo sql, el cual contiene la estructura y los datos necesarios para el correcto funcionamiento de la aplicación (incluye también la creación de la base de datos).

Las tablas de la base de datos son las siguientes:

- codigos
- peliculas

En la carpeta src/main/webapp/META-INF, en el fichero 'context.xml', se define el DataSource para la conexión entre Tomcat y la base de datos. De esta manera Tomcat crea un pool de conexiones.

Las credenciales para la conexión Tomcat-MySQL son:
 
- usuario: videoteca
- password: videoteca

Por tanto, en MySQL hay que definir un usuario con estas credenciales y con permisos CRUD para la base de datos 'videoteca'.

## Construcción del proyecto y deploy en Tomcat

Configuración previa:
 
- El plugin de Maven es para la versión 7 de Tomcat pero también funciona para la versión 8.

- Necesitamos dar de alta un usuario en el archivo 'tomcat-users.xml' de Tomcat, en la carpeta 'conf' de la instalación del mismo, que tenga permisos del tipo 'manager-script'. Este usuario será el que se utilizará en el archivo pom.xml para hacer el deploy del proyecto.

Ejemplo:

Fichero **tomcat-users.xml:**

~~~
<tomcat-users>
	<role rolename="manager-script"/>
	<user username="maven" password="deployer" roles="manager-script"/>
</tomcat-users>
~~~

Fichero **pom.xml:**
~~~
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <url>http://localhost:8080/manager/text</url>
        <username>maven</username>
        <password>deployer</password>
        <update>true</update>
    </configuration>
</plugin>
~~~
Pasos para el despliegue y redespliegue del proyecto:

1. Nos aseguramos de tener Tomcat en marcha.
2. En un terminal (PowerShell, etc), nos aseguramos de estar situados en la raíz del proyecto (donde se encuentra el fichero pom.xml) y ejecutamos: **mvn tomcat7:deploy**
3. Finalizado sin errores el proceso anterior tendremos disponible la aplicación web en http://localhost:8080/videoteca/
