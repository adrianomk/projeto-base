package br.com.base.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.base.main.Conection;
import br.com.base.model.Contato;

public class ContatoRepository {

	private Conection conexao = null;
	
	public ContatoRepository() {
		this.conexao = new Conection();
	}
	
	public void salvar(Contato contato) throws SQLException {
		
		String sql = "INSERT INTO contato (nome,email,telefone) VALUES (?,?,?)";
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getTelefone());
		
		stmt.execute();
		
		stmt.close();
		this.getConexao().getConnection().close();
	}

	public void apagar(int id) throws SQLException {
		
		String sql = "DELETE FROM contato WHERE id = ?";
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
		
		stmt.setInt(1, id);
		
		stmt.execute();
		
		stmt.close();
		this.getConexao().getConnection().close();
	}
	
	public List<Contato> listarContatos() throws SQLException{
		List<Contato> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contato";
		PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sql);
		
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			
			Contato contato = new Contato();
			contato.setId(res.getLong("id"));
			contato.setNome(res.getString("nome"));
			contato.setEmail(res.getString("email"));
			contato.setTelefone(res.getString("telefone"));
			
			contatos.add(contato);
		}
		
		return contatos;
		
	}

	public Conection getConexao() {
		return conexao;
	}

	public void setConexao(Conection conexao) {
		this.conexao = conexao;
	}
	
	
}
