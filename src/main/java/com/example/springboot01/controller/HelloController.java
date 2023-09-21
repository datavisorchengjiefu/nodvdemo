package com.example.springboot01.controller;

import com.example.springboot01.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    private static AtomicLong count = new AtomicLong();

    public static void main(String[] args) {

    }

    @Autowired
    private HelloService hello;

    @Autowired
    ApplicationContext context;

    @RequestMapping("/hhh01")
    public Object helloha02() {
        return "hello haha fcjdormi 01. ";
    }

    @RequestMapping("/hhh02")
    public Object helloha02(@RequestBody String rawExternal) {
        return rawExternal + "hello haha fcjdormi 02. ";
    }

    @GetMapping("/test01")
    public String test01Controller() {
        LOGGER.info(Thread.currentThread().getName() + " 进入test01Controller方法");
        String result = hello.sayHello();
        LOGGER.info(Thread.currentThread().getName() + " 从test01Controller方法返回");
        return result;
    }

    @GetMapping("/test02")
    public String test02Controller(
            @RequestParam(value = "cpName", defaultValue = "") String cpName) {
        LOGGER.info(Thread.currentThread().getName() + " 进入test01Controller方法");
        String result = "ha " + cpName;
        LOGGER.info(Thread.currentThread().getName() + " 从test01Controller方法返回");
        return result;
    }

    @GetMapping("/helloha")
    public Callable<String> helloController() {
        LOGGER.info(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                LOGGER.info(Thread.currentThread().getName() + " 进入call方法");
                String say = hello.sayHello();
                LOGGER.info(Thread.currentThread().getName() + " 从helloService方法返回");
                return say;
            }
        };
        LOGGER.info(Thread.currentThread().getName() + " 从helloController方法返回");
        return callable;
    }

}
