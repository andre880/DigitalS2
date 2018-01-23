package br.com.fiap.banco;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Curso;

public class PopulaBanco {

	
	//Popula a base de dados para a NAC
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CARGA_BANCO");
		EntityManager em = factory.createEntityManager();
		
		Curso c1 = new Curso("Android", 5, Calendar.getInstance(), 40, 3000);
		Curso c2 = new Curso("Java", 3, Calendar.getInstance(), 16, 1000);
		Curso c3 = new Curso("C#", 1, Calendar.getInstance(), 8, 300);
		Curso c4 = new Curso("IOS", 4, Calendar.getInstance(), 40, 5000);
		Curso c5 = new Curso("PHP", 2, Calendar.getInstance(), 20, 700);
		Curso c6 = new Curso("Ruby", 4, Calendar.getInstance(), 30, 1200);
		Curso c7 = new Curso("Phyton", 3, Calendar.getInstance(), 18, 900);
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.persist(c6);
		em.persist(c7);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.exit(0);
	}
	
}
