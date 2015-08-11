package com.example.mooreliu.recyclerdemo.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mooreliu.recyclerdemo.R;
import com.example.mooreliu.recyclerdemo.adapter.MemoryRecyclerViewAdapter;
import com.example.mooreliu.recyclerdemo.model.Cll;

import java.util.ArrayList;
import java.util.List;

public class ContextActivity extends ActionBarActivity {

    public static String IMAGE_URL ="image url";
    public static String IMAGE_TITLE ="image title";
    public static String IMAGE_DESCRIPTION ="image description";

    private RatioImageView mBigImg;
    private TextView mDescription;
    private Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<Cll> mCllList;
    MemoryRecyclerViewAdapter mMemoryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int intentImageUrl;
        String intentImageTitle;
        String intentImageDescription;
        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
                if(extras == null) {
                    intentImageUrl = R.mipmap.img1;
                    intentImageTitle = "image title null";
                    intentImageDescription = "image description";
                } else {
                    intentImageUrl = extras.getInt(IMAGE_URL);
                    intentImageTitle = extras.getString(IMAGE_TITLE);
                    intentImageDescription = extras.getString(IMAGE_DESCRIPTION);


                }
        } else {
            intentImageUrl = (int) savedInstanceState.getSerializable(IMAGE_URL);
            intentImageTitle = (String) savedInstanceState.getSerializable(IMAGE_DESCRIPTION);
            intentImageDescription = (String) savedInstanceState.getSerializable(IMAGE_DESCRIPTION);

        }
        setContentView(R.layout.layout_context);
        initView(intentImageUrl,intentImageTitle,intentImageDescription);

    }

    private void initView(int imgId , String imgTitle ,String ImgDescription) {
        //mBigImg = (RatioImageView) findViewById(R.id.big_img);
        //mDescription = (TextView) findViewById(R.id.bigimg_description);
        //mBigImg.setImageResource(img_id);
        initData(imgId ,imgTitle ,ImgDescription );
        initRecyclerView();
    }

    private void initData(int imgId , String imgTitle ,String ImgDescription) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("^_^");
        setSupportActionBar(mToolbar);
        mCllList = new ArrayList<Cll>();
        mCllList.add(new Cll(imgTitle,imgId,ImgDescription));
    }
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_memory);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.VERTICAL
        );
        mRecyclerView.setLayoutManager(layoutManager);
        mMemoryRecyclerViewAdapter = new MemoryRecyclerViewAdapter(this,mCllList);
        mRecyclerView.setAdapter(mMemoryRecyclerViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_context, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
