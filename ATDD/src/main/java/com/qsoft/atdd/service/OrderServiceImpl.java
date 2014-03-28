package com.qsoft.atdd.service;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.qsoft.atdd.data.dao.OrderDAO;
import com.qsoft.atdd.ui.model.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * User: thanhtd
 * Date: 3/12/14
 * Time: 11:20 AM
 */
@EBean
public class OrderServiceImpl
{
    @Bean
    OrderDAO orderDAO;

    public List<Order> getAllOrder() throws SQLException
    {
        return orderDAO.findAll();
    }

    public void create(Order order) throws SQLException
    {
        orderDAO.create(order);
    }

    public void update(Order order) throws SQLException
    {
        orderDAO.update(order);
    }

    public List<Order> getOrdersByUserId(Long userId) throws SQLException
    {
        return orderDAO.findByUserId(userId);
    }
    public boolean validOrderCode(String orderCode) throws SQLException{
         return orderDAO.validOrderCode(orderCode);
    }
}
