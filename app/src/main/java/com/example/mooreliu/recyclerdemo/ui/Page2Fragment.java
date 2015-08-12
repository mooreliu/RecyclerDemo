package com.example.mooreliu.recyclerdemo.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mooreliu.recyclerdemo.R;
import com.example.mooreliu.recyclerdemo.adapter.Page2RecyclerViewAdapter;
import com.example.mooreliu.recyclerdemo.model.Cll;
import com.example.mooreliu.recyclerdemo.model.Contants;
import com.example.mooreliu.recyclerdemo.widget.OnCllTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooreliu on 2015/8/12.
 */
public class Page2Fragment extends Fragment{

    private RecyclerView mRecyclerView;
    private List<Cll> mCllList;
    private Page2RecyclerViewAdapter mPage2RecyclerViewAdapter;
    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_page2, container, false);
        initData();
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.rv_cll_page2);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.VERTICAL
        );
        mRecyclerView.setLayoutManager(layoutManager);
        mPage2RecyclerViewAdapter = new Page2RecyclerViewAdapter(getActivity(),mCllList);
        mRecyclerView.setAdapter(mPage2RecyclerViewAdapter);

        mPage2RecyclerViewAdapter.setOnCllTouchListener(
                new OnCllTouchListener() {
                    @Override
                    public void onTouch(View v, Cll cll) {
                        Intent i = new Intent(getActivity(), ContextActivity.class);
                        i.putExtra(ContextActivity.IMAGE_URL, cll.getImgUrl());
                        i.putExtra(ContextActivity.IMAGE_TITLE, cll.getTitle());
                        i.putExtra(ContextActivity.IMAGE_DESCRIPTION, cll.getContent());
                        startActivity(i);

                    }
                }
        );

    }

    private void initData() {
        mCllList = new ArrayList<Cll>();
        for(int i = 0; i < Contants.imageIDs.length; i++) {
            mCllList.add(
                    new Cll(Contants.page2_imageTitle[i],
                            Contants.page2_imageIDs[i],
                            Contants.page2_imageDesciption[i])
            );
        }

    }


}
