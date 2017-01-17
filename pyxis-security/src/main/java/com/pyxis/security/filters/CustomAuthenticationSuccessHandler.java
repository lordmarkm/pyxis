package com.pyxis.security.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyxis.core.dto.OperationResult;

/**
 *
 * @author Mark Baldwin B. Martinez on Jul 11, 2016
 *
 */
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication auth) throws IOException, ServletException {
        OperationResult<String> result = new OperationResult<String>()
                .withMessage("Authentication successful")
                .withStatus(OperationResult.STATUS_OK);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        objectMapper.writeValue(response.getWriter(), result);
    }

}
