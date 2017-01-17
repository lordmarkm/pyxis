package com.pyxis.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.model.security.UserAccount;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.security.dto.UserAccountInfo;

public interface UserAccountServiceCustom extends PyxisJpaServiceCustom<UserAccount, UserAccountInfo>, UserDetailsService {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        // TODO Auto-generated method stub
        return null;
    }

    Optional<UserAccountInfo> findByUsernameInfo(String username);

}
