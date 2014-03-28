package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qsoft.atdd.R;
import com.qsoft.atdd.ui.adapter.OrderAdapter;
import com.qsoft.atdd.ui.dto.OrderDTO;

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

    @AfterViews
    void init(){
        List<OrderDTO>  orderList=new ArrayList<OrderDTO>();
        orderList.add(new OrderDTO("0001",12000,""));
        orderList.add(new OrderDTO("0002",36000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0002",125000,""));
        orderList.add(new OrderDTO("0009",125000,""));

        lvListOrders.setAdapter(new OrderAdapter(this,-1,orderList));

    }
    @Click(R.id.list_goods_btAdd)
    void addOrder()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        addOrderFragment = new AddOrderFragment_();
        addOrderFragment.show(fragmentManager,"abc");
    }

    @Click(R.id.list_order_ivLogOut)
    void logout()
    {
        Intent intent = new Intent(this,MainActivity_.class);
        startActivity(intent);
    }

}
