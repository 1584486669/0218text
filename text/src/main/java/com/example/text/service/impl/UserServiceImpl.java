package com.example.text.service.impl;

import com.example.text.bean.UserInfo;
import com.example.text.mapper.UserInfoMapper;
import com.example.text.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    //查询所有
    @Override
    public List<UserInfo> getUserInfoListAll() {

        return userInfoMapper.selectAll();
    }

    //添加
    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }
    //修改
    @Override
    public void updateUser(UserInfo userInfo) {


        userInfoMapper.updateByPrimaryKeySelective(userInfo);

    }
    //通过名字修改
    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }
    //删除
    @Override
    public void delUser(UserInfo userInfo) {
        //userInfoMapper.delete(userInfo);
        //userInfoMapper.deleteByPrimaryKey(userInfo.getId());
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.deleteByExample(example);
    }

    @Override
    public List<UserInfo> getLikeUserInfoListAll(String name) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().orLike("name",name);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);

        return userInfos;
    }

}
