package com.example.batch2redisimpl.services;

import com.example.batch2redisimpl.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListValueService {

    private static final String REDIS_KEY = "personList";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public Long lpush(Person person) {
        return this.redisTemplate.opsForList().leftPush(REDIS_KEY,person);
    }

    public Long rpush(Person person) {
        return this.redisTemplate.opsForList().rightPush(REDIS_KEY,person);
    }

    public List<Person> lpop(Integer count) {
        return this.redisTemplate
                .opsForList()
                .leftPop(REDIS_KEY,count)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());

    }

    public List<Person> rpop(Integer count) {
        return this.redisTemplate
                .opsForList()
                .rightPop(REDIS_KEY,count)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }

    public List<Person> lrange(Integer start, Integer end) {
        return this.redisTemplate
                .opsForList()
                .range(REDIS_KEY,start,end)
                .stream()
                .map(x->(Person)x)
                .collect(Collectors.toList());
    }
}
