package com.example.homeworke28;

import com.example.homeworke28.Model.MyUser;
import com.example.homeworke28.Model.Product;
import com.example.homeworke28.Repository.ProductRepository;
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
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    MyUser myUser;
    Product product1,product2,product3;


    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Maha" , "12345" , "admin" , null);
        product1 = new Product(null,"Black Coffee",20,null);
        product2 = new Product(null ,"latte Coffee",30,null);
        product3 = new Product(null ,"mocha Coffee",20,null);

    }

    @Test
    public void findProductById(){
        productRepository.save(product1);
        product2=productRepository.findProductById(product1.getId());
        Assertions.assertThat(product2).isEqualTo(product1);

    }

}
