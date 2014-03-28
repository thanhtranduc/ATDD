package com.qsoft.atdd.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.qsoft.atdd.R;
import com.qsoft.atdd.ui.model.Order;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * User: khiemnt
 * Date: 3/28/14
 */
public class OrderAdapter extends ArrayAdapter<Order>
{
    private Context context;
    private List<Order> orderList;

    TextView tvOrderCode;
    TextView tvAmount;
    TextView tvDescription;

    public OrderAdapter(Context context, int textViewResourceId, List<Order> orderList)
    {
        super(context, textViewResourceId, orderList);
        this.orderList = orderList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if (v == null)
        {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_order_item, null);
        }
        Order order = orderList.get(position);
        setUpViewFindByID(v);

        if (order != null)
        {
            showView(order.getOrderCode(), tvOrderCode);
            String amount=order.getAmount()+"";
            showView(amount, tvAmount);
            showView(order.getDescription(), tvDescription);
        }
        return v;
    }

    private void showView(String value, TextView v)
    {
        if (StringUtils.isNotEmpty(value))
        {
            v.setVisibility(View.VISIBLE);
            v.setText(value);
        }
        else
        {
            v.setVisibility(View.GONE);
        }
    }

    private void setUpViewFindByID(View v)
    {
        tvOrderCode = (TextView) v.findViewById(R.id.list_item_tvOrderNumber);
        tvAmount = (TextView) v.findViewById(R.id.list_item_tvAmount);
        tvDescription = (TextView) v.findViewById(R.id.list_item_description);
    }

}
