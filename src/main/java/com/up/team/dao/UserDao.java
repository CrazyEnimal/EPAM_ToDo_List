package com.up.team.dao;


import com.up.team.entity.User;

public interface UserDao {

    public User findByUserName(String userName);

    public void save(User user);

}
