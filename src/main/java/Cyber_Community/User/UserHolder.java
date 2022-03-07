package Cyber_Community.User;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserHolder {
    private Map<Long, User> users= new ConcurrentHashMap<>();



}