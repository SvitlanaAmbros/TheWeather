package com.example.admin.theweather;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.theweather.adapters.MenuAdapter;

import com.example.admin.theweather.listeners.OnItemChoosingListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnItemChoosingListener {
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

    }

    public void createActionBar(){
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    public void createNavigationDrawer(){
        MenuAdapter menuAdapter = new MenuAdapter(this, new MenuCreator().createMenu(),this);

        leftDrawerMenu.setAdapter(menuAdapter);
        leftDrawerMenu.setOnItemClickListener(menuAdapter);
    }


    @Override
    public void onItemChoose(int position) {
        Toast.makeText(this, "position " + position, Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
    }
}
