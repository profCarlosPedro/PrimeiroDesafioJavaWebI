package edu.infnet.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.infnet.dao.AlunoDAO;
import br.infnet.domain.Aluno;

/**
 * Servlet implementation class InserirAluno
 */
@WebServlet("/InserirAluno")
public class InserirAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public InserirAluno() {

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		AlunoDAO dao = new AlunoDAO();
			String matricula = request.getParameter("matricula");
			String nome = request.getParameter("nome");
			Aluno aluno = new Aluno();
			aluno.setMatricula(matricula);
			aluno.setNome(nome);
			try {
				dao.inserir(aluno);
				response.sendRedirect("index.jsp");
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}


