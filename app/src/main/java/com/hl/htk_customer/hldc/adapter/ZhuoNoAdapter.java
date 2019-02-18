package com.hl.htk_customer.hldc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hl.htk_customer.R;
import com.hl.htk_customer.hldc.bean.SeatBean;

import java.util.List;

public class ZhuoNoAdapter extends BaseAdapter {
    private Context mContext;
    private List<SeatBean> mList;
    LayoutInflater layoutInflater;
    private int selectorPosition;

    public ZhuoNoAdapter(Context context, List<SeatBean> mList, Integer position) {
        this.mContext = context;
        this.mList = mList;
        this.layoutInflater = LayoutInflater.from(context);
        this.selectorPosition = position;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mList != null ? mList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return mList != null ? position : 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.zhuono_item_layout,null);
            viewHolder.zhuohaoRB = (RadioButton) view.findViewById(R.id.zhuohao_rb);
            viewHolder.zhuohaoTV = (TextView) view.findViewById(R.id.zhuohao_tv);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.zhuohaoTV.setText(mList.get(i).getSeatName());

        //如果当前的position等于传过来点击的position,就去改变单选的状态
        if (selectorPosition == i) {
            viewHolder.zhuohaoRB.setChecked(true);
        } else {
            //其他的恢复原来的状态
            viewHolder.zhuohaoRB.setChecked(false);
        }
        return view;
    }

    static class ViewHolder{
        RadioButton zhuohaoRB;
        TextView zhuohaoTV;
    }

    public void changeState(int pos) {
        selectorPosition = pos;
        notifyDataSetChanged();
    }
}
