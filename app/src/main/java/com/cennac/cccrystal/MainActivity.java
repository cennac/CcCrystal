package com.cennac.cccrystal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private String[] mTitles = new String[]
            { "First Fragment !", "Second Fragment !", "Third Fragment !",
                    "Fourth Fragment !" };
    private FragmentPagerAdapter mAdapter;

    private List<IconText> mTabIndicators = new ArrayList<IconText>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        mViewPager.setAdapter(mAdapter);
    }

    private void initDatas() {
//        for (String title : mTitles)
        for (int i=0;i<mTitles.length-1;i++)
        {	String title = mTitles[i];
            BlankFragment tabFragment =BlankFragment.newInstance(title,title);
            mTabs.add(tabFragment);
        }
        UserFragment userFragment=UserFragment.newInstance("","");
        mTabs.add(userFragment);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {

            @Override
            public int getCount()
            {
                return mTabs.size();
            }

            @Override
            public Fragment getItem(int position)
            {
                return mTabs.get(position);
            }
        };
    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.id_viewpager);

        IconText one= (IconText) findViewById(R.id.id_cciwt_one);
        mTabIndicators.add(one);
        IconText two= (IconText) findViewById(R.id.id_cciwt_two);
        mTabIndicators.add(two);
        IconText three= (IconText) findViewById(R.id.id_cciwt_three);
        mTabIndicators.add(three);
        IconText four= (IconText) findViewById(R.id.id_cciwt_four);
        mTabIndicators.add(four);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        one.setIconAlpha(1.0f);

    }


    @Override
    //当创建选项菜单时触发
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View view) {
        clickTab(view);
    }

    /**
     * 点击Tab按钮
     *
     * @param v
     */
    private void clickTab(View v)
    {
        resetOtherTabs();

        switch (v.getId())
        {
            case R.id.id_cciwt_one:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_cciwt_two:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_cciwt_three:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.id_cciwt_four:
                mTabIndicators.get(3).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                break;
        }
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs()
    {
        for (int i = 0; i < mTabIndicators.size(); i++)
        {
            mTabIndicators.get(i).setIconAlpha(0);
        }
    }

}
