package com.qsoft.atdd.ui.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

public class ExpandedListView extends ListView
{

    private android.view.ViewGroup.LayoutParams params;
    private int old_count = 0;

    public ExpandedListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        if (getCount() != old_count)
        {
            old_count = getCount();
            params = getLayoutParams();
            params.height = getCount() * (old_count > 0 ? getChildAt(0).getHeight() : 0);
            setLayoutParams(params);
        }

        super.onDraw(canvas);
        if (_listener != null && (_width != this.getWidth() || _height != this.getHeight()))
        {
            _width = this.getWidth();
            _height = this.getHeight();
            _listener.onSizeChanged(this.getWidth(), this.getHeight());
        }
    }

    public static interface OnSizeChangedListener
    {
        void onSizeChanged(int width, int height);
    }

    private int _width = -1;
    private int _height = -1;
    private OnSizeChangedListener _listener = null;

    public void setOnSizeChangedListener(OnSizeChangedListener listener)
    {
        _listener = listener;
    }

}