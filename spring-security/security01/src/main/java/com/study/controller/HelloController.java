package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello() {
        return "hello spring-security";
    }

    @RequestMapping(value = "/hellouser")
    @PreAuthorize(value = "hasAnyRole('ROLE_admin','ROLE_normal')")
    public String helloUser() {
        return "hello spring-security have normail Admin role";
    }

    @RequestMapping(value = "/helloadmin")
    @PreAuthorize(value = "hasAnyRole('ROLE_admin')")
    public String helloAdmin() {
        return "hello spring-security have Admin role";
    }
}
