package com.example.api.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.LookHistory;
import com.example.api.service.FoodInfoService;
import com.example.api.service.LookHistoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/history")  //指定根路由
public class LookHistoryController {

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private LookHistoryService service;

    @Autowired
    private FoodInfoService foodInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@RequestBody String data) {
        logger.info("/history/add" + data);
        LookHistory his = new LookHistory();
        JSONObject object = JSON.parseObject(data);
        his.setUserId(object.get("userId") + "");
        his.setFoodId(object.get("foodId") + "");
        his.setImg(object.get("img") + "");
        service.insert(his);
        foodInfoService.browse(object.get("foodId") + "");
        return "succeed";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<LookHistory> list(String userId) {
        logger.info("/history/list" + userId);
        List<LookHistory> list = service.findByUserId(userId);
        if(null != list && list.size() > 10){
            list = list.subList(0,10);
        }
        return list;
    }
}
