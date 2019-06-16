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

    @RequestMapping("/chart")
    @ResponseBody
    public Map chart(){

        Map<String,Object> m=new HashMap<>();
        Map<String,Object> xAxis=new HashMap<>();
        Map<String,Object> yAxis=new HashMap<>();
        Map<String,Object> series_list=new HashMap<>();
        String type_xAxis="category";
        String type_yAxis="value";
        String type_series="line";
        List<String>  data_xAxis=new ArrayList<>();
        List<Integer>  data_series=new ArrayList<>();
        List<Map>  series=new ArrayList<>();
        for(int i=0;i<7;i++){
            data_xAxis.add("Mon");
            data_series.add(5);
        }
        xAxis.put("type",type_xAxis);
        xAxis.put("data",data_xAxis);
        yAxis.put("type",type_yAxis);
        series_list.put("data",data_series);
        series_list.put("type",type_series);
        series.add(series_list);
        m.put("xAxis",xAxis);
        m.put("yAxis",yAxis);
        m.put("series",series);
        System.out.println(m);
        return m;
    }

    @RequestMapping("/test")
    public String testmethod(){
        return "chart.html";
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
        Map<String,Object> m_all=new HashMap<>();
        m_all.put("pagenum","5");
        m_all.put("data",l);
        System.out.println(time);
        return l;
    }

    @RequestMapping("/q")
    @ResponseBody
    public Map q(){
        List l= new ArrayList();
        Map<String,String> m=new HashMap<>();
        m.put("name","12");
        m.put("take","12");
        m.put("Time","12");
        l.add(m);
        Map<String,Object> m_all=new HashMap<>();
        m_all.put("pagenum",5);
        m_all.put("data",l);
        return m_all;
    }}

