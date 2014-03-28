package com.qsoft.atdd.common.helper;

import android.content.Context;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;

/**
 * User: trungpt
 * Date: 3/20/14
 * Time: 11:30 AM
 */
@EBean(scope = Scope.Singleton)
public class HolderSingletonFactory
{
    public Context context;

    public HolderSingletonFactory(Context context)
    {
        this.context = context;
    }

    private GenericDatabaseHelper genericDatabaseHelper;

    public GenericDatabaseHelper getGenericDatabaseHelper()
    {
        return genericDatabaseHelper;
    }

    public void setGenericDatabaseHelper(GenericDatabaseHelper genericDatabaseHelper)
    {
        this.genericDatabaseHelper = genericDatabaseHelper;
    }
}
