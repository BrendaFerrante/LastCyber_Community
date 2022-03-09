package Cyber_Community.entities;

import Cyber_Community.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BlogHolder {
    private Map<Long, Blog> blogs= new ConcurrentHashMap<>();
    private AtomicLong lastID_Blog = new AtomicLong();

    public BlogHolder(){
        Date date=new Date();
        blogs.put(lastID_Blog.incrementAndGet(),new Blog("new blog","new blog","new blog","new blog"));
    }

    public void add(Blog b) { //set the id too
        long id = lastID_Blog.incrementAndGet();
        b.setId(id);
        this.blogs.put(b.getId(), b);
    }
    public void add(long id, Blog b) {
        this.blogs.put(id, b);
    }

    public List<Blog> getAllBlogs(){ //Return all blogs in a list
        List<Blog> newList = new ArrayList<Blog>(this.blogs.values());
        return newList;
    }

    public Blog getBlog(long id){ //Return one blog
        return blogs.get(id);
    }

    public AtomicLong getId() {
        return this.lastID_Blog;
    }

    public Blog remove(long id) {
        return blogs.remove(id);
    }
}