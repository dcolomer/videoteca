package servlets;

import negocio.Negocio;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import static servlets.Constantes.*;

public class ControladorHelper {

    static HttpServletRequest prepararEstadisticas(HttpServletRequest request) {

        Negocio neg = new Negocio();

        int total_entradas = neg.estadisticas(1);
        int total_pelis = neg.estadisticas(2);
        int total_docums = neg.estadisticas(3);
        int total_series = neg.estadisticas(4);
        int total_informatica = neg.estadisticas(20);
        int total_otros = neg.estadisticas(5);
        int total_accion = neg.estadisticas(6);
        int total_adultos = neg.estadisticas(7);
        int total_ficcion = neg.estadisticas(8);
        int total_comedia = neg.estadisticas(9);
        int total_drama = neg.estadisticas(10);
        int total_infantil = neg.estadisticas(11);
        int total_musical = neg.estadisticas(12);
        int total_thriller = neg.estadisticas(13);
        int total_policiaca = neg.estadisticas(14);
        int total_western = neg.estadisticas(15);
        int total_historica = neg.estadisticas(16);
        int total_epoca = neg.estadisticas(17);
        int total_terror = neg.estadisticas(18);
        int total_otros_pelicula = neg.estadisticas(19);

        request.setAttribute(ATRIB_TOTAL_ENTRADAS, total_entradas);
        request.setAttribute(ATRIB_TOTAL_PELICULAS, total_pelis);
        request.setAttribute(ATRIB_TOTAL_DOCUMS, total_docums);
        request.setAttribute(ATRIB_TOTAL_SERIES, total_series);
        request.setAttribute(ATRIB_TOTAL_INFORMATICA, total_informatica);
        request.setAttribute(ATRIB_TOTAL_OTROS, total_otros);

        request.setAttribute(ATRIB_TOTAL_ACCION, total_accion);
        request.setAttribute(ATRIB_TOTAL_ADULTOS, total_adultos);
        request.setAttribute(ATRIB_TOTAL_FICCION, total_ficcion);
        request.setAttribute(ATRIB_TOTAL_COMEDIA, total_comedia);
        request.setAttribute(ATRIB_TOTAL_DRAMA, total_drama);
        request.setAttribute(ATRIB_TOTAL_INFANTIL, total_infantil);
        request.setAttribute(ATRIB_TOTAL_MUSICAL, total_musical);
        request.setAttribute(ATRIB_TOTAL_THRILLER, total_thriller);
        request.setAttribute(ATRIB_TOTAL_POLICIACA, total_policiaca);
        request.setAttribute(ATRIB_TOTAL_WESTERN, total_western);
        request.setAttribute(ATRIB_TOTAL_HISTORICA, total_historica);
        request.setAttribute(ATRIB_TOTAL_EPOCA, total_epoca);
        request.setAttribute(ATRIB_TOTAL_TERROR, total_terror);
        request.setAttribute(ATRIB_TOTAL_OTROS_PELICULA, total_otros_pelicula);

        return request;
    }

    static String prepararBusqueda(HttpServletRequest request) {

        String resultado = "AND";

        String campo_busqueda = request.getParameter("campo_busqueda");
        String patron = request.getParameter("patron");
        String modo = request.getParameter("campo_modo");

        if (modo.compareTo("=") == 0) {
            if (campo_busqueda.compareTo("titulos") == 0) {
                resultado += " titulo LIKE '%" + patron + "%' OR subtitulo LIKE '%" + patron + "%'";
            } else if (campo_busqueda.compareTo("director") == 0) {
                resultado += " director LIKE '%" + patron + "%'";
            } else if (campo_busqueda.compareTo("actores") == 0) {
                resultado += " actor1 LIKE '%" + patron + "%' OR actor2 LIKE '%" + patron + "%' OR actor3 LIKE '%" + patron + "%'";
            }
        } else if (modo.compareTo("==") == 0) {
            if (campo_busqueda.compareTo("titulos") == 0) {
                resultado += " titulo='" + patron + "' OR subtitulo='" + patron + "'";
            } else if (campo_busqueda.compareTo("director") == 0) {
                resultado += " director='" + patron + "'";
            } else if (campo_busqueda.compareTo("actores") == 0) {
                resultado += " actor1='" + patron + "' OR actor2='" + patron + "' OR actor3='" + patron + "'";
            }
        }

        return resultado;
    }

    static String prepararOrdenacion(HttpServletRequest request) {

        String resultado = null;

        String campo_orden = request.getParameter("campo_orden");

        if (campo_orden.compareTo("id_pelicula") == 0) {
            resultado = " ORDER BY id_pelicula";
        } else if (campo_orden.compareTo("titulo") == 0) {
            resultado =" ORDER BY titulo";
        } else if (campo_orden.compareTo("director") == 0) {
            resultado = " ORDER BY director";
        } else if (campo_orden.compareTo("localizacion") == 0) {
            resultado = " ORDER BY localizacion";
        } else if (campo_orden.compareTo("genero") == 0) {
            resultado = " ORDER BY genero1, genero2, genero3";
        } else if (campo_orden.compareTo("visualizada") == 0) {
            resultado = " ORDER BY visualizada";
        }
        return resultado;
    }

    static String prepararPaginacion(HttpServletRequest request) {

        String resultado = null;

        String s_pagina_actual = request.getParameter("pagina_actual");

        int pagina_actual = 0;

        if (s_pagina_actual != null) {
            pagina_actual = Integer.parseInt(s_pagina_actual);
        }

        int desde_fila = 0;

        if (pagina_actual == 0) {
            desde_fila = 1;
        } else {
            desde_fila = pagina_actual * PELICULAS_POR_PAGINA + 1;
        }

        resultado = "LIMIT " + (desde_fila - 1) + ", " + PELICULAS_POR_PAGINA;

        request.setAttribute("pagina_actual", pagina_actual);

        return resultado;
    }
}
