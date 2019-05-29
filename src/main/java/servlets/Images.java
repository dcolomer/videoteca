package servlets;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.Negocio;

public class Images extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) {

		String idPelicula = request.getParameter("id_pelicula");
		InputStream is = new Negocio().getCaratula(idPelicula);

		try {
			if (is == null) {
				String pathImag =
						this.getServletContext().getRealPath("/") + "images" + File.separator + "no_disponible.jpg";
				is = new FileInputStream(pathImag);
			}

			byte[] b_caratula = isToBa(is);

			response.setContentType("image/jpeg");
			response.setContentLength(b_caratula.length);
			response.getOutputStream().write(b_caratula);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			System.out.println("Error en el servlet Images al intentar obtener la caratula de la pelicula!");
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static byte[] isToBa (InputStream is) throws IOException {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		byte[] buffer = new byte[256];

		while (true) {
			int n = is.read(buffer);
			if (n < 0)
				break;
			out.write(buffer, 0, n);
		}

		out.flush();
		byte[] retorn = out.toByteArray();
		out.close();

		return retorn;
	}
}