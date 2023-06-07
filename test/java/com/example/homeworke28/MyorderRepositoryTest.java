package com.example.homeworke28;

import com.example.homeworke28.Model.MyUser;
import com.example.homeworke28.Model.Myorder;
import com.example.homeworke28.Model.Product;
import com.example.homeworke28.Repository.MyorderRepository;
import jakarta.persistence.Entity;
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
public class MyorderRepositoryTest {
    @Autowired
    MyorderRepository myorderRepository;

    MyUser user;
    Myorder myorder1,myorder2,myorder3;
    List<Myorder> myorderList;

    @BeforeEach
    void setUp() {
        user=new MyUser(null,"Amwaj","1234","customer",null);
        myorder1=new Myorder(null,2,150,"2023/3/1","new",null,null);
        myorder2=new Myorder(null,4,250,"2023/3/1","inprogress",null,null);
        myorder3=new Myorder(null,4,250,"2023/3/7","completed",null,null);

    }

    @Test
    public void findMyorderById(){
        myorderRepository.save(myorder1);
        myorder2=myorderRepository.findMyorderById(myorder1.getId());
        Assertions.assertThat(myorder2).isEqualTo(myorder1);
    }

    @Test
    public void findMyorderByMyUser(){
        myorderRepository.save(myorder1);
        myorderRepository.save(myorder2);
        myorderRepository.save(myorder3);
        myorderList=myorderRepository.findMyorderByMyUser(user);
        Assertions.assertThat(myorderList.get(0).getMyUser().getId()).isEqualTo(user.getId());
    }
}
