package com.qsoft.atdd.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.googlecode.androidannotations.annotations.*;
import com.qsoft.atdd.R;
import com.qsoft.atdd.common.utils.Const;
import com.qsoft.atdd.service.OrderServiceImpl;
import com.qsoft.atdd.ui.model.Order;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

/**
 * Created by thinhdd on 3/28/14.
 */
@EFragment(R.layout.dialog_add_order)
public class AddOrderFragment extends DialogFragment
{
    private boolean isDialogShownBool;
    private int numberDialogShowRequest;

    @ViewById(R.id.dialog_add_order_etNo)
    EditText edOrderCode;

    @ViewById(R.id.dialog_add_order_etAmount)
    EditText edAmount;

    @ViewById(R.id.dialog_add_order_etDescription)
    EditText edDescription;

    @ViewById(R.id.dialog_add_order_tvMessage)
    TextView tvMessage;

    @Bean
    OrderServiceImpl orderService;

    public Long userId = null;

    @AfterViews
    void init()
    {
        userId = getArguments().getLong(Const.USER_ID);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.R.style.Theme_Translucent_NoTitleBar));
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override
    public int show(FragmentTransaction transaction, String tag)
    {
        int result = -1;
        if (!isDialogShownBool)
        {
            result = super.show(transaction, tag);
            isDialogShownBool = true;
        }
        numberDialogShowRequest++;
        return result;
    }

    @Override
    public void show(FragmentManager manager, String tag)
    {
        if (!isDialogShownBool)
        {
            super.show(manager, tag);
            isDialogShownBool = true;
        }
        numberDialogShowRequest++;
    }

    @Override
    public void dismiss()
    {
        numberDialogShowRequest--;
        if (numberDialogShowRequest <= 0)
        {
            if (isDialogShownBool)
            {
                super.dismiss();
                isDialogShownBool = false;
            }
            numberDialogShowRequest = 0;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog)
    {
        super.onCancel(dialog);

        isDialogShownBool = false;
        numberDialogShowRequest = 0;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Click(R.id.dialog_add_order_btSave)
    void doSave()
    {
        Order order = new Order();
        boolean saved = false;
        if (!StringUtils.isEmpty(edOrderCode.getText()))
        {
            String orderCode = edOrderCode.getText().toString();
            order.setOrderCode(orderCode);
            try
            {
                Boolean isValid = orderService.validOrderCode(orderCode);
                if (!StringUtils.isEmpty(edAmount.getText()) && isValid)
                {
                    order.setAmount(edAmount.getText().toString());
                    order.setUserId(userId);
                    saved = true;
                }
                else
                {
                    if (!isValid)
                    {
                        tvMessage.setText(Const.ORDER_CODE_MESSAGE_ERROR);

                    }
                    else
                    {
                        tvMessage.setText(Const.ADD_ORDER_MESSAGE_ERROR);
                    }
                    saved = false;

                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            saved = false;
            tvMessage.setText(Const.ADD_ORDER_MESSAGE_ERROR);
        }
        if (!StringUtils.isEmpty(edDescription.getText()))
        {
            order.setDescription(edDescription.getText().toString());
        }
        if (saved)
        {
            try
            {
                orderService.create(order);
                this.dismiss();
                ((ShowListOrderActivity) getActivity()).notifyChange();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Click(R.id.dialog_add_order_btCancel)
    void doCancel()
    {
        this.dismiss();

    }

}
