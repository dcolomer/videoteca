package beans;

import java.io.Serializable;

public class ResumenPeliculas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id_pelicula;
	private String titulo;
	private String subtitulo;
	private String director;
	private String actor1;
	private String actor2;
	private String actor3;
	private String localizacion;
	private String visualizada;
	private String genero1;
	private String genero2;
	
	
	public ResumenPeliculas() {}
	
	public ResumenPeliculas(String id_pelicula,
		String titulo, String subtitulo, String director,
		String actor1, String actor2, String actor3,
		String localizacion, String visualizada, 
		String genero1, String genero2) 
	{
		this.setIdPelicula(id_pelicula);
		this.setTitulo(titulo);
		this.setSubtitulo(subtitulo);
		this.setDirector(director);
		this.setActor1(actor1);
		this.setActor2(actor2);
		this.setActor3(actor3);
		this.setLocalizacion(localizacion);
		this.setVisualizada(visualizada);
		this.setGenero1(genero1);
		this.setGenero2(genero2);
		
	}
	
	//	M�todos get/set para acceder a todos los camps del VO
	
	public void setIdPelicula(String id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	public String getIdPelicula() {
		return id_pelicula;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDirector() {
		return director;
	}
	
	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}
	public String getActor1() {
		return actor1;
	}
	
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public String getActor2() {
		return actor2;
	}
	
	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}
	public String getActor3() {
		return actor3;
	}
	
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getLocalizacion() {
		return localizacion;
	}

	public void setVisualizada(String visualizada) {
		this.visualizada = visualizada;
	}
	public String getVisualizada() {
		return visualizada;
	}
	
	public void setGenero1(String genero1) {
		this.genero1 = genero1;
	}
	public String getGenero1() {
		return genero1;
	}
	public void setGenero2(String genero2) {
		this.genero2 = genero2;
	}
	public String getGenero2() {
		return genero2;
	}
	
}