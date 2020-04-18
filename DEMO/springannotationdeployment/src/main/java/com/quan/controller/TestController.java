package com.quan.controller;

import org.springframework.stereotype.Controller;

@Controller
//@RequestMapping("/cart/")
public class TestController {

    //@RequestMapping("service1.do")
    public String service1(){
        return "service1";
    }

  //@RequestMapping("service2.do")
    public String service2(){
        return "service2";
    }
}

