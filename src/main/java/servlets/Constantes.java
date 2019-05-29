package servlets;

public class Constantes {

    // Constantes para las operaciones invocadas por el cliente
    static final String OP_INDEX = "opIndex";

    static final String OP_LISTAR_PELICULAS = "opListarPeliculas";
    static final String OP_DETALLE_PELICULA = "opListarDetallePelicula";

    static final String OP_FORM_ANADIR_PELICULA = "opFormAnadirPeliculas";
    static final String OP_ANADIR_PELICULA = "opAnadirPeliculas";

    static final String OP_FORM_MODIFICAR_PELICULA = "opFormModificarPelicula";
    static final String OP_MODIFICAR_PELICULA = "opModificarPelicula";

    static final String OP_FORM_BUSCAR_PELICULAS = "opFormBuscarPeliculas";
    static final String OP_BUSCAR_PELICULAS = "opBuscarPeliculas";

    static final String OP_FORM_ORDENAR_PELICULAS = "opFormOrdenarPeliculas";
    static final String OP_ORDENAR_PELICULAS = "opOrdenarPeliculas";

    static final String OP_ESTADISTICAS = "opEstadisticas";

    // La eliminación no necesita ningún formulario
    static final String OP_ELIMINAR_PELICULA = "opEliminarPelicula";

    static final String ATRIB_ID_PELICULA = "id_pelicula";
    static final String ATRIB_LISTADO_PELICULAS = "listado_peliculas";
    static final String ATRIB_LISTADO_DETALLE_PELICULA = "listado_detalle_pelicula";
    static final String ATRIB_LISTADO_COMPOSICION = "listado_composicion";
    static final String ATRIB_LISTADO_FORMATO = "listado_formato";
    static final String ATRIB_LISTADO_TIPO = "listado_tipo";
    static final String ATRIB_LISTADO_GENERO1 = "listado_genero1";
    static final String ATRIB_LISTADO_GENERO2_3 = "listado_genero2_3";
    static final String ATRIB_PELI_REPETIDA = "peli_repetida";
    static final String ATRIB_MODO_BUSQUEDA = "campo_modo";

    static final String ATRIB_TOTAL_ENTRADAS = "total_entradas";
    static final String ATRIB_TOTAL_PELICULAS = "total_pelis";
    static final String ATRIB_TOTAL_DOCUMS = "total_docums";
    static final String ATRIB_TOTAL_SERIES = "total_series";
    static final String ATRIB_TOTAL_INFORMATICA = "total_informatica";
    static final String ATRIB_TOTAL_OTROS = "total_otros";

    static final String ATRIB_TOTAL_ACCION = "total_accion";
    static final String ATRIB_TOTAL_ADULTOS = "total_adultos";
    static final String ATRIB_TOTAL_FICCION = "total_ficcion";
    static final String ATRIB_TOTAL_COMEDIA = "total_comedia";
    static final String ATRIB_TOTAL_DRAMA = "total_drama";
    static final String ATRIB_TOTAL_INFANTIL = "total_infantil";
    static final String ATRIB_TOTAL_MUSICAL = "total_musical";
    static final String ATRIB_TOTAL_THRILLER = "total_thriller";
    static final String ATRIB_TOTAL_POLICIACA = "total_policiaca";
    static final String ATRIB_TOTAL_WESTERN = "total_western";
    static final String ATRIB_TOTAL_HISTORICA = "total_historica";
    static final String ATRIB_TOTAL_EPOCA = "total_epoca";
    static final String ATRIB_TOTAL_TERROR = "total_terror";
    static final String ATRIB_TOTAL_OTROS_PELICULA = "total_otros_pelicula";


    static final int PELICULAS_POR_PAGINA = 10;

    // Constantes para las paginas de salida

    static final String PREFIX = "/WEB-INF/jsp";

    static final String PG_ERROR = PREFIX + "/error.jsp";

    static final String PG_INDEX = "/index.html";
    static final String PG_LISTAR_PELICULAS = PREFIX + "/listarpeliculas.jsp";
    static final String PG_LISTAR_PELICULAS_RESUL_BUSQUEDA = PREFIX + "/listarpeliculasbusqueda.jsp";
    static final String PG_LISTAR_DETALLE_PELICULA = PREFIX + "/listardetallepelicula.jsp";
    static final String PG_ANADIR_PELICULA = PREFIX + "/anadirpeliculas.jsp";
    static final String PG_MODIFICAR_PELICULA = PREFIX + "/modificarpelicula.jsp";
    static final String PG_BUSCAR_PELICULAS = PREFIX + "/buscarpeliculas.jsp";
    static final String PG_LISTAR_PELICULAS_BUSQUEDA = PREFIX + "/listarpeliculasbusqueda.jsp";
    static final String PG_ORDENAR_PELICULAS = PREFIX + "/ordenarpeliculas.jsp";
    static final String PG_ESTADISTICAS = PREFIX + "/estadisticas.jsp";
}
