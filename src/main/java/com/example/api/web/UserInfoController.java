package com.example.api.web;

import com.example.api.entity.UserInfo;
import com.example.api.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/user")  //指定根路由
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    private UserInfo listArea(Integer id) {
        // 获取区域列表
        return userInfoService.selectByPrimaryKey(id);
    }
}
