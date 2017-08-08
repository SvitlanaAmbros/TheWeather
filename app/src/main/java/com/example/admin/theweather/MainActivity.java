package com.example.admin.theweather;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.theweather.adapters.MenuAdapter;
import com.example.admin.theweather.fragments.WeatherFragment;
import com.example.admin.theweather.fragments.WelcomeFragment;
import com.example.admin.theweather.listeners.OnItemChoosingListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemChoosingListener {
    private static final String TAG_WELCOME = "welcome";
    private static final String TAG_WEATHER = "weather";
    public static String CURRENT_TAG = TAG_WELCOME;

    private int numberLoadingFragment = 0;
    private Handler handler;

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.left_drawer)
    ListView leftDrawerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        createActionBar();
        setActionBarDrawerToggle();
        createNavigationDrawer();

        handler = new Handler();

        if(savedInstanceState == null) {
            numberLoadingFragment = 0;
            CURRENT_TAG = TAG_WELCOME;
            loadFragment();
        }
    }

    public void createActionBar(){
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setActionBarDrawerToggle(){
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mainToolbar,
                R.string.open_drawer, R.string.close_drawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void createNavigationDrawer(){
        MenuAdapter menuAdapter = new MenuAdapter(this, new ListCreator().createMenu(),this);

        leftDrawerMenu.setAdapter(menuAdapter);
        leftDrawerMenu.setOnItemClickListener(menuAdapter);
    }

    @Override
    public void onItemChoose(int position) {
        switch (position){
            case 0:
                numberLoadingFragment = 0;
                CURRENT_TAG = TAG_WELCOME;
                loadFragment();
                break;
            case 1:
                numberLoadingFragment = 1;
                CURRENT_TAG = TAG_WEATHER;
                loadFragment();
                break;
            case 2:
                break;
            default:
                break;
        }
    }

    public void loadFragment(){
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {

                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame_with_content, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mPendingRunnable != null) {
            handler.post(mPendingRunnable);
        }

        drawerLayout.closeDrawers();
    }

    private Fragment getHomeFragment() {
        switch (numberLoadingFragment) {
            case 0:
                WelcomeFragment homeFragment = new WelcomeFragment();
                return homeFragment;
            case 1:
                WeatherFragment weatherFragmentFragment = new WeatherFragment();
                return weatherFragmentFragment;
            default:
                return new WelcomeFragment();
        }
    }
}
