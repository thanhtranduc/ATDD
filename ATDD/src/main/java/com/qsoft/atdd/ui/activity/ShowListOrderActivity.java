package com.qsoft.atdd.ui.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.qsoft.atdd.R;

/**
 * Created by thinhdd on 3/28/14.
 */
@EActivity(R.layout.list_goods)
public class ShowListOrderActivity extends FragmentActivity
{
    @ViewById(R.id.list_goods_lvListOrder)
    ListView listOrder;


    @Click(R.id.list_goods_btAdd)
    void addOrder()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AddOrderFragment addOrderFragment = new AddOrderFragment_();
        addOrderFragment.show(fragmentManager,"abc");
    }



    @Click(R.id.list_order_ivLogOut)
    void logout()
    {
        Intent intent = new Intent(this,MainActivity_.class);
        startActivity(intent);
    }


}
