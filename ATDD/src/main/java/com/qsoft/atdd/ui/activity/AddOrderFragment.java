package com.qsoft.atdd.ui.activity;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EFragment;
import com.qsoft.atdd.R;

/**
 * Created by thinhdd on 3/28/14.
 */
@EFragment(R.layout.dialog_add_order)
public class AddOrderFragment extends DialogFragment
{
    private boolean isDialogShownBool;
    private int numberDialogShowRequest;

    @AfterViews
    void init()
    {
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
}