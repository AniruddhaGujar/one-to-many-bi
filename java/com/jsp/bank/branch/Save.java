package com.jsp.bank.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Aniruddha");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		
		Bank bank = new Bank();
		bank.setName("HDFC");
		
		Branch branch1 = new Branch();
		branch1.setName("HDFC Vashi");
		branch1.setIfsc("HDFC123");
		
		Branch branch2 = new Branch();
		branch2.setName("HDFC Vashi");
		branch2.setIfsc("HDFC000");
		
		List<Branch> branchs = new ArrayList<Branch>();
		branchs.add(branch1);
		branchs.add(branch2);
		bank.setBranch(branchs);
		
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();
		
		
		
	}

}
