package com.example.job;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.job.adapter.MyVp;
import com.example.job.fragment.ClassifyFragment;
import com.example.job.fragment.MyFragment;
import com.example.job.fragment.ShoppingFragment;
import com.example.job.fragment.ShouFragment;
import com.example.job.fragment.SpecialFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//git init;
//git add .
//git commit -m "提交信息"
//git remote add origin https://github.com/ZhanLongChenPeng/ceshi.git
//git push -u origin master
//123123
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.te)
    TextView mTe;
    @BindView(R.id.tool)
    Toolbar mTool;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private ArrayList <Fragment> list;
    private MyVp myVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

   private void initData() {

           list = new ArrayList <Fragment>();
           list.add(new ShouFragment());
           list.add(new SpecialFragment());
           list.add(new ClassifyFragment());
           list.add(new ShoppingFragment());
           list.add(new MyFragment());

           myVp = new MyVp(getSupportFragmentManager(), list);
           mVp.setAdapter(myVp);
           mTab.setupWithViewPager(mVp);

           mTab.getTabAt(0).setIcon(R.drawable.select1).setText("首页");
           mTab.getTabAt(1).setIcon(R.drawable.select2).setText("专题");
           mTab.getTabAt(2).setIcon(R.drawable.select3).setText("分类");
           mTab.getTabAt(3).setIcon(R.drawable.select4).setText("购物车");
           mTab.getTabAt(4).setIcon(R.drawable.select5).setText("我的");
     }
}
