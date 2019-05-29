package negocio;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Collection;
import beans.DetallePelicula;
import database.DbManager;

public class Negocio {

	private DbManager dbManager = new DbManager();

	public Collection getResumenPeliculas(String cadenaBusqueda) {
		return dbManager.getResumenPeliculas(cadenaBusqueda);
	}

	public Collection getDetallePelicula(String idPelicula) {
		return dbManager.getDetallePelicula(idPelicula);
	}

	public InputStream getCaratula(String idPelicula) {
		return dbManager.getCaratula(idPelicula);
	}
	
	public Collection getCodigos(String codigoCampo) {
		return dbManager.getCodigos(codigoCampo);
	}

	public void eliminarPelicula(String idPelicula) {
		dbManager.eliminarPelicula(idPelicula);
	}

	public void anadirPelicula(DetallePelicula pelicula) {
		dbManager.addPelicula(pelicula);
	}

	public void actualizarPelicula(DetallePelicula pelicula) {
		dbManager.actualizarPelicula(pelicula);
	}
	
	public int estadisticas(int operacion) {
		
		String SQL = null;
		
		switch (operacion) {
		
			case 1:
				SQL = "SELECT count(*) FROM peliculas";
				break;
			case 2:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula'";
				break;
			case 3:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='documental'";
				break;
			case 4:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='serie'";
				break;		
			case 5:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='otro'";
				break;	
			case 6:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='accion'";
				break;
			case 7:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='adultos'";
				break;
			case 8:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='ficcion'";
				break;
			case 9:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='comedia'";
				break;
			case 10:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='drama'";
				break;
			case 11:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='infantil'";
				break;	
			case 12:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='musical'";
				break;	
			case 13:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='thriller'";
				break;	
			case 14:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='policiaca'";
				break;
			case 15:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='western'";
				break;
			case 16:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='historica'";
				break;	
			case 17:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='epoca'";
				break;	
			case 18:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='terror'";
				break;	
			case 19:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='pelicula' AND genero2='otro'";
				break;	
			case 20:
				SQL = "SELECT count(*) FROM peliculas WHERE genero1='informatica'";
				break;	
		}
				
		return dbManager.estadisticas(SQL);
	}
}
