package br.com.base.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.base.model.Contato;
import br.com.base.service.ContatoService;

/**
 * Servlet implementation class CadastroContatoController
 */
@WebServlet("/CadastroContatoController")
public class CadastroContatoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ContatoService service;
	
	private Contato contato;
       
    public CadastroContatoController() {
    	this.service = new ContatoService();
    	this.contato = new Contato();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		
		this.contato.setEmail(email);
		this.contato.setNome(nome);
		this.contato.setTelefone(telefone);
		
		try {
			
			this.service.salvar(this.contato);
			
			response.getWriter().
			append("<html>").
			append("<head><title>Cadastro Contato</title></head>").
			append("<body>").
			append("<h2 align='center'>Usu�rio "+nome+" cadastrado com sucesso.</h2>").
			append("</body>").
			append("</html>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ContatoService getService() {
		return service;
	}
	public void setService(ContatoService service) {
		this.service = service;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	
}
