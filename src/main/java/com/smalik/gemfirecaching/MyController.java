package com.smalik.gemfirecaching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    @GetMapping("/hello/{id}")
    @Cacheable("my-beans")
    public MyBean getMessage(@PathVariable String id) {
        return new MyBean(new Date(), "spring rocks", id);
    }

    @DeleteMapping("/hello/{id}")
    @CacheEvict("my-beans")
    public void invalidate(@PathVariable String id) { }
}
