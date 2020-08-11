package com.smalik.gemfirecaching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    @GetMapping("/hello")
    @Cacheable("my-beans")
    public MyBean getMessage() {
        return new MyBean(new Date(), "spring rocks");
    }
}
