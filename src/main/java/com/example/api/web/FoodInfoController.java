package com.example.api.web;

import com.example.api.entity.*;
import com.example.api.service.FoodEvaluateService;
import com.example.api.service.FoodInfoService;
import com.example.api.service.ImgInfoService;
import com.example.api.service.MenuInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/food")  //指定根路由
public class FoodInfoController {
    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private FoodInfoService foodInfoService;

    @Autowired
    private ImgInfoService imgInfoService;

    @Autowired
    private FoodEvaluateService foodEvaluateService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String,Object> list() {
        Map<String,Object> map = new HashMap<>();
        List<MenuInfo> menuList = menuInfoService.queryMenuInfo();
        for (int i = 0; i < menuList.size(); i++) {
            List<FoodInfo> foodList = foodInfoService.findList(menuList.get(i).getMenuId());
            map.put(menuList.get(i).getMenuId()+"",foodList);
        }
        return map;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    private Food detail(Integer foodId) {
        logger.info("-------/food/detail请求数据:" + foodId);
        Food food = new Food();
        FoodInfo foodInfo = foodInfoService.findFoodByKey(foodId);
        List<ImgInfo> imgInfoList = imgInfoService.findByFoodId(foodId);
        List<FoodEvaluate> foodEvaluateList = foodEvaluateService.findByFoodId(foodId);
        food.setFoodInfo(foodInfo);
        food.setImgInfoList(imgInfoList);
        food.setFoodEvaluateList(foodEvaluateList);
        return food;
    }

    @RequestMapping(value = "/like", method = RequestMethod.GET)
    private List<FoodInfo> like(String userId) {
        logger.info("-------/food/like请求数据:" + userId);
        List<FoodInfo> list = foodInfoService.findLike();
        if(null != list && list.size() > 8){
            list = list.subList(0,8);
        }
        return list;
    }
}
