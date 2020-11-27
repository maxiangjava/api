package com.example.api.web;

import com.example.api.entity.FoodFavorite;
import com.example.api.service.FoodFavoriteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/favorite")  //指定根路由
public class FoodFavoriteController {
    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private FoodFavoriteService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<FoodFavorite> list(String userId) {
        logger.info("查看收藏记录：" + userId);
        return service.findList(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@RequestBody  FoodFavorite favorite) {
        service.insert(favorite);
        return "succeed";
    }

}
