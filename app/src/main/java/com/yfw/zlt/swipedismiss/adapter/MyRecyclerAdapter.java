package com.yfw.zlt.swipedismiss.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yfw.zlt.swipedismiss.R;

import java.util.List;

/**
 * Created by zlt on 2016/5/12.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    public List<String> mDataset;
    public MyRecyclerAdapter(List<String> mDataset){
        this.mDataset=mDataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
           holder.mTV.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTV= (TextView) itemView;
        }
    }
}
