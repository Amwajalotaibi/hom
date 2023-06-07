package com.example.homeworke28;

import com.example.homeworke28.Model.MyUser;
import com.example.homeworke28.Model.Myorder;
import com.example.homeworke28.Model.Product;
import com.example.homeworke28.Repository.AuthRepository;
import com.example.homeworke28.Repository.MyorderRepository;
import com.example.homeworke28.Repository.ProductRepository;
import com.example.homeworke28.Service.MyorderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyorderServiceTest {
    @InjectMocks
    MyorderService myorderService;

    @Mock
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

        myorderList=new ArrayList<>();

        myorderList.add(myorder1);
        myorderList.add(myorder2);
        myorderList.add(myorder3);
    }
    @Test
    public void getAllMyorder(){

        when(myorderRepository.findMyorderById(user.getId())).thenReturn(myorder1);

        Myorder myorder=myorderService.getMyorderById(user.getId());

        verify(myorderRepository,times(1)).findMyorderById(user.getId());
    }



    @Test
    public void updateMyorder(){
        when(myorderRepository.findMyorderById(user.getId())).thenReturn(myorder1);

        myorderService.updateMyorder(myorder1.getId(),myorder2);

        verify(myorderRepository,times(1)).findMyorderById(user.getId());
    }


    @Test
    public void deleteMyorder(){
        when(myorderRepository.findMyorderById(user.getId())).thenReturn(myorder1);

        myorderService.deleteMyorder(myorder1.getMyUser(),user.getId());

        verify(myorderRepository,times(1)).findMyorderById(user.getId());
    }


}
