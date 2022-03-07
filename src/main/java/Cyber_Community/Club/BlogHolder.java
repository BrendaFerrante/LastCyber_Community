package Cyber_Community.Club;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BlogHolder {
    private Map<Long, Blog> blogs= new ConcurrentHashMap<>();

}