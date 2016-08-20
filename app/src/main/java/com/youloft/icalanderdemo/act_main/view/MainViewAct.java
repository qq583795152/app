package com.youloft.icalanderdemo.act_main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.youloft.icalanderdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zzz on 2016/8/18.
 */
public class MainViewAct extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.toolbar)Toolbar toolbar;
    @Bind(R.id.toolbar_title)TextView toolbar_title;
    @Bind(R.id.id_gallery)LinearLayout mGallery;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        init();
    }
    private void init() {
        initData();
        initView();
        initGalary();
    }

    private void initGalary() {
       int[] mImgIds;
        mImgIds = new int[] { R.drawable.a, R.drawable.b, R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g,
                 };
        for (int i = 0; i < mImgIds.length; i++)
        {

            View view = LayoutInflater.from(this).inflate(R.layout.testview,
                    mGallery, false);
            ImageView img = (ImageView) view
                    .findViewById(R.id.id_index_gallery_item_image);
            img.setImageResource(mImgIds[i]);
            TextView txt = (TextView) view
                    .findViewById(R.id.id_index_gallery_item_text);
            txt.setText("some info ");
            mGallery.addView(view);
        }
    }

    private void initView() {
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);//drawer动作加到Toolbar里面
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);//drawer后子选项点击事件
        toolbar_title.setOnClickListener(new MyClickListner());
    }

    private void initData() {

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toast.makeText(this,"haha",Toast.LENGTH_SHORT).show();
        switch (item.getItemId())
        {
            case R.id.events:

                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_add:
                Toast.makeText(this,"haha",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class  MyClickListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.toolbar_title:
                    break;
                default:
                    break;
            }
        }
    }
}

