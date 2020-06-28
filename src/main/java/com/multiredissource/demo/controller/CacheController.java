package com.multiredissource.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Resource
    RedisTemplate<String, String> redis1Template;
    @Resource
    RedisTemplate<String, String> redis2Template;

    /*
    * get redis1 cache
    */
    @RequestMapping("/redis1get")
    public String redis1Get(HttpServletRequest request){
        String goodsname = redis1Template.opsForValue().get("goodsname1");
        return goodsname;
    }

    /*
     * write redis1 cache
     */
    @RequestMapping("/redis1set/{name}")
    public String redis1Set(@PathVariable String name) {
        //request.getSession().setAttribute("goods", name);
        redis1Template.opsForValue().set("goodsname1",name);
        return "ok";
    }

    /*
     * get redis2 cache
     * */
    @RequestMapping("/redis2get")
    public String redis2Get(HttpServletRequest request){
        String goodsname2 = redis2Template.opsForValue().get("goodsname2");
        return goodsname2;
    }

    /*
     * write redis2 cache
     * */
    @RequestMapping("/redis2set/{name}")
    public String redis2Set(@PathVariable String name) {
        //request.getSession().setAttribute("goods", name);
        redis2Template.opsForValue().set("goodsname2",name);
        return "ok";
    }
}
