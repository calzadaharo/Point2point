package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAOImplementation;
import model.Usuario;
import model.Viaje;

/**
 * Servlet implementation class Form3ViajeFav
 */
@WebServlet("/Form3ViajeFav")
public class Form3ViajeFav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form3ViajeFav() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		List<Viaje> viajes = usuario.getViajes_fav();
		//Professor advisor = ProfessorDAOImplementation.getInstance().read(advisorEmail);
		Viaje viaje= new Viaje();
		viaje.setId(id);
		viaje.setOrigen(origen);
		viaje.setDestino(destino);
		viaje.setUsuario(usuario);
		viajes.add(viaje);
		usuario.setViajes_fav(viajes);
		UsuarioDAOImplementation.getInstance().update(usuario);
		req.getSession().setAttribute("usuario", usuario);
		getServletContext().getRequestDispatcher("/UsuarioView.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
