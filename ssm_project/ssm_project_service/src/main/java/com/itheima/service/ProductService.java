package com.itheima.service;


import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;

    void deleteAll(String[] ids)throws Exception;

    List<Product> searchMsg(String msg) throws Exception;

    void save(Product product);

}
