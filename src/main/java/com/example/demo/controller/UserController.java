package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.repository.UserJpaRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags={"1.User"})   // UserController를 대표하는 최상단 타이틀 영역에 표시될 값을 세팅
@RequiredArgsConstructor    // class final로 선언된 객체에 대해서 Constructor Ingection 수행, 이걸 안쓰고 @Autowired 사용해도 됨
@RestController // 결과값을 Json으로 출력
@RequestMapping(value = "/v1")
public class UserController {
    private final UserJpaRepo userJpaRepo;

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/user")    // 모든 데이터 읽음
    public List<User> findAllUser(){
        return userJpaRepo.findAll();   // Jpa에서 제공하는 기본 CRUD (findAll = select *(msrl,name,uid) from user;)
    }

    // @ApiOperation(value="", notes="")
    // 각각의 리소스에 대한 제목과 설명
    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
    @PostMapping(value = "/user")
    // @ApiParam(value = "", required=true) @RequestParam ~~~
    // 파라미터에 대한 설명
    public User save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid, @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        User user = User.builder()
                .uid("yumi@naver.com")
                .name("유미")
                .build();
        return userJpaRepo.save(user); // Jpa에서 제공하는 기본 CRUD (findAll = insert into user (msrl,name,uid) values (null, ?, ?);)
    }
}
