package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor    // class final로 선언된 객체에 대해서 Constructor Ingection 수행, 이걸 안쓰고 @Autowired 사용해도 됨
@RestController // 결과값을 Json으로 출력
@RequestMapping(value = "/v1")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    @GetMapping(value = "/user")    // 모든 데이터 읽음
    public List<User> findAllUser(){
        return userJpaRepo.findAll();   // Jpa에서 제공하는 기본 CRUD (findAll = select *(msrl,name,uid) from user;)
    }

    @PostMapping(value = "/user")
    public User save() {
        User user = User.builder()
                .uid("yumi@naver.com")
                .name("유미")
                .build();
        return userJpaRepo.save(user); // Jpa에서 제공하는 기본 CRUD (findAll = insert into user (msrl,name,uid) values (null, ?, ?);)
    }
}
