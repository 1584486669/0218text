package com.example.text.controller;

import com.example.text.bean.UserInfo;
import com.example.text.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //查询所有啊啊啊啊啊啊啊啊啊
    @RequestMapping("getAll")
    public List<UserInfo> getAll(){
        List<UserInfo> userInfoListAll = userService.getUserInfoListAll();
        return userInfoListAll;
    }

    @RequestMapping("addOne")
    public String addOne(UserInfo userInfo){
        userInfo.setName("徐国东");
        userInfo.setLoginName("滋味不好受");
        userService.addUser(userInfo);
        return "Ok";
    }
    //修改
//    @RequestMapping("updOne")
//    public String updOne(UserInfo userInfo){
//        userInfo.setNickName("真的菜");
//
//        userService.updateUser(userInfo);
//        return "Ok";
//    }
    @RequestMapping("updOne")
    public String updOne(String name){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName("优秀的人啊");

        userService.updateUserByName(name,userInfo);
        return "Ok";
    }

    @RequestMapping("delUser")
    public String delUser(UserInfo userInfo){

        userInfo.setNickName("优秀的人啊");

        userService.delUser(userInfo);
        return "Ok";
    }

    @RequestMapping("getLikeAll")
    public List<UserInfo> getLikeAll(String name){
        System.out.println(name);
        List<UserInfo> likeUserInfoListAll = userService.getLikeUserInfoListAll(name);
        return likeUserInfoListAll;
    }

}
