package com.example.batch2redisimpl.services;

import com.example.batch2redisimpl.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KeyValueService {

    private static final String REDIS_KEY_PREFIX = "person::";
    private static final Long REDIS_KEY_EXPIRY = 10L;


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private String getKey(String key) {
        return REDIS_KEY_PREFIX + key;
    }

    public Person createPerson(Person person) {

        this.redisTemplate.opsForValue().set(getKey(person.getId()), person,REDIS_KEY_EXPIRY, TimeUnit.MINUTES);
        return person;
    }

    public Person getPerson(String id) {
        return (Person)redisTemplate.opsForValue().get(getKey(id));
    }
}
