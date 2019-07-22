package com.example.text.service;


import com.example.text.bean.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserInfo> getUserInfoListAll();

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserByName(String name,UserInfo userInfo);

    void delUser(UserInfo userInfo);

    List<UserInfo> getLikeUserInfoListAll(String name);

}
