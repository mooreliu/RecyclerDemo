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
import com.example.mooreliu.recyclerdemo.adapter.Page1RecyclerViewAdapter;
import com.example.mooreliu.recyclerdemo.model.Cll;
import com.example.mooreliu.recyclerdemo.model.Contants;
import com.example.mooreliu.recyclerdemo.widget.OnCllTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mooreliu on 2015/8/12.
 */
public class Page1Fragment extends Fragment{

    private RecyclerView mRecyclerView;
    private List<Cll> mCllList;
    private Page1RecyclerViewAdapter mMooreRecyclerViewAdapter;
    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_page1, container, false);
        initData();
        initRecyclerView();
        return rootView;
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.rv_cll);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.VERTICAL
        );
        mRecyclerView.setLayoutManager(layoutManager);
        mMooreRecyclerViewAdapter = new Page1RecyclerViewAdapter(getActivity(),mCllList);
        mRecyclerView.setAdapter(mMooreRecyclerViewAdapter);

        mMooreRecyclerViewAdapter.setOnCllTouchListener(
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
            mCllList.add(new Cll(Contants.imageTitle[i],Contants.imageIDs[i],Contants.imageDesciption[i]));
        }

    }


}
