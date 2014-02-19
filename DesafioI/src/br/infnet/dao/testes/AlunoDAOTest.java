package br.infnet.dao.testes;


import java.sql.SQLException;

import org.junit.Test;

import br.infnet.dao.AlunoDAO;
import br.infnet.domain.Aluno;

public class AlunoDAOTest {

	@Test
	public void InserirTest() throws ClassNotFoundException, SQLException {
		Aluno aluno = new Aluno();
		aluno.setMatricula("12345");
		aluno.setNome("Carlos Pedro");
		AlunoDAO dao = new AlunoDAO();
		dao.inserir(aluno);
	}

}
