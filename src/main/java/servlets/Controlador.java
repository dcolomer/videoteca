package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import beans.*;

import negocio.Negocio;

import static servlets.Constantes.*;

/**
 * Servlet que hace de controlador; recibe todas las peticiones de usuario,
 * invoca a los métodos de negocio y redirecciona a la vista adecuada en cada
 * caso.
 * 
 * Hace un if_then_else para ejecutar la acción solicitada por el usuario.
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5)
public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ServletContext sc;
	
	/**************************************************************
	 * INIT: se obtiene el contexto
	 **************************************************************/
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext(); // Obtengo contexto del servlet
	}

	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		
		String operacion = request.getParameter("operacion");
		String idPelicula = request.getParameter("id_pelicula");
	
		String siguientePag = PG_ERROR;

		try {
			/*
			 * Se redirige el control hacia la página index.html, la cual
			 * muestra el menú principal de opciones
			 */
			if (operacion.equals(OP_INDEX))	{

				siguientePag = PG_INDEX;
			}
			else if (operacion.equals(OP_FORM_BUSCAR_PELICULAS)) {

				siguientePag = PG_BUSCAR_PELICULAS;
			}
			else if (operacion.equals(OP_BUSCAR_PELICULAS))	{
								
				String cadena_busqueda = ControladorHelper.prepararBusqueda(request);

				Negocio neg = new Negocio();
				Collection peliculas = neg.getResumenPeliculas(cadena_busqueda);
				request.setAttribute(ATRIB_LISTADO_PELICULAS, peliculas);
				request.setAttribute(ATRIB_PELI_REPETIDA, false);
				siguientePag = PG_LISTAR_PELICULAS_BUSQUEDA;
			}
			else if (operacion.equals(OP_ESTADISTICAS))	{

				request = ControladorHelper.prepararEstadisticas(request);
				siguientePag = PG_ESTADISTICAS;
			}
			else if (operacion.equals(OP_FORM_ORDENAR_PELICULAS)) {

				siguientePag = PG_ORDENAR_PELICULAS;
			}
			else if (operacion.equals(OP_ORDENAR_PELICULAS))	{				
				
				String cadena = ControladorHelper.prepararPaginacion(request);
				String cadenaOrdenacion = ControladorHelper.prepararOrdenacion(request);

				Negocio neg = new Negocio();
				Collection peliculas = neg.getResumenPeliculas(cadenaOrdenacion + " " + cadena);
				request.setAttribute(ATRIB_LISTADO_PELICULAS, peliculas);
				
				siguientePag = PG_LISTAR_PELICULAS;
			}
			/*
			 * El usuario ha pulsado sobre 'Listar películas'.
			 * Se obtiene una coleccion de objetos 'ResumenPeliculas' y
			 * se pone a disposición (en la request) de la jsp que la debe mostrar.
			 * 
			 * Se redirige el control hacia la jsp que muestra el resumen de
			 * las películas.
			 */			
			else if (operacion.equals(OP_LISTAR_PELICULAS))	{
				
				String cadena = ControladorHelper.prepararPaginacion(request);

				Negocio neg = new Negocio();
				Collection peliculas = neg.getResumenPeliculas(cadena);
								
				request.setAttribute(ATRIB_LISTADO_PELICULAS, peliculas);				
				
				siguientePag = PG_LISTAR_PELICULAS;
			}
			
			/*
			 * El usuario ha pulsado sobre un resumen de película concreta
			 * para visualizar el detalle completo de la misma.
			 * Se obtiene una coleccion de objetos 'DetallePelicula', esto
			 * es, todos los campos que detallan una película y
			 * se pone a disposición (en la request) de la jsp que la debe mostrar.
			 * 
			 * Se redirige el control hacia la jsp que muestra el el detalle 
			 * completo de una película.
			 */
			else if (operacion.equals(OP_DETALLE_PELICULA))	{
				Negocio neg = new Negocio();
				Collection detallePelicula = neg.getDetallePelicula(idPelicula);
				request.setAttribute(ATRIB_LISTADO_DETALLE_PELICULA, detallePelicula);

				/* Hacer que la jsp que se invocará disponga de tantas colecciones
				   como combos aparezcan en la página
				*/
				cargarCodigos(request);
				siguientePag = PG_LISTAR_DETALLE_PELICULA;
			}
			
			/*
			 * El usuario quiere modificar alguno de los campos del
			 * detalle de una película.
			 * 
			 * Se redirige el control hacia la jsp que muestra el formulario
			 * editable para su modificación.
			 */
			else if (operacion.equals(OP_FORM_MODIFICAR_PELICULA))	{

				Negocio neg = new Negocio();
				Collection detallePelicula = neg.getDetallePelicula(idPelicula);
				request.setAttribute(ATRIB_LISTADO_DETALLE_PELICULA, detallePelicula);
				request.setAttribute(ATRIB_ID_PELICULA, idPelicula);
				cargarCodigos(request);
				siguientePag = PG_MODIFICAR_PELICULA;
			}				
			
			/*
			 * Se lleva a cabo la modificación del detalle de una película.
			 * 
			 * Se redirige el control hacia la jsp que muestra el detalle de
			 * la película, por tanto se pueden apreciar los cambios realizados.
			 */
			else if (operacion.equals(OP_MODIFICAR_PELICULA)) {

				updatePelicula(request, idPelicula);

				Negocio neg = new Negocio();
				Collection detallePelicula = neg.getDetallePelicula(idPelicula);
				request.setAttribute(ATRIB_LISTADO_DETALLE_PELICULA, detallePelicula);
				cargarCodigos(request);
				siguientePag = PG_LISTAR_DETALLE_PELICULA;
			}
			
			/*
			 * El usuario quiere dar de alta una película.
			 * 
			 * Se redirige el control hacia la jsp que muestra el formulario
			 * de alta de películas.
			 */
			else if (operacion.equals(OP_FORM_ANADIR_PELICULA))	{

				cargarCodigos(request);
				siguientePag = PG_ANADIR_PELICULA;
			}
			
			/*
			 * Se lleva a cabo el alta de la nueva película
			 * 
			 * Una vez grabada la película se muestra la misma página de 'altas'
			 */
			else if (operacion.equals(OP_ANADIR_PELICULA))	{		
				
				// Si cuando hemos intentado dar de alta la pelicula vemos
				// que está repetida entonces NO damos de alta y mostramos
				// esa peli
				Collection pelisRepetidas = altaPelicula(request);
				
				if (!pelisRepetidas.isEmpty()) {
					request.setAttribute(ATRIB_LISTADO_PELICULAS, pelisRepetidas);
					request.setAttribute(ATRIB_PELI_REPETIDA, true);
					siguientePag = PG_LISTAR_PELICULAS_BUSQUEDA;
				} else {
					cargarCodigos(request);
					siguientePag = PG_ANADIR_PELICULA;
				}
			}
			
			/*
			 * Se lleva a cabo la eliminación de una película
			 * 
			 * Una vez eliminada se redirige el control hacia el resumen de películas
			 */
			else if (operacion.equals(OP_ELIMINAR_PELICULA)) {

				Negocio neg = new Negocio();
				neg.eliminarPelicula(idPelicula);
				Collection peliculas = neg.getResumenPeliculas("");
				request.setAttribute(ATRIB_LISTADO_PELICULAS, peliculas);				
				
				siguientePag = PG_LISTAR_PELICULAS;
			}
			else {
				siguientePag = PG_ERROR;
			}
			
			//	Redireccionar a la JSP que toca
			RequestDispatcher dispatcher = 
				sc.getRequestDispatcher(siguientePag);
			
			dispatcher.forward(request, response);
					
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	/*
	 * DAR DE ALTA UNA PELICULA 
	 */
	private Collection altaPelicula(HttpServletRequest request) {
			    	    
		DetallePelicula peli =
	    	cargarCamposFormulario(request, new DetallePelicula());
	    
	    // Comprobar que la pelicula no exista en la BD
	    String cadena = " AND titulo='" + peli.getTitulo() + "'";

		Negocio neg = new Negocio();
	    Collection pelis = neg.getResumenPeliculas(cadena);
	    
	    if (pelis.isEmpty()) {
	    	// Creamos la pelicula llamando a los métodos de negocio
	    	neg.anadirPelicula(peli);
	    } 
		return pelis;
	}
	
	/*
	 * MODIFICAR ALGUN CAMPO DE UNA PELICULA
	 */
	private void updatePelicula(HttpServletRequest request, String idPelicula) {
		
		DetallePelicula peli =
			cargarCamposFormulario(request, new DetallePelicula());

		peli.setIdPelicula(idPelicula);

		// Actualizamos la pelicula llamando a los métodos de negocio
		Negocio neg = new Negocio();
		neg.actualizarPelicula(peli);
	}
	
	/*
	 * Hacer que la jsp que se invocará disponga de tantas colecciones
	 * como combos aparezcan en la página
	 */
	private void cargarCodigos(HttpServletRequest request) {

		Negocio neg = new Negocio();

		// Necesitamos la lista de todos los soportes de cada peli
		// "1" -> soporte para la pelicula
		Collection composicion = neg.getCodigos("1");
		request.setAttribute(ATRIB_LISTADO_COMPOSICION, composicion);
		
		Collection formato = neg.getCodigos("2");
		request.setAttribute(ATRIB_LISTADO_FORMATO, formato);
		
		Collection tipo = neg.getCodigos("3");
		request.setAttribute(ATRIB_LISTADO_TIPO, tipo);
		
		Collection genero1 = neg.getCodigos("4");
		request.setAttribute(ATRIB_LISTADO_GENERO1, genero1);
		
		Collection genero2_3 = neg.getCodigos("5");
		request.setAttribute(ATRIB_LISTADO_GENERO2_3, genero2_3);
	}
	
	/*
	 * Metodo utiliado en las altas y en las modificaciones.
	 * A partir de los datos procedentes de la jsp se llenan los campos
	 * del objecto peli (DetallePelicula).
	 */
	private DetallePelicula cargarCamposFormulario(HttpServletRequest request, DetallePelicula peli) {

		peli.setComposicion(request.getParameter("composicion"));
	    peli.setTitulo(request.getParameter("titulo"));
	    peli.setSubtitulo(request.getParameter("subtitulo"));
	    peli.setFormato(request.getParameter("formato"));
	    peli.setTipo(request.getParameter("tipo"));
	    peli.setLocalizacion(request.getParameter("localizacion"));
	    peli.setVos(request.getParameter("vos"));
	    peli.setGenero1(request.getParameter("genero1"));
	    peli.setGenero2(request.getParameter("genero2"));
	    peli.setGenero3(request.getParameter("genero3"));
	    peli.setVisualizada(request.getParameter("visualizada"));
	    peli.setNumVisualizaciones(request.getParameter("num_visualizaciones"));
	    peli.setDirector(request.getParameter("director"));
	    peli.setActor1(request.getParameter("actor1"));
	    peli.setActor2(request.getParameter("actor2"));
	    peli.setActor3(request.getParameter("actor3"));
	    peli.setObservaciones(request.getParameter("observaciones"));

	    try {
			Part filePart = request.getPart("caratula"); // Recuperar <input type="file" name="caratula">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			peli.setCaratula(fileContent);
		} catch(Exception e) {
	    	e.printStackTrace();
			peli.setCaratula(null);
		}

	    return peli;
	}
}

