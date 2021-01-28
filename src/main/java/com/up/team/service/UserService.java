package com.up.team.service;

import com.up.team.entity.User;
import com.up.team.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    public void save(CrmUser crmUser);
}
