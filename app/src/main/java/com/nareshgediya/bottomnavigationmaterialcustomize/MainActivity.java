package com.nareshgediya.bottomnavigationmaterialcustomize;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


displayFragment(new HomeFragment());


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        setBadges(R.id.menu_settings,7);
        setBadges(R.id.profile,18);
        setBadges(R.id.menu_users,109);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch(item.getItemId()){
                    case R.id.menu_home:
                        fragment = new HomeFragment();
                       item.setChecked(true);
                       clearNumber(item.getItemId());

                        break;
                    case R.id.menu_settings:
                        fragment = new SettingFragment();
                        item.setChecked(true);
                        clearNumber(item.getItemId());
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        item.setChecked(true);
                        clearNumber(item.getItemId());
                        break;
                    case R.id.menu_users:
                        fragment = new HeartFragment();
                        item.setChecked(true);
                        clearNumber(item.getItemId());
                        break;
                }

                if(fragment != null){
                    displayFragment(fragment);
                }

                return false;
            }
        });
    }

    private void setBadges(int id,int alerts){

    BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(id);
    badgeDrawable.setVisible(true);
    badgeDrawable.setNumber(alerts);
    }


    private void clearNumber(int id){
    BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(id);
    if (badgeDrawable!= null){
        badgeDrawable.setVisible(false);
        badgeDrawable.clearNumber();
    }

    }



    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framLayout, fragment)
                .commit();
    }
}