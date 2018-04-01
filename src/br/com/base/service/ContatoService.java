/**
 * 
 */
package br.com.base.service;

import java.sql.SQLException;
import java.util.List;

import br.com.base.model.Contato;
import br.com.base.repository.ContatoRepository;

/**
 * @author lab04usuario06
 *
 */
public class ContatoService {

	private ContatoRepository repository;
	
	public ContatoService() {
		this.repository = new ContatoRepository();
	}
	
	public void salvar(Contato contato) throws SQLException {
		this.repository.salvar(contato);
	}

	public void apagar(int id) throws SQLException {
		this.repository.apagar(id);
	}
	
	public List<Contato> listarContato() throws SQLException{
		return this.repository.listarContatos();
	}

	public ContatoRepository getRepository() {
		return repository;
	}

	public void setRepository(ContatoRepository repository) {
		this.repository = repository;
	}
	
	
}
