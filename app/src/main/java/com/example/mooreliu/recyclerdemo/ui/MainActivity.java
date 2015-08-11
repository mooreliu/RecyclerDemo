package com.example.mooreliu.recyclerdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mooreliu.recyclerdemo.R;
import com.example.mooreliu.recyclerdemo.adapter.MooreRecyclerViewAdapter;
import com.example.mooreliu.recyclerdemo.model.Cll;
import com.example.mooreliu.recyclerdemo.model.Contants;
import com.example.mooreliu.recyclerdemo.widget.OnCllTouchListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView mRecyclerView;
    private List<Cll> mCllList;
    private MooreRecyclerViewAdapter mMooreRecyclerViewAdapter;
    private Toolbar mToolbar;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerlayout;
    private ListView mDrawerList;


    //private static int imgNumber = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("^_^");
        setSupportActionBar(mToolbar);


        /* 菜单的监听可以在toolbar里设置，也可以像ActionBar那样，通过下面的两个回调方法来处理 */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		/* findView */
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));

       // mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    private void initData() {
        mCllList = new ArrayList<Cll>();
        for(int i = 0; i < Contants.imageIDs.length; i++) {
            mCllList.add(new Cll(Contants.imageTitle[i],Contants.imageIDs[i],Contants.imageDesciption[i]));
        }

    }
    private void initRecyclerView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.rv_cll);
        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                2,StaggeredGridLayoutManager.VERTICAL
        );
        mRecyclerView.setLayoutManager(layoutManager);
        mMooreRecyclerViewAdapter = new MooreRecyclerViewAdapter(this,mCllList);
        mRecyclerView.setAdapter(mMooreRecyclerViewAdapter);

        mMooreRecyclerViewAdapter.setOnCllTouchListener(
                new OnCllTouchListener() {
                    @Override
                    public void onTouch(View v ,Cll cll) {
                        Intent i =new Intent(MainActivity.this,ContextActivity.class);
                        i.putExtra(ContextActivity.IMAGE_URL,cll.getImgUrl() );
                        i.putExtra(ContextActivity.IMAGE_URL,cll.getImgUrl() );
                        i.putExtra(ContextActivity.IMAGE_URL,cll.getImgUrl() );

                        startActivity(i);

                    }
                }
        );

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
