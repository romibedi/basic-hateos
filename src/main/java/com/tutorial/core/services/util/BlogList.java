package com.tutorial.core.services.util;

import java.util.ArrayList;
import java.util.List;

import com.tutorial.core.entities.Blog;

public class BlogList {
	 private List<Blog> blogs = new ArrayList<Blog>();

	    public BlogList(List resultList) {
	        this.blogs = resultList;
	    }

	    public List<Blog> getBlogs() {
	        return blogs;
	    }

	    public void setBlogs(List<Blog> blogs) {
	        this.blogs = blogs;
	    }
}
