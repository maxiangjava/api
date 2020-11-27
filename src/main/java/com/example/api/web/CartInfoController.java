package com.example.api.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.CartInfo;
import com.example.api.service.CartInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/cart")  //指定根路由
public class CartInfoController {
    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private CartInfoService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<CartInfo> list(Integer userId) {
        return service.findList(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    private String add(String foodId,Integer userId) {
        CartInfo record = new CartInfo();
        record.setFoodId(foodId);
        record.setUserId(userId);
        CartInfo cart = service.findByFoodIdAndUserId(record);
        //不存在，直接加
        if(null == cart){
            record.setChecked(false);
            record.setSum(1);
            service.insert(record);
            return "添加购物车成功";
        //存在，数量加一
        }else{
            cart.setSum(cart.getSum() + 1);
            service.sumAdd(cart);
            return "数量加一";
        }

    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    private String del(Integer id) {
        service.deleteByPrimaryKey(id);
        return "succeed";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    private String remove(Integer userId) {
        service.removeAll(userId);
        return "succeed";
    }

    @RequestMapping(value = "/updateSum", method = RequestMethod.POST)
    private String updateSum(@RequestBody String data) {
        logger.info("修改购物车数量：" + data);
        JSONObject object = JSON.parseObject(data);
        CartInfo cart = new CartInfo();
        cart.setFoodId(object.get("foodId") + "");
        cart.setSum(object.getInteger("sum"));
        service.updateSum(cart);
        return "succeed";
    }
}
