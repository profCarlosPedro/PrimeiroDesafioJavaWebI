package br.infnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.infnet.domain.Aluno;

public class AlunoDAO {

	private Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/controlepauta", "root", "admin");

	}

	public void inserir(Aluno aluno) throws ClassNotFoundException,
			SQLException {
		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("insert into aluno  VALUES ( ?, ?)");
		query.setString(1, aluno.getMatricula());
		query.setString(2, aluno.getNome());
		query.execute();

	}

	public List<Aluno> selecionar() throws ClassNotFoundException, SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("SELECT Matricula, Nome from aluno");

		ResultSet resultados = query.executeQuery();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		while (resultados.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(resultados.getString("Matricula"));
			aluno.setNome(resultados.getString("Nome"));
			alunos.add(aluno);
		}
		return alunos;

	}

	public Aluno selecionar(String matricula) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("SELECT Matricula, Nome from aluno where Matricula = ?");
		query.setString(1, matricula);
		ResultSet resultados = query.executeQuery();
		Aluno aluno = null;
		if (resultados.next()) {
			aluno = new Aluno();
			aluno.setMatricula(resultados.getString("Matricula"));
			aluno.setNome(resultados.getString("Nome"));

		}
		return aluno;

	}

	public void atualizar(Aluno aluno) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("update aluno set nome=? where matricula= ?");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getMatricula());
		query.execute();

	}

	public void excluir(String matricula) throws ClassNotFoundException,
			SQLException {

		Connection conexao = getConexao();
		PreparedStatement query = conexao
				.prepareStatement("delete from aluno where matricula= ?");
		query.setString(1, matricula);
		query.execute();

	}

}
