package com.example.api.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.Order;
import com.example.api.entity.OrderDetail;
import com.example.api.entity.OrderInfo;
import com.example.api.entity.PayHistory;
import com.example.api.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/order")  //指定根路由
public class OrderController {

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private OrderInfoService service;

    @Autowired
    private OrderDetailService detailService;

    @Autowired
    private CartInfoService cartInfoService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PayHistoryService payHistoryService;

    @Autowired
    private FoodInfoService foodInfoService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@RequestBody String data) {
        logger.info("-------请求数据:" + data);
        JSONObject object = JSON.parseObject(data);
        String userId = object.get("userId") + "";
        Double amount = object.getDouble("amount");

        String id = UUID.randomUUID().toString();
        OrderInfo info = new OrderInfo();
        info.setOrderId(id);
        info.setUserId(userId);
        info.setTitle(object.getJSONArray("detail").getJSONObject(0).getString("title"));
        info.setAmount(BigDecimal.valueOf(amount));
        info.setState("A");
        service.insert(info);

        JSONArray details = object.getJSONArray("detail");
        for (int i = 0;i < details.size();i++){
            JSONObject obj = details.getJSONObject(i);
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(id);
            detail.setFoodId(obj.getString("foodId"));
            if(null == obj.get("sum")){
                detail.setNum(0);
            }else {
                detail.setNum(obj.getInteger("sum"));
            }
            detail.setTitle(obj.getString("title"));
            detail.setPrice(BigDecimal.valueOf(obj.getDouble("price")));
            detail.setImg(obj.getString("img"));
            detailService.insert(detail);
        }
        return id;
    }

    @RequestMapping(value = "/again", method = RequestMethod.GET)
    private String again(String orderId) {
        logger.info("-------再来一单:" + orderId);
        String id = UUID.randomUUID().toString();
        OrderInfo orderInfo = service.findByOrderId(orderId);
        orderInfo.setOrderId(id);
        service.insert(orderInfo);
        List<OrderDetail> detailList = detailService.findByOrderId(orderId);
        for (OrderDetail detail : detailList) {
            detail.setOrderId(id);
            detailService.insert(detail);
        }
        return id;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    private Order info(String orderId) {
        logger.info("-------请求数据:" + orderId);
        Order order = new Order();
        order.setOrderInfo(service.findByOrderId(orderId));
        order.setOrderDetailList(detailService.findByOrderId(orderId));
        return order;
    }

    @RequestMapping(value = "/listByState", method = RequestMethod.GET)
    private List<Order> list(String userId,String state) {
        logger.info("-------请求数据:" + userId);
        logger.info("-------请求数据:" + state);
        List<Order> orderList = new ArrayList<>();
        OrderInfo info = new OrderInfo();
        info.setUserId(userId);
        info.setState(state);
        List<OrderInfo> infos;
        if("ALL".equals(state)){
            logger.info("-------查询全部:" + state);
            infos = service.findByStatusAll(userId);
        }else{
            logger.info("-------查询部分:" + state);
            infos = service.findByStatus(info);
        }
        for (OrderInfo orderInfo : infos) {
            Order order = new Order();
            order.setOrderInfo(orderInfo);
            order.setOrderDetailList(detailService.findByOrderId(orderInfo.getOrderId()));
            orderList.add(order);
        }
        return orderList;
    }


    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    private String pay(String userId,Double money,String orderId,String addressId,String desc) {
        logger.info("-------请求数据:" + userId);
        logger.info("-------请求数据:" + money);
        logger.info("-------请求数据:" + orderId);
        logger.info("-------请求数据:" + desc);
        List<OrderDetail> detailList = detailService.findByOrderId(orderId);
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("money",money);
        map.put("orderId",orderId);
        map.put("state","B");
        map.put("addressId",addressId);
        map.put("description",desc);
        map.put("integral",money.intValue());
        userInfoService.pay(map);
        service.updateState(map);
        PayHistory pay = new PayHistory();
        pay.setUserId(userId);
        pay.setMoney(BigDecimal.valueOf(money));
        pay.setPayChannel("钱包");
        pay.setPayType("消费");
        pay.setOrderId(orderId);
        payHistoryService.insert(pay);
        for (OrderDetail detail:detailList) {
            cartInfoService.delByFoodId(detail.getFoodId());
            Map<String,Object> sell = new HashMap<>();
            sell.put("foodId",detail.getFoodId());
            sell.put("num",detail.getNum());
            foodInfoService.sell(sell);
        }
        return "succeed";
    }

    @RequestMapping(value = "/affirmReceive", method = RequestMethod.GET)
    private String affirmReceive(String orderId) {
        logger.info("-------确认收货:" + orderId);
        Map<String,Object> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("state","C");
        service.updateState(map);
        return "succeed";
    }

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
    private String cancelOrder(String orderId) {
        logger.info("-------确认收货:" + orderId);
        service.cancelOrder(orderId);
        detailService.cancelOrder(orderId);
        return "succeed";
    }
}
