package com.example.javaspringjpa.user.controller;

import com.example.javaspringjpa.user.model.LogForm;
import com.example.javaspringjpa.user.model.LoggedUser;
import com.example.javaspringjpa.user.model.UserDTO;
import com.example.javaspringjpa.user.model.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPI {
    @Autowired
    private UserService userService;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@ModelAttribute UserDTO registerForm, HttpServletRequest req){
        try{
            req.getSession().setAttribute("user",userService.saveUser(registerForm));
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e){
            req.getSession().invalidate();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@ModelAttribute LogForm logForm,HttpServletRequest req){
        try{
            LoggedUser loggedUser = userService.userAuthentification(logForm);
            req.getSession().setAttribute("user",loggedUser);
            return new ResponseEntity<LoggedUser>(loggedUser,HttpStatus.OK);
        }catch (Exception e){
            req.getSession().invalidate();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
