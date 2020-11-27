package com.example.api.web;

import com.example.api.entity.MenuInfo;
import com.example.api.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/menu")  //指定根路由
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<MenuInfo> listArea() {
        List<MenuInfo> list = menuInfoService.queryMenuInfo();
        return list;
    }
}
