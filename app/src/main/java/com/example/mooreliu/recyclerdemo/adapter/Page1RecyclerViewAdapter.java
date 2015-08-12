package com.example.mooreliu.recyclerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mooreliu.recyclerdemo.R;
import com.example.mooreliu.recyclerdemo.model.Cll;
import com.example.mooreliu.recyclerdemo.ui.RatioImageView;
import com.example.mooreliu.recyclerdemo.widget.OnCllTouchListener;

import java.util.List;

/**
 * Created by mooreliu on 2015/8/10.
 */
public class Page1RecyclerViewAdapter extends RecyclerView.Adapter<Page1RecyclerViewAdapter.ViewHolder>{
    List<Cll> mCllList;
    OnCllTouchListener mOnCllTouchListener;
    public Page1RecyclerViewAdapter(Context context, List<Cll> cllList) {
        mCllList = cllList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.page1_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        Cll cll = mCllList.get(position);
        viewHolder.cll = cll;
        viewHolder.titleView.setText(cll.getTitle());
        //viewHolder.meizhiView.setOriginalSize(meizhi.getThumbWidth(), meizhi.getThumbHeight());
        viewHolder.imageView.setImageResource (cll.getImgUrl());

    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder.imageView != null) holder.imageView.setImageBitmap(null);
    }

    public void setOnCllTouchListener(OnCllTouchListener OnCllTouchListener)
    {
        this.mOnCllTouchListener = OnCllTouchListener;
    }
    @Override
    public int getItemCount() {
        return mCllList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Cll cll;
        RatioImageView imageView;
        TextView titleView;

       // View card;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (RatioImageView) itemView.findViewById(R.id.rv_img);
            titleView = (TextView) itemView.findViewById(R.id.rv_title);
            imageView.setOnClickListener(this);
            titleView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mOnCllTouchListener.onTouch(v,cll);
        }
    }
}
