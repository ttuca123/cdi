package br.com.cdi.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.cdi.entity.Usuario;
import br.com.cdi.util.EntityManagerProducer;

@Named
public class UsuarioDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3701201996250107679L;
	EntityManagerProducer emProducer;

	@Inject
	public UsuarioDAO(EntityManagerProducer emProducer) {
		this.emProducer = emProducer;

	}

	@Transactional
	public void salvar(Usuario usuario) {

		if (usuario.getId() == null) {

			emProducer.createEntityManager().persist(usuario);

		} else {
			emProducer.createEntityManager().merge(usuario);
		}

	}

	public List<Usuario> getLista() {

		return emProducer.createEntityManager().createNamedQuery("Usuario.buscaUsuarios").getResultList();
	}

}
