package com.tutorial.core.services;

import com.tutorial.core.entities.Account;
import com.tutorial.core.entities.Blog;
import com.tutorial.core.services.util.AccountList;
import com.tutorial.core.services.util.BlogList;


public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
