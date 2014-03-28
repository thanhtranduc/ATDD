package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.*;
import com.qsoft.atdd.R;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.adapter.OrderAdapter;
import com.qsoft.atdd.ui.dto.OrderDTO;
import com.qsoft.atdd.ui.model.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinhdd on 3/28/14.
 */
@EActivity(R.layout.list_goods)
public class ShowListOrderActivity extends FragmentActivity
{

    AddOrderFragment addOrderFragment;

    @ViewById(R.id.list_goods_lvListOrder)
    ListView lvListOrders;

    @Bean
    AccountServiceImpl accountService;

    @Bean
    OrderServiceImpl orderService;

    @AfterViews
    void init()
    {
        Long userID = getIntent().getExtras().getLong("USER_ID");

        try
        {
            List<Order> orderList = orderService.findByUserId(userID);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
//        lvListOrders.setAdapter(new OrderAdapter(this, -1, orderList));

    }

    @Click(R.id.list_goods_btAdd)
    void addOrder()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        addOrderFragment = new AddOrderFragment_();
        addOrderFragment.show(fragmentManager, "abc");
    }

    @Click(R.id.list_order_ivLogOut)
    void logout()
    {
        Intent intent = new Intent(this, MainActivity_.class);
        startActivity(intent);
    }

}
