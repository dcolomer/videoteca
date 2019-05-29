package beans;

import java.io.InputStream;
import java.io.Serializable;

public class DetallePelicula implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id_pelicula;
	private String composicion;
	private String titulo;
	private String subtitulo;
	private String formato;
	private String tipo;
	private String localizacion;
	private String vos;
	private String genero1;
	private String genero2;
	private String genero3;
	private String visualizada;
	private String num_visualizaciones;
	private String director;
	private String actor1;
	private String actor2;
	private String actor3;
	private String observaciones;
	private InputStream caratula;
	
	public DetallePelicula() {}
	
	public DetallePelicula(String id_pelicula, String composicion,
			String titulo, String subtitulo, String formato, String tipo,
			String localizacion, String vos, String genero1, String genero2,
			String genero3, String visualizada, String num_visualizaciones,
			String director, String actor1, String actor2, String actor3,
			String observaciones) 
	{
		this(id_pelicula, composicion,
				titulo, subtitulo, formato, tipo,
				localizacion, vos, genero1, genero2,
				genero3, visualizada, num_visualizaciones,
				director, actor1, actor2, actor3,
				observaciones, null);
	}

	public DetallePelicula(String id_pelicula, String composicion,
			String titulo, String subtitulo, String formato, String tipo,
			String localizacion, String vos, String genero1, String genero2,
			String genero3, String visualizada, String num_visualizaciones,
			String director, String actor1, String actor2, String actor3,
			String observaciones, InputStream caratula)
	{
		this.setIdPelicula(id_pelicula);
		this.setComposicion(composicion);
		this.setTitulo(titulo);
		this.setSubtitulo(subtitulo);
		this.setFormato(formato);
		this.setTipo(tipo);
		this.setLocalizacion(localizacion);
		this.setVos(vos);
		this.setGenero1(genero1);
		this.setGenero2(genero2);
		this.setGenero3(genero3);
		this.setVisualizada(visualizada);
		this.setNumVisualizaciones(num_visualizaciones);
		this.setDirector(director);
		this.setActor1(actor1);
		this.setActor2(actor2);
		this.setActor3(actor3);
		this.setObservaciones(observaciones);
		this.setCaratula(caratula);
	}

	public String getIdPelicula() {
		return id_pelicula;
	}
	public void setIdPelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getComposicion() {
		return composicion;
	}
	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getVos() {
		return vos;
	}
	public void setVos(String vos) {
		this.vos = vos;
	}

	public String getGenero1() {
		return genero1;
	}
	public void setGenero1(String genero1) {
		this.genero1 = genero1;
	}

	public String getGenero2() {
		return genero2;
	}
	public void setGenero2(String genero2) {
		this.genero2 = genero2;
	}

	public String getGenero3() {
		return genero3;
	}
	public void setGenero3(String genero3) {
		this.genero3 = genero3;
	}

	public String getVisualizada() {
		return visualizada;
	}
	public void setVisualizada(String visualizada) {
		this.visualizada = visualizada;
	}

	public String getNumVisualizaciones() {
		return num_visualizaciones;
	}
	public void setNumVisualizaciones(String num_visualizaciones) {
		this.num_visualizaciones = num_visualizaciones;
	}

	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor1() {
		return actor1;
	}
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public String getActor2() {
		return actor2;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public String getActor3() {
		return actor3;
	}
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public InputStream getCaratula() {
		return caratula;
	}
	public void setCaratula(InputStream caratula) {
		this.caratula = caratula;
	}
}