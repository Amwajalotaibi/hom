package com.example.homeworke28;

import com.example.homeworke28.Model.MyUser;
import com.example.homeworke28.Model.Product;
import com.example.homeworke28.Repository.AuthRepository;
import com.example.homeworke28.Repository.ProductRepository;
import com.example.homeworke28.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    MyUser myUser;

    Product product1,product2,product3;

    List<Product> productList;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Maha" , "12345" , "ADMIN" , null);
        product1 = new Product(null,"cream",92,null );
        product2 = new Product(null,"QV",100,null );
        product1 = new Product(null,"cream",92,null );

        productList=new ArrayList<>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
    }

    @Test
    public void getAllProduct(){
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> products=productService.getAllProduct();
        Assertions.assertEquals(products,productList);
        Assertions.assertEquals(3,productList.size());
    }
@Test
    public void getProductById(){

        when(productRepository.findProductById(myUser.getId())).thenReturn(product1);

        Product products=productService.getProductById(myUser.getId());
        Assertions.assertEquals(products.getId(),myUser.getId());

        Mockito.verify(productRepository,times(1)).findProductById(myUser.getId());
    }

    @Test
    public void updateProduct(){
        when(productRepository.findProductById(myUser.getId())).thenReturn(product1);

       productService.updateProduct(myUser.getId(),product2, product2.getId());

        verify(productRepository,times(1)).findProductById(myUser.getId());
    }


    @Test
    public void deleteProduct(){
        when(productRepository.findProductById(myUser.getId())).thenReturn(product1);

        productService.deleteProduct(product1.getId(),myUser.getId());

        verify(productRepository,times(1)).findProductById(myUser.getId());
    }

}
