package com.example.api.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.FoodEvaluate;
import com.example.api.service.FoodEvaluateService;
import com.example.api.service.OrderInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/evaluate")  //指定根路由
public class FoodEvaluateController {
    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private FoodEvaluateService service;

    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<FoodEvaluate> list(Integer foodId) {
        logger.info("-------/evaluate/list请求数据:" + foodId);
        return service.findByFoodId(foodId);
    }

    @RequestMapping(value = "/issue", method = RequestMethod.POST)
    private String issue(@RequestBody String data) {
        logger.info("-------/evaluate/issue请求数据:" + data);
        JSONObject object = JSON.parseObject(data);
        String userId = object.get("userId") + "";
        String orderId = object.get("orderId") + "";
        JSONArray list = object.getJSONArray("list");
        for (int i = 0; i < list.size(); i++) {
            FoodEvaluate evaluate = new FoodEvaluate();
            JSONObject obj = list.getJSONObject(i);
            evaluate.setFoodId(obj.get("foodId") + "");
            evaluate.setContent(obj.get("evaluate") + "");
            evaluate.setUserId(userId);
            service.insert(evaluate);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("state","D");
        orderInfoService.updateState(map);
        return "succeed";
    }

    @RequestMapping(value = "/zan", method = RequestMethod.GET)
    private String zan(Integer id) {
        logger.info("-------赞:" + id);
        service.zan(id);
        return "succeed";
    }
}
