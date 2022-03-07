package Cyber_Community.Club;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BlogHolder {
    private Map<Long, Blog> blogs= new ConcurrentHashMap<>();
    private AtomicLong lastID_Blog = new AtomicLong();

    public void add(Blog b) { //set the id too
        long id = lastID_Blog.incrementAndGet();
        b.setId(id);
        this.blogs.put(b.getId(), b);
    }
    public void add(long id, Blog b) {
        this.blogs.put(id, b);
    }

    public Collection<Blog> getBlog(){ //Return all blogs
        return blogs.values();
    }

    public Blog getBlog(long id){ //Return one blog
        return blogs.get(id);
    }

    public AtomicLong getId() {
        return lastID_Blog;
    }

    public Blog remove(long id) {
        return blogs.remove(id);
    }
}