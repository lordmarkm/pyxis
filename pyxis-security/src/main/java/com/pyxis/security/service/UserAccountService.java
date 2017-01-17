package com.pyxis.security.service;

import java.util.Optional;

import com.pyxis.commons.model.security.UserAccount;
import com.pyxis.commons.service.PyxisJpaService;

public interface UserAccountService extends PyxisJpaService<UserAccount>, UserAccountServiceCustom {

    Optional<UserAccount> findByUsername(String username);

}
