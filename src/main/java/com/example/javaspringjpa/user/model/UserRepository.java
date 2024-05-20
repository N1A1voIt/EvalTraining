package com.example.javaspringjpa.user.model;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByMail(String mail);
    @Query(value = "SELECT id,firstName,userName,mail FROM users WHERE mail = :mail AND password=:password",nativeQuery = true)
    LoggedUser getLoggedUser(@Param("mail") String mail,@Param("password") String password);
}
