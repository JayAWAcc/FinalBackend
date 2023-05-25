package com.chefknifestogo.KnifeDB.service;

import com.chefknifestogo.KnifeDB.bean.Profile;
import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.bean.UserDetail;
import com.chefknifestogo.KnifeDB.dao.UserDao;
import com.chefknifestogo.KnifeDB.dao.UserDetailDao;
import com.chefknifestogo.KnifeDB.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailDao userDetailDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public Response register(User user) {
        System.out.println(userDao.findByUsername(user.getUsername())==null);
        if(userDao.findByUsername(user.getUsername())==null)
        {
            System.out.println("in");
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            List<Profile> profiles = new ArrayList<Profile>();

            profiles.add(new Profile(2));
            user.setProfiles(profiles);




            userDao.save(user);
            UserDetail userDetail=new UserDetail(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    user);
            userDetailDao.save(userDetail);
            userDetail.setUser(user);
            System.out.println(userDetail);
            return new Response(true);
        }
        else
        {
            return new Response(false);
        }

    }

    public String getUsernameById(int userId){
        return userDao.findById(userId).get().getUsername().toString();
    }

    public  boolean isUsernameAvailable(String username)
    {

        return userDao.findUserByUsername(username).size()==0;
    }
    public Response changePassword(User user, Authentication authentication) {
        if(user.getUsername().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
            User u = userDao.findByUsername(user.getUsername());
            u.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.save(u);
        }else {
            //TODO: Not authorize to update password if not current loggedin user or admin.
            return new Response(false);
        }
        return new Response(true);
    }

    public boolean isAdmin(Collection<? extends GrantedAuthority> profiles) {
        boolean isAdmin = false;
        for(GrantedAuthority profile: profiles) {
            if(profile.getAuthority().equals("ADMIN")) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }
    public boolean isUser(Collection<? extends GrantedAuthority> profiles) {
        boolean isUser = false;
        for(GrantedAuthority profile: profiles) {
            if(profile.getAuthority().equals("USER")) {
                isUser = true;
            }
        }
        return isUser;
    }

    public Response deleteUser(int id) {
        if(userDao.findById(id).get() != null) {
            userDao.deleteById(id);
            return new Response(true);
        }else {
            return new Response(false, "User is not found!");
        }
    }
}
