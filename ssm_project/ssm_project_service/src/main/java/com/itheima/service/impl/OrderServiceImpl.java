package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrdersMapper;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(Integer pageNum,Integer pageSize,String searchName) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return ordersMapper.findAll(searchName);
    }
}
