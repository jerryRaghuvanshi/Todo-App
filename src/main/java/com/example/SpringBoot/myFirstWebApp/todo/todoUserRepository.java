package com.example.SpringBoot.myFirstWebApp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface todoUserRepository extends JpaRepository<todoUser,Integer> {
    List<todoUser> findByUserName(String userName);


}
