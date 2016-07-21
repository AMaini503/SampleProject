package com.aayush.aayush.sampleapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView drawerList;
    RelativeLayout drawerPane;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private int foregorund_frag = 0;
    ArrayList<NavItem> NavItems = new ArrayList<NavItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavItems.add(new NavItem("Set IP", "IP where DB is stored"));
        NavItems.add(new NavItem("GET", "GET Request Page"));
        NavItems.add(new NavItem("POST", "POST Request Page"));

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerPane = (RelativeLayout)findViewById(R.id.drawerPane);
        drawerList = (ListView)findViewById(R.id.navlist);
        DrawerListAdapter adapter = new DrawerListAdapter(this, NavItems);
        drawerList.setAdapter(adapter);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItemFromDrawer(position);
            }

        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }


        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    public void selectItemFromDrawer(int position) {
        NavItem item = NavItems.get(position);
        String title = item.title;


        FragmentManager fragmentManager = getSupportFragmentManager();

        if(title.equals("Set IP")) {
            Fragment fragment = new Fragment_IP();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
        }
        else if(title.equals("POST")) {
            Fragment fragment = new Fragment_POST();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
        }
        else if(title.equals("GET")) {
            Fragment fragment = new Fragment_GET();
            fragmentManager.beginTransaction().replace(R.id.main_container, fragment).commit();
        }

        setTitle(title);
        drawerList.setItemChecked(position, true);

        //close the drawer automatically
        drawerLayout.closeDrawer(drawerPane);
    }
}
