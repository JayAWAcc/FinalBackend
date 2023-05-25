package com.chefknifestogo.KnifeDB.security;

import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDao.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException(username + " does NOT exist!");

        return user;
    }
}