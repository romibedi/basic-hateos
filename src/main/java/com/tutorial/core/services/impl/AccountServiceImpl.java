package com.tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.core.entities.Account;
import com.tutorial.core.entities.Blog;
import com.tutorial.core.repositories.AccountRepo;
import com.tutorial.core.repositories.BlogRepo;
import com.tutorial.core.services.AccountService;
import com.tutorial.core.services.exceptions.AccountDoesNotExistException;
import com.tutorial.core.services.exceptions.AccountExistsException;
import com.tutorial.core.services.exceptions.BlogExistsException;
import com.tutorial.core.services.util.AccountList;
import com.tutorial.core.services.util.BlogList;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
    private AccountRepo accountRepo;

	@Autowired
    private BlogRepo blogRepo;

    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    public Account createAccount(Account data) {
        Account account = accountRepo.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    public Blog createBlog(Long accountId, Blog data) {
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
    }

    public BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    public AccountList findAllAccounts() {
        return new AccountList(accountRepo.findAllAccounts());
    }

    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }
}
