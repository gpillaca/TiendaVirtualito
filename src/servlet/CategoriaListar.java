package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CategoriaBean;
import dao.interfaces.CategoriaDAO;
import daofactory.DAOFactory;

/**
 * Servlet implementation class CategoriaListar
 */
@WebServlet("/CategoriaListar")
public class CategoriaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CategoriaBean> categorias = null;
		try {
			DAOFactory daoFactory = DAOFactory.getFAOFactory(DAOFactory.MYSQL);
			CategoriaDAO categoriaDAO = daoFactory.getCategoriaDAO();
			categorias = categoriaDAO.listarCategorias();
		} catch (Exception e) {
			e.getMessage();
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		request.setAttribute("categorias", categorias);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}

}
