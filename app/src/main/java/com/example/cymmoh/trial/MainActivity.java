package com.example.cymmoh.trial;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends ActionBarActivity {
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"Lectures", "Assignments", "Evaluations"};
    int NumbOfTabs = 3;
    CircleImageView circleView;
    private ListView mDrawerList;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;



    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see


    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view


    String EMAIL = "simonwambua433@gmail.com";
    int PROFILE = R.drawable.narse;

    private Toolbar toolbar;                              // Declaring the Toolbar Object


    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);








    adapter=new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumbOfTabs

    );

    // Assigning ViewPager View and setting the adapter
    pager=(ViewPager)

    findViewById(R.id.pager);

    pager.setAdapter(adapter);

    // Assiging the Sliding Tab Layout View
    tabs=(SlidingTabLayout)

    findViewById(R.id.tabs);

    tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

    // Setting Custom Color for the Scroll bar indicator of the Tab View
    tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()

    {
        @Override
        public int getIndicatorColor ( int position){
        return getResources().getColor(R.color.tabsScrollColor);
    }
    }

    );

    // Setting the ViewPager For the SlidingTabsLayout
    tabs.setViewPager(pager);


}



    public void circle(View v){

         circleView=(CircleImageView)findViewById(R.id.circleView);
        Intent intent=new Intent(MainActivity.this,profile.class);
        startActivity(intent);
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
