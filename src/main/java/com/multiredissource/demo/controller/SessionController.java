package com.multiredissource.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {
    /*
    * read session
    * */
    @RequestMapping("/get")
    public Object getSession(HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("user", request.getSession().getAttribute("user"));
        map.put("maxInactiveInterval", request.getSession().getMaxInactiveInterval());
        //map.put("ttl", request.getSession().);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date(request.getSession().getCreationTime()));
        map.put("creationTime", time);
        return map;
    }

    /*
    * write session
    * */
    @RequestMapping("/set/{name}")
    public String setSession(@PathVariable String name, HttpServletRequest request) {
        request.getSession().setAttribute("user", name);
        return "ok";
    }
}
