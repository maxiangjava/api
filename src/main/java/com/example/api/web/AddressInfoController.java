package com.example.api.web;


import com.example.api.entity.AddressInfo;
import com.example.api.service.AddressInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by matthew on 2020/10/23.
 */
@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressInfoController {
    private static final Log logger = LogFactory.getLog(SpringApplication.class);

    @Autowired
    private AddressInfoService addressInfoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<AddressInfo> list(String userId){
        logger.info("-------请求数据:" + userId);
        return addressInfoService.findListByUserId(userId);
    }

    @RequestMapping(value = "/findDefault", method = RequestMethod.GET)
    private AddressInfo findDefault(String userId){
        logger.info("-------请求数据:" + userId);
        return addressInfoService.findDefault(userId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    private String save(@RequestBody String data){
        logger.info("-------保存地址数据:" + data);
        AddressInfo addressInfo = new AddressInfo(data);
        //新增地址信息
        if(StringUtils.isEmpty(addressInfo.getAddressId())){
            logger.info("-------新增地址数据:" + data);
            addressInfoService.insertSelective(addressInfo);
        }else{//修改地址信息
            logger.info("-------修改地址数据:" + data);
            //如果修改的地址设为了默认，则先把所有地址默认改成false
            if(addressInfo.getDefaultStatus()){
                addressInfoService.setDefaultFalse(addressInfo.getUserId());
            }
            addressInfoService.updateByPrimaryKeySelective(addressInfo);
        }
        return "succeed";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    private String del(Integer addressId){
        logger.info("-------修改地址数据:" + addressId);
        addressInfoService.deleteByPrimaryKey(addressId);
        return "succeed";
    }

    @RequestMapping(value = "/setDefault", method = RequestMethod.POST)
    private String setDefault(AddressInfo addressInfo){
        logger.info("-------修改地址数据:" + addressInfo);
        return "succeed";
    }
}
