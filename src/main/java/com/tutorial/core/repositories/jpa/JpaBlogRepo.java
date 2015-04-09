package com.tutorial.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tutorial.core.entities.Blog;
import com.tutorial.core.repositories.BlogRepo;

@Repository
public class JpaBlogRepo implements BlogRepo {
    @PersistenceContext
    private EntityManager em;

    public Blog createBlog(Blog data) {
        em.persist(data);
        return data;
    }

    public List<Blog> findAllBlogs() {
        Query query = em.createQuery("SELECT b from Blog b");
        return query.getResultList();
    }

    public Blog findBlog(Long id) {
        return em.find(Blog.class, id);
    }

    public Blog findBlogByTitle(String title) {
        Query query = em.createQuery("SELECT b from Blog b where b.title=?1");
        query.setParameter(1, title);
    
        List<Blog> blogs = query.getResultList();
        
        if(blogs.isEmpty()) {
            return null;
        } else {
            return blogs.get(0);
        }
    }

    public List<Blog> findBlogsByAccount(Long accountId) {
        Query query = em.createQuery("SELECT b from Blog b where b.owner.id=?1");
        query.setParameter(1, accountId);
        return query.getResultList();
    }
}
