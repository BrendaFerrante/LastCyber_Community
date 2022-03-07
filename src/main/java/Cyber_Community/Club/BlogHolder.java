package Cyber_Community.Club;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BlogHolder {
    private Map<Long, Blog> blogs= new ConcurrentHashMap<>();
    private AtomicLong lastID = new AtomicLong();

    public void addBlog(Blog b) {
        long id = lastID.incrementAndGet();
        b.setId(id);
        this.blogs.put(b.getId(), b);
    }

    public Collection<Blog> getBlog(){
        return blogs.values();
    }

    public Blog getItem(long id){
        return blogs.get(id);
    }
}