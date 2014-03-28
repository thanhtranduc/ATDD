package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import android.widget.TextView;
import com.googlecode.androidannotations.annotations.*;
import com.qsoft.atdd.R;
import com.qsoft.atdd.common.utils.Const;
import com.qsoft.atdd.service.AccountServiceImpl;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.adapter.OrderAdapter;
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

    @ViewById(R.id.list_goods_tvTotalOrder)
    TextView tvTotalOrder;

    @ViewById(R.id.list_goods_tvDisplayName)
    TextView tvDisplayName;

    @ViewById(R.id.list_order_tvTotalPrice)
    TextView tvTotalPrice;

    @Bean
    AccountServiceImpl accountService;

    @Bean
    OrderServiceImpl orderService;

    public Long userId = null;

    @AfterViews
    void init()
    {
        userId = getIntent().getExtras().getLong(Const.USER_ID);
        String displayName = getIntent().getExtras().getString(Const.DISPLAY_NAME);
        tvDisplayName.setText("Hello " + displayName);
        showOrderList();


    }

    private void showOrderList()
    {
        try
        {
            List<Order> orderList = orderService.findByUserId(userId);
            Double totalPrice = 0d;
            if (orderList != null)
            {
                tvTotalOrder.setText("You have " + orderList.size() + " orders");

                for (Order order : orderList)
                {
                    String amount = order.getAmount().replace(",", "").trim();
                    totalPrice += Double.parseDouble(amount);
                }
            }
            tvTotalPrice.setText(totalPrice + "");
            lvListOrders.setAdapter(new OrderAdapter(this, -1, orderList));
            lvListOrders.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Click(R.id.list_goods_btAdd)
    void addOrder()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        addOrderFragment = new AddOrderFragment_();
        Bundle bundle = new Bundle();
        bundle.putLong(Const.USER_ID, userId);
        addOrderFragment.setArguments(bundle);
        addOrderFragment.show(fragmentManager, "abc");
    }

    @Click(R.id.list_order_ivLogOut)
    void logout()
    {
        Intent intent = new Intent(this, MainActivity_.class);
        startActivity(intent);
    }

    public void notifyChange()
    {
        showOrderList();
    }
}
