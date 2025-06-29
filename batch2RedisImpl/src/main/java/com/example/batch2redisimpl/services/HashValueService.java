package com.example.batch2redisimpl.services;

import com.example.batch2redisimpl.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HashValueService {

    private static final String REDIS_HASH_PREFIX = "personHash::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public String getKey(String key) {
        return REDIS_HASH_PREFIX + key;
    }

    public Person create(Person person) {
        Map hashMap = objectMapper.convertValue(person, Map.class);
        this.redisTemplate.opsForHash().putAll(getKey(person.getId()),hashMap);
        return person;
    }

    public Person getAll(String id) {
        Map mp =  this.redisTemplate.opsForHash().entries(getKey(id));
        return this.objectMapper.convertValue(mp, Person.class);
    }

    public Object getFieldValue(String id, String field) {
        return this.redisTemplate.opsForHash().get(getKey(id), field);
    }

    public void delete(String id, String field) {
        this.redisTemplate.opsForHash().delete(getKey(id), field);
    }
}
