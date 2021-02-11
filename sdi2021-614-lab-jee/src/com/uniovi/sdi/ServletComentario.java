package com.uniovi.sdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComentario
 */
@WebServlet("/comentario")
public class ServletComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ComentariosService comentariosService=new ComentariosService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComentario() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Comentario>comentarios=comentariosService.getComentarios();
		 request.setAttribute("comentariosBase",comentarios);
		  getServletContext().getRequestDispatcher("/vista-comentarios.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
