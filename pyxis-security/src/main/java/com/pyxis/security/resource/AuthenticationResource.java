package com.pyxis.security.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.util.AuthenticationUtil;
import com.pyxis.security.dto.UserAccountInfo;
import com.pyxis.security.service.UserAccountService;

/**
 *
 * @author Mark Baldwin B. Martinez on Jul 21, 2016
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationResource {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(method = GET)
    public ResponseEntity<UserAccountInfo> currentlyLoggedInUser() {
        Optional<UserAccountInfo> userAccount = userAccountService.findByUsernameInfo(AuthenticationUtil.getLoggedInUsername());
        return new ResponseEntity<>(userAccount.isPresent() ? userAccount.get() : null, OK);
    }

}
