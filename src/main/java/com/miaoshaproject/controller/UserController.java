package com.miaoshaproject.controller;

import com.miaoshaproject.controller.response.CommonReturnType;
import com.miaoshaproject.controller.viewVo.UserVo;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired 
    private UserService userservice;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUserInfoById(Integer id) {
        UserModel userModel = userservice.getUserInfoById(id);

        UserVo userVo = converFromObject(userModel);


        return CommonReturnType.create(userVo);
    }

    private UserVo converFromObject(UserModel userModel) {

        UserVo userVo = new UserVo();
        if (userModel == null) {
            return null;
        }

        BeanUtils.copyProperties(userModel, userVo);
        return userVo;
    }
}
