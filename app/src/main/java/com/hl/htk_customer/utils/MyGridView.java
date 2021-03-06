package com.hl.htk_customer.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 作者 龙威陶
 * 说明
 * 创建时间 2016/10/8
 * 公司名称 百迅科技
 * 描述
 */
public class MyGridView extends GridView {
      public MyGridView(Context context) {
            super(context);
      }

      public MyGridView(Context context, AttributeSet attrs) {
            super(context, attrs);
      }

      public MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
      }


      @Override
      protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec = MeasureSpec.makeMeasureSpec(
                    Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
      }
}
