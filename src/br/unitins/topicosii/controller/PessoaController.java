package br.unitins.topicosii.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.topicosii.model.Pessoa;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = -3326402496379915015L;
	// Cria fabrica da persistencia
		private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TopicosII");
		// Cria o gerenciador de entidade
		private EntityManager em = emf.createEntityManager();

		private Pessoa pessoa = null;
		private List<Pessoa> listaPessoa = null;

		public void incluir() {
			// Inicia a conexao com o banco de dados
			em.getTransaction().begin();
			// Persiste no banco as informacoes
			em.persist(getPessoa());
			// Comita os dados
			em.getTransaction().commit();
			limpar();
			// Exibir mensagem
			System.out.println("Feito!");
		}

		public void limpar() {
			setPessoa(null);
			listaPessoa = null;
		}
			

		public List<Pessoa> getListaPessoa() {
			if (listaPessoa == null) {
				listaPessoa = new ArrayList<Pessoa>();
				listaPessoa = em.createQuery("Select p From Pessoa p").getResultList();
				
				//verifica se a lista pessoa ainda nula 
				if(listaPessoa == null)
					listaPessoa = new ArrayList<Pessoa>();
			}
			return listaPessoa;
		}

		public Pessoa getPessoa() {
			if (pessoa == null) {
				pessoa = new Pessoa();
			}
			return pessoa;
		}

		public void setPessoa(Pessoa pessoa) {
			this.pessoa = pessoa;
		}

	}
