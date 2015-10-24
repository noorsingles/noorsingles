/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdin.noorsingles.web;

import com.abdin.noorsingles.repository.ApplicationsRepository;
import com.abdin.noorsingles.service.AdminService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fabdin
 */
@Controller
@RequestMapping("adminapi")
public class AdminController {

    @Autowired
    AdminService adminService;

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String loginPage(HttpServletRequest request, HttpSession session) {
//
//        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
//
//        if (authenticated != null && authenticated.booleanValue()) {
//            return "admin";
//        }
//        return "login";
//    }
//    @RequestMapping(value = "/clear", method = RequestMethod.GET)
//    public String clear(HttpServletRequest request, HttpSession session) {
//
//        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
//
//        if (authenticated != null && authenticated.booleanValue()) {
//            ApplicationsRepository.clear();
//            return "admin";
//        }
//        return "login";
//    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity loginPage(HttpSession session) {

        adminService.logout(session);

        return new ResponseEntity(HttpStatus.OK);
    }
    
        @RequestMapping(value = "/isAuthenticated", method = RequestMethod.GET)
    public ResponseEntity isAuthenticated(HttpSession session) {

        if(adminService.isAuthenticated(session)){
            return new ResponseEntity(HttpStatus.OK);
        }else { 
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity login(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("paswd") String password) {

        HttpSession session = request.getSession(true);

        adminService.authenticate(username, password, session);

        if (adminService.isAuthenticated(session)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
