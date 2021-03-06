package com.example.api.web;

import com.example.api.entity.PayHistory;
import com.example.api.service.PayHistoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/payHistory")  //指定根路由
public class PayHistoryController {

    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private PayHistoryService service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<PayHistory> list(String userId) {
        logger.info("/payHistory/list:" + userId);
        return service.findList(userId);
    }
}
