package br.com.cdi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cdi.dao.UsuarioDAO;
import br.com.cdi.entity.Usuario;

@Named("usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private Usuario usuario;

	@Named("filteredUsuarios")
	private List<Usuario> filteredUsuarios = new ArrayList<Usuario>();

	@PostConstruct
	public void postConstruct() {

		usuario = new Usuario();
		getListar();
	}

	public String salvar() {

		usuarioDAO.salvar(usuario);

		return "OK";
	}

	public List<Usuario> getUsuarios() {

		return usuarioDAO.getLista();

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getFilteredUsuarios() {
		return filteredUsuarios;
	}

	public void setFilteredUsuarios(List<Usuario> filteredUsuarios) {
		this.filteredUsuarios = filteredUsuarios;
	}

	public String getListar() {

		this.filteredUsuarios = usuarioDAO.getLista();
		return "listar_usuarios.xhtml";
	}

}
