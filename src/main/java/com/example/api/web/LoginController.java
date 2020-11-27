package com.example.api.web;

import org.springframework.web.bind.annotation.*;

/**
 * Created by matthew on 2020/10/26.
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/login")
    public String login(){
        return "ok";
    }
}
