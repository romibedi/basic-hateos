package com.tutorial.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tutorial.core.entities.Account;
import com.tutorial.core.repositories.AccountRepo;

@Repository
public class JpaAccountRepo implements AccountRepo{

	@PersistenceContext
	private EntityManager em;
	
	public List<Account> findAllAccounts() {
		 Query query = em.createQuery("SELECT a FROM Account a");
	     
		 return query.getResultList();
	}

	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

	public Account findAccountByName(String name) {
		Query query = em.createQuery("SELECT a FROM Account a WHERE a.name=?1");
        query.setParameter(1, name);
        
        List<Account> accounts = query.getResultList();
        
        if(accounts.size() == 0) {
            return null;
        } else {
            return accounts.get(0);
        }
	}

	public Account createAccount(Account data) {
		em.persist(data);
		return data;
	}

}
