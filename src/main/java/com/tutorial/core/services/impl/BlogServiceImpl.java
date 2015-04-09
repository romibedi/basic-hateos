package com.tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.core.entities.Blog;
import com.tutorial.core.entities.BlogEntry;
import com.tutorial.core.repositories.BlogEntryRepo;
import com.tutorial.core.repositories.BlogRepo;
import com.tutorial.core.services.BlogService;
import com.tutorial.core.services.exceptions.BlogNotFoundException;
import com.tutorial.core.services.util.BlogEntryList;
import com.tutorial.core.services.util.BlogList;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
    private BlogRepo blogRepo;

	@Autowired
    private BlogEntryRepo entryRepo;

    public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepo.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
    }

    public BlogList findAllBlogs() {
        return new BlogList(blogRepo.findAllBlogs());
    }

    public BlogEntryList findAllBlogEntries(Long blogId) {
        Blog blog = blogRepo.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
    }

    public Blog findBlog(Long id) {
        return blogRepo.findBlog(id);
    }
}
