package com.qsoft.atdd.data.dao;

import android.content.ContentResolver;
import android.content.Context;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.qsoft.atdd.common.helper.HolderSingletonFactory;
import com.qsoft.atdd.ui.model.Order;
import com.qsoft.atdd.ui.model.OrderContract;

import java.sql.SQLException;
import java.util.List;

/**
 * User: thanhtd
 * Date: 3/12/14
 * Time: 11:21 AM
 */
@EBean
public class OrderDAO
{
    @RootContext
    Context context;
    ContentResolver contentResolver;

    @Bean
    HolderSingletonFactory singletonDatabaseHelp;

    public OrderDAO(Context context)
    {
        this.context = context;
        contentResolver = context.getContentResolver();
    }

    public List<Order> findAll() throws SQLException
    {
        Dao<Order, Long> orderDao = singletonDatabaseHelp.getGenericDatabaseHelper().getOrderDao();
        QueryBuilder<Order, Long> queryBuilder = orderDao.queryBuilder();
        PreparedQuery<Order> preparedQueryOrder = queryBuilder.prepare();
        return orderDao.query(preparedQueryOrder);
    }

    public void create(Order order) throws SQLException
    {
        Dao<Order, Long> orderDao = singletonDatabaseHelp.getGenericDatabaseHelper().getOrderDao();
        orderDao.createIfNotExists(order);
    }

    public void update(Order order) throws SQLException
    {
        Dao<Order, Long> orderDao = singletonDatabaseHelp.getGenericDatabaseHelper().getOrderDao();
        orderDao.update(order);
    }

    public Order findByUserId(Long userId) throws SQLException
    {
        Dao<Order, Long> orderDao = singletonDatabaseHelp.getGenericDatabaseHelper().getOrderDao();
        QueryBuilder<Order, Long> queryBuilder = orderDao.queryBuilder();
        queryBuilder.where()
                .eq(OrderContract.USERID, userId);
        queryBuilder.limit(1l);
        PreparedQuery<Order> preparedQueryOrder = queryBuilder.prepare();
        return orderDao.queryForFirst(preparedQueryOrder);
    }
}
