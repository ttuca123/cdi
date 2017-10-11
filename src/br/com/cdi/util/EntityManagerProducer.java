package br.com.cdi.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	public EntityManagerProducer(){
		this.emf = Persistence.createEntityManagerFactory("teste-cdi");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager(){
		
		
		return emf.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager em){
		
		if(em.isOpen()){
			
			em.close();
		}
	}
	
}
