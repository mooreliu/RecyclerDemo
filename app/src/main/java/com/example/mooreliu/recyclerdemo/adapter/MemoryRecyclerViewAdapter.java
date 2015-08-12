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
public class MemoryRecyclerViewAdapter extends RecyclerView.Adapter<MemoryRecyclerViewAdapter.ViewHolder>{
    List<Cll> mCllList;
    OnCllTouchListener mOnCllTouchListener;
    public MemoryRecyclerViewAdapter(Context context, List<Cll> cllList) {
        mCllList = cllList;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_memory_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        Cll cll = mCllList.get(position);
        viewHolder.cll = cll;
        viewHolder.bigimage.setImageResource (cll.getImgUrl());
        viewHolder.bigImageDec.setText(cll.getContent());
        viewHolder.bigTitle.setText(cll.getTitle());
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder.bigimage != null) holder.bigimage.setImageBitmap(null);
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
        RatioImageView bigimage;
        TextView bigTitle;
        TextView bigImageDec;


        public ViewHolder(View itemView) {
            super(itemView);
            bigimage = (RatioImageView) itemView.findViewById(R.id.big_img);
            bigTitle = (TextView) itemView.findViewById(R.id.bigimg_title);
            bigImageDec = (TextView) itemView.findViewById(R.id.bigimg_description);
            //bigimage.setOnClickListener(this);
            //bigImageDec.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            mOnCllTouchListener.onTouch(v,cll);
        }
    }
}
