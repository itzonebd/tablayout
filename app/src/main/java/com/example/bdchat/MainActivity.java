package com.example.bdchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.view_page);

      serUpViewPager(viewPager);
      tabLayout.setupWithViewPager(viewPager);

    }

    private void serUpViewPager(ViewPager viewPager) {

        ViewPagerAdpter  viewPageAdpter = new ViewPagerAdpter(getSupportFragmentManager());
        viewPageAdpter.addFragement(new MessageFragment(),"Message");
        viewPageAdpter.addFragement(new MessageFragment(),"Story");
        viewPager.setAdapter(viewPageAdpter);
    }
    class ViewPagerAdpter extends FragmentPagerAdapter{
        final List<Fragment> fragmentlist = new ArrayList<>();
        final List<String> mfragemtntlististTitle = new ArrayList<>();

        public ViewPagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentlist.get(position);
        }

        @Override
        public int getCount() {
            return mfragemtntlististTitle.size();
        }

        public void addFragement(Fragment fragment, String title){

            fragmentlist.add(fragment);
            mfragemtntlististTitle.add(title);

        }

        @Override
        public String getPageTitle(int position){
            return mfragemtntlististTitle.get(position);


        }
    }
}