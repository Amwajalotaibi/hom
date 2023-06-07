package com.example.homeworke28;

import com.example.homeworke28.Model.MyUser;
import com.example.homeworke28.Repository.AuthRepository;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthRepositoryTest {

    @Autowired
    AuthRepository authRepository;

    MyUser myUser;

    MyUser myUser1,myUser2,myUser3;

    List<MyUser> myUserList;


    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Maha" , "12345" , "ADMIN" , null);
        myUser1 = new MyUser(null,"sara","1234","customer",null);
        myUser2 = new MyUser(null,"Asma","1234","customer",null);
        myUser3 = new MyUser(null,"mona","1234","customer",null);

    }

    @Test
    public void findMyUserById(){
        authRepository.save(myUser1);
        myUser2=authRepository.findMyUserById(myUser1.getId());
        Assertions.assertThat(myUser2).isEqualTo(myUser1);
    }
//
    @Test
    public void findMyorderByMyUser(){
        authRepository.save(myUser1);
        authRepository.save(myUser2);
        authRepository.save(myUser3);
        myUserList=authRepository.findMyUserByUsername(myUser);
        Assertions.assertThat(myUserList.get(0).getUsername()).isEqualTo(myUser1);
    }




}
