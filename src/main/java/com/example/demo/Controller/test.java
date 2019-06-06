package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class test {

    @RequestMapping("/test")
    public String testmethod(){
        return "index.html";
    }

    @RequestMapping("/p")
    @ResponseBody
    public List p(String time){
        List l= new ArrayList();
        Map<String,String> m=new HashMap<>();
        m.put("name","22");
        m.put("take","22");
        m.put("Time","22");
        l.add(m);
        System.out.println(time);
        return l;
    }

    @RequestMapping("/q")
    @ResponseBody
    public List q(String value){
        List l= new ArrayList();
        Map<String,String> m=new HashMap<>();
        m.put("name","12");
        m.put("take","12");
        m.put("Time","12");
        l.add(m);
        System.out.println(value);
        return l;
    }}

