package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AlunoDAO;
import br.infnet.domain.Aluno;

/**
 * Servlet implementation class ExcluirAluno
 */
@WebServlet("/ExcluirAluno")
public class ExcluirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String matricula = request.getParameter("id");
		Aluno aluno = null;
		if (matricula != null) {
			AlunoDAO dao = new AlunoDAO();
			try {
				dao.excluir(matricula);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("aluno", aluno);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}
