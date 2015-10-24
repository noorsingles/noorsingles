/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdin.noorsingles.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabdin
 */
@Service
public class AdminService {

    public boolean isAuthorized(String username, String password) {

        if (username != null
                && (username.equals("salqennah") || username.equals("fadiabdeen"))) {

            if (password.equals("123456")) {
                return true;
            }
        }
        return false;
    }

    public void authenticate(String username, String password, HttpSession session) {

        if (isAuthorized(username, password)) {
            session.setAttribute("authenticated", true);
        } else {
            session.setAttribute("authenticated", false);
        }
    }

    public boolean isAuthenticated(HttpSession session) {
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        if (authenticated != null && authenticated.booleanValue()) {
            return true;
        }
        return false;
    }

    public void logout(HttpSession session) {
        session.setAttribute("authenticated", false);
    }

}
