package br.unitins.topicosii.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.topicosii.model.Pessoa;

@Named
@ViewScoped
public class PessoaController implements Serializable{

	
	private static final long serialVersionUID = -3326402496379915015L;

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa("Caio","Rua tal","caio@gmail.com");
		
		//Cria fabrica da persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicosII");
		//Cria a entidade
		EntityManager em = emf.createEntityManager();
		//Inicia a transacao com o banco
		em.getTransaction().begin();
		//Persiste
		em.persist(p);
		//Comita
		em.getTransaction().commit();
		//Exibir mensagem
		System.out.println("Feito");
		
	}
}
