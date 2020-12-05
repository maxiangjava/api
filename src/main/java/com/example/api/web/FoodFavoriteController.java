package com.example.api.web;

import com.example.api.entity.Favorite;
import com.example.api.entity.FoodFavorite;
import com.example.api.entity.FoodInfo;
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
    private List<Favorite> list(String userId) {
        logger.info("查看收藏记录：" + userId);
        return service.findList(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@RequestBody  FoodFavorite favorite) {
        if(null == service.findByUserIdFoodId(favorite)){
            logger.info("收藏记录为空，开始增加");
            service.insert(favorite);
        }
        return "succeed";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    private String del(String favoriteId) {
        logger.info("删除收藏记录：" + favoriteId);
        service.delByKey(favoriteId);
        return "succeed";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    private String remove(String userId) {
        logger.info("清空收藏记录：" + userId);
        service.remove(userId);
        return "succeed";
    }


}
