package database;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import beans.Codigos;
import beans.DetallePelicula;
import beans.ResumenPeliculas;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbManager {

	private Context ctx = null;
	private DataSource ds;

	public DbManager() {
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/videoteca");
		} catch (NamingException e) {
			System.out.println("Error intentando obtener el DataSource!");
			e.printStackTrace();
		}
	}

	public Collection getCodigos(String codigoCampo) {

		final String QUERY = "SELECT codigo_particular, valor FROM codigos WHERE codigo_general='" + codigoCampo + "'";

		List<Codigos> codigos = new LinkedList<>();
		
		try (Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY))
		{
			while (rs.next()) {
				String codPar = rs.getString("codigo_particular");
				String valor = rs.getString("valor");
				Codigos codes = new Codigos(codPar, valor);
				codigos.add(codes);
			}
		} catch (Exception ex) {
			System.out.println("Error intentando consultar la tabla 'codigos'!");
			ex.printStackTrace();
		} 
	
		return codigos;
	}
	
	public Collection getResumenPeliculas(String cadena) {

		final String QUERY = "SELECT id_pelicula, titulo, subtitulo, director," +
				"actor1, actor2, actor3, localizacion, visualizada, genero1, genero2 FROM peliculas WHERE 1=1 " + cadena;

		List<ResumenPeliculas> resumenPeliculas = new LinkedList<>();

		try (Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(QUERY))
		{
			while (rs.next()) {
				String subtitulo = rs.getString("subtitulo");
				String actor2 = rs.getString("actor2");
				String actor3 = rs.getString("actor3");
								
				if (subtitulo == null) subtitulo = "";
				if (actor2 == null) actor2 = "";
				if (actor3 == null) actor3 = "";
								
				ResumenPeliculas resumen = new ResumenPeliculas(
						rs.getString("id_pelicula"),
						rs.getString("titulo"),
						subtitulo,
						rs.getString("director"),
						rs.getString("actor1"),
						actor2,
						actor3,
						rs.getString("localizacion"),
						rs.getString("visualizada"),
						rs.getString("genero1"),
						rs.getString("genero2"));
				
				resumenPeliculas.add(resumen);
			}
		} catch (Exception ex) {
			System.out.println("Error intentando consultar la tabla 'peliculas'!");
			ex.printStackTrace();
		}
	
		return resumenPeliculas;
	}

	public Collection getDetallePelicula(String idPelicula)	{

		final String QUERY = "SELECT composicion,titulo,subtitulo,formato," +
				"tipo,localizacion,vos,genero1,genero2,genero3,visualizada," +
				"num_visualizaciones,director,actor1,actor2,actor3,observaciones" +
				" FROM peliculas WHERE id_pelicula='" + idPelicula + "'";

		List<DetallePelicula> detallePelicula = new LinkedList<>();

		try (Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(QUERY))
		{
			while (rs.next()) {
				String subtitulo = rs.getString("subtitulo");
				String actor2 = rs.getString("actor2");
				String actor3 = rs.getString("actor3");
				String genero2 = rs.getString("genero2");
				String genero3 = rs.getString("genero3");
				String num_visualizaciones = rs.getString("num_visualizaciones");
				String observaciones = rs.getString("observaciones");

				if (subtitulo == null) subtitulo = "";
				if (actor2 == null) actor2 = "";
				if (actor3 == null) actor3 = "";
				if (genero2 == null) genero2 = "";
				if (genero3 == null) genero3 = "";
				if (num_visualizaciones == null) num_visualizaciones = "0";
				if (observaciones == null) observaciones = "";
				
				DetallePelicula detalle = new DetallePelicula(
						idPelicula,
						rs.getString("composicion"),
						rs.getString("titulo"),
						subtitulo,
						rs.getString("formato"),
						rs.getString("tipo"),
						rs.getString("localizacion"),
						rs.getString("vos"),
						rs.getString("genero1"),
						genero2,
						genero3,
						rs.getString("visualizada"),
						num_visualizaciones,
						rs.getString("director"),
						rs.getString("actor1"),
						actor2,
						actor3,
						observaciones);
				
				detallePelicula.add(detalle);
			}
		} catch (Exception ex) {
			System.out.println("Error intentando consultar la tabla 'peliculas'!");
			ex.printStackTrace();
		}

		return detallePelicula;
	}

	public boolean addPelicula(DetallePelicula pelicula)
	{
		final String QUERY = "INSERT INTO peliculas VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		final String idPelicula = null;
		boolean infoAfegida = false;

		try (Connection conn = ds.getConnection();
			 PreparedStatement ps = conn.prepareStatement(QUERY,Statement.RETURN_GENERATED_KEYS))
		{
			ps.setString(1, idPelicula);
			ps.setString(2, pelicula.getComposicion());
			ps.setString(3, pelicula.getTitulo());
			ps.setString(4, pelicula.getSubtitulo());
			ps.setString(5, pelicula.getFormato());
			ps.setString(6, pelicula.getTipo());
			ps.setString(7, pelicula.getLocalizacion());
			ps.setString(8, pelicula.getVos());
			ps.setString(9, pelicula.getGenero1());
			ps.setString(10,pelicula.getGenero2());
			ps.setString(11,pelicula.getGenero3());
			ps.setString(12,pelicula.getVisualizada());
			ps.setString(13,pelicula.getNumVisualizaciones());
			ps.setString(14,pelicula.getDirector());
			ps.setString(15,pelicula.getActor1());
			ps.setString(16,pelicula.getActor2());
			ps.setString(17,pelicula.getActor3());
			ps.setString(18,pelicula.getObservaciones());
			ps.setString(19,null); // sin caratula
	
			ps.executeUpdate();

			try(ResultSet rs = ps.getGeneratedKeys())
			{
				if (rs.next()) {
					pelicula.setIdPelicula(rs.getString(1));
					anadirCaratula(pelicula.getIdPelicula(), pelicula.getCaratula());
					infoAfegida = true;
				}
			} catch (IOException | SQLException e) {
				System.out.println("Error intentando añadir la caratula de la pelicula en la tabla 'peliculas'!");
				e.printStackTrace();
			}
		}
		catch (SQLException e) {
			System.out.println("Error intentando añadir una pelicula en la tabla 'peliculas'!");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		
		return infoAfegida;
	}

	public boolean eliminarPelicula(String idPelicula) {

		final String QUERY = "DELETE FROM peliculas WHERE id_pelicula='" + idPelicula + "'";
		boolean peliculaEliminada = false;

		try (Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement())
		{
			stmt.executeUpdate(QUERY);
			peliculaEliminada = true;
		}
		catch (SQLException e) {
			System.out.println("Error intentando eliminar una pelicula en la tabla 'peliculas'!");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	
		return peliculaEliminada;
	}

	public boolean actualizarPelicula(DetallePelicula pelicula) {

		final String QUERY = "UPDATE peliculas " +
				"SET composicion = ?, " +
				"titulo = ?, " +
				"subtitulo = ?, " +
				"formato = ?, " +
				"tipo = ?, " +
				"localizacion = ?, " +
				"vos = ?, " +
				"genero1 = ?, " +
				"genero2 = ?, " +
				"genero3 = ?, " +
				"visualizada = ?, " +
				"num_visualizaciones = ?, " +
				"director = ?, " +
				"actor1 = ?, " +
				"actor2 = ?, " +
				"actor3 = ?, " +
				"observaciones = ? " +
				"WHERE id_pelicula = ?";

		boolean peliculaActualizada = false;

		try (Connection conn = ds.getConnection();
			 PreparedStatement ps = conn.prepareStatement(QUERY))
		{
			ps.setString(1, pelicula.getComposicion());
			ps.setString(2, pelicula.getTitulo());
			ps.setString(3, pelicula.getSubtitulo());
			ps.setString(4, pelicula.getFormato());
			ps.setString(5, pelicula.getTipo());
			ps.setString(6, pelicula.getLocalizacion());
			ps.setString(7, pelicula.getVos());
			ps.setString(8, pelicula.getGenero1());
			ps.setString(9, pelicula.getGenero2());
			ps.setString(10, pelicula.getGenero3());
			ps.setString(11, pelicula.getVisualizada());
			ps.setString(12, pelicula.getNumVisualizaciones());
			ps.setString(13, pelicula.getDirector());
			ps.setString(14, pelicula.getActor1());
			ps.setString(15, pelicula.getActor2());
			ps.setString(16, pelicula.getActor3());
			ps.setString(17, pelicula.getObservaciones());
			ps.setString(18, pelicula.getIdPelicula());

			ps.executeUpdate();

			try {
				anadirCaratula(pelicula.getIdPelicula(), pelicula.getCaratula());
				peliculaActualizada = true;
			} catch (IOException e) {
				System.out.println("Error intentando actualizar la caratula de la pelicula en la tabla 'peliculas'!");
				e.printStackTrace();
			}
		}
		catch (SQLException e) {
			System.out.println("Error intentando actualizar la pelicula en la tabla 'peliculas'!");
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		
		return peliculaActualizada;
	}
	
	/*
	 * Inserta una caratula (imagen) en la tabla 'peliculas'
	 */
	private void anadirCaratula(String idPelicula, InputStream caratula) throws IOException, SQLException {

		final String QUERY = "UPDATE peliculas SET caratula = ? WHERE id_pelicula = ?";

		try (Connection conn = ds.getConnection();
			 PreparedStatement ps = conn.prepareStatement(QUERY))
		{
			ps.setBinaryStream(1, caratula);
			ps.setString(2, idPelicula);
			ps.executeUpdate();
		}

	}

	/*
	 * A partir del identificador de la pelicula se devuelve la caratula
	 * almacenada en la tabla 'peliculas'
	 */
	public InputStream getCaratula(String idPelicula) {

		final String QUERY = "SELECT caratula FROM peliculas WHERE " +
				"id_pelicula = '"+ idPelicula+"'";

		try (Connection conn = ds.getConnection();
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(QUERY))
		{
			if (rs.next())
	         	return rs.getBinaryStream("caratula");
		} catch(SQLException e) {
			 System.out.println("Error intentando recuperar la caratula de la pelicula en la tabla 'peliculas'!");
	    }

	    return null;
	 }

	/*
	 * Obtener el total de peliculas en la videoteca
	 * 
	 */
	public int estadisticas(String SQL) {

		int retorno = 0;

		try (Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(SQL))
		{
			if (rs.next())
				return rs.getInt(1);
		
		} catch (Exception ex) {
			System.out.println("Error intentando consultar la tabla 'pelicula'!");
			ex.printStackTrace();
		}	     
	    		
		return retorno;
	}
}
