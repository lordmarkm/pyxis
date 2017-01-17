package com.pyxis.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pyxis.commons.model.security.UserAccount;
import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.security.dto.UserAccountInfo;

public class UserAccountServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<UserAccount, UserAccountInfo, UserAccountService>
    implements UserAccountServiceCustom {

    @Autowired
    private UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> user = userAccountService.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Could not find user with name '" + username + "'");
        }
        return user.get();
    }

    @Override
    public Optional<UserAccountInfo> findByUsernameInfo(String username) {
        return userAccountService.findByUsername(username)
            .map(userAccount -> mapper.map(userAccount, UserAccountInfo.class));
    }

}
