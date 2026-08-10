package br.com.javaparaweb.financeiro.usuario;

import java.util.List;
import br.com.javaparaweb.financeiro.util.DAOFactory;

public class UsuarioRN {

	// CORRIGIDO: 'U' maiúsculo para referenciar a interface/classe correta
	private UsuarioDAO usuarioDAO; 

	public UsuarioRN() {
		// CORRIGIDO: Nome do método alinhado com a convenção camelCase
		this.usuarioDAO = DAOFactory.criarUsuarioDAO(); 
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if (codigo == null || codigo == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> lista() {
		return this.usuarioDAO.listar();
	}
}

