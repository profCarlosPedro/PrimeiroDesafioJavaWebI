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
 * Servlet implementation class AtualizarAluno
 */
@WebServlet("/AtualizarAluno")
public class AtualizarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarAluno() {
        super();
      
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
				aluno = dao.selecionar(matricula);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("aluno", aluno);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("EditAluno.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlunoDAO dao = new AlunoDAO();
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		try {
			dao.atualizar(aluno);
			response.sendRedirect("index.jsp");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	
	}

}
