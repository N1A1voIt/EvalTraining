package com.example.javaspringjpa.user.model;

import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoggedUser saveUser(UserDTO userDTO) throws Exception {
        Users user = userRepository.findByMail(userDTO.getMail());
        if (user != null){
            throw new Exception("There is an user with this email");
        }
        Users toSave = new Users();
        toSave.setMail(userDTO.getMail());
        toSave.setUserName(userDTO.getName());
        toSave.setFirstName(userDTO.getFirstName());
        toSave.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        toSave = userRepository.save(toSave);
        return userRepository.getLoggedUser(toSave.getMail(), toSave.getPassword());
    }
    public LoggedUser userAuthentification(LogForm logForm){
        return userRepository.getLoggedUser(logForm.getMail(), passwordEncoder.encode(logForm.getPassword()));
    }
}
