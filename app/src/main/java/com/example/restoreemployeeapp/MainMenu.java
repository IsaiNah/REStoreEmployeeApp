package com.example.restoreemployeeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;

import java.util.List;

public class MainMenu extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "SEA_Log";
    private Button btnCallManager;
    private Intent callIntent;
    private Toolbar toolbar;
    //Menu Items
    private List<MenuItem> menuItems;
    //RecyclerView
    private RecyclerView recyclerView;
    //Navigation Drawer
    private DrawerLayout drawer;


    //Triggers for Dialog
    private Boolean showInformation = false;

//TODO remove unnecessary code after transfer

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //toolbar = (Toolbar)  findViewById(R.id.app_toolbar);
        toolbar = (Toolbar)  findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.mainmenu);
        // For handling click events in navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // For opening and closing
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


       // btnCallManager = (Button) findViewById(R.id.btn_menu_callmanager);

        //Setting Main View
      /*  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentMainMenu()).commit();*/
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new FragmentMainView()).commit();

    /*    FragmentWelcomeText fragmentWelcomeText = new FragmentWelcomeText();
        fragmentWelcomeText.show(getSupportFragmentManager(), "Information");

        FragmentWelcomeVideo fragmentWelcome = new FragmentWelcomeVideo();
        fragmentWelcome.show(getSupportFragmentManager(), "Welcome");*/




try {
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Welcome ");//TODO User Name Here
    toolbar.setTitleTextColor(Color.parseColor("#FFFAFA"));
    toolbar.setBackgroundColor(Color.parseColor("#000000"));
}catch(Exception e)
{
    Log.d(TAG, "onCreate: Exception " + e);
}
        //Create RecyclerView
        try {
       /*     recyclerView = findViewById(R.id.mainmenu_recyclerview);
            recyclerView.setHasFixedSize(true);
            //TODO uncomment below later
            recyclerView.setItemViewCacheSize(10);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //Changed to Grid Layout
            //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            SnapHelperOneByOne snapHelperOneByOne = new SnapHelperOneByOne();
            snapHelperOneByOne.attachToRecyclerView(recyclerView);
*/
        }catch (Exception e){
            Log.d(TAG, "onCreate: RecyclerView Exception " + e);
        }

      /*  // Init menu items list
        menuItems = new ArrayList<>();

        menuItems.add(new MenuItem(
                0,
                "Information",
                R.drawable.info01

        ));

        menuItems.add(new MenuItem(
                1,
                "Training",
                R.drawable.training00

        ));

        menuItems.add(new MenuItem(
                2,
                "Co-Worker's",
                R.drawable.coworkers00

        ));

        menuItems.add(new MenuItem(
                3,
                "Schedule",
                R.drawable.schedule00

        ));

        *//*menuItems.add(new MenuItem(
                4,
                "RE Services",
                R.drawable.allservices00

        ));*//*

        menuItems.add(new MenuItem(
                5,
                "VOIP",
                R.drawable.call00

        ));

        menuItems.add(new MenuItem(
                6,
                "Stats",
                R.drawable.level01

        ));



        try {
            //Recycler view Adapt call
            RecyclerViewAdapterMainMenu adapter = new RecyclerViewAdapterMainMenu(this, menuItems);

            //  adapter.setHasStableIds(true);
            //Setting adapter to RecyclerView
            recyclerView.setAdapter(adapter);
        }catch (Exception e) {
            Log.d(TAG, "onCreate 02: " + e);
        }

        btnCallManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    callIntent = new Intent (Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:123456789"));
                    startActivity(callIntent);
                }catch (Exception e)
                {
                    Log.d(TAG, "onClick: Exception " + e);
                }
            }
        });*/

    }

    // Implementing NavigationView listener
    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_mainmenu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentMainView()).commit();
                break;
            case R.id.nav_contactmanager:
                    FragmentCoworkers manager = new FragmentCoworkers(); // TODO Reuse class but check that manager
                    manager.show(getSupportFragmentManager(), "Text");
                    break;
            case R.id.nav_contactco:
                FragmentCoworkers coworkers = new FragmentCoworkers();
                coworkers.show(getSupportFragmentManager(), "Text");
                break;
            case R.id.nav_useraccount:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentAccount()).commit();
            break;
            case R.id.nav_userlogout:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentTestNav()).commit();
                        break;
            case R.id.nav_navhome:
                //Setting bundle to pass data
                Bundle bundle = new Bundle();
                bundle.putString("Address","96 Santa Amato Cres"); //TODO replace  value with variable | KEY , VALUE
              FragmentMainView fragmentMainView = new FragmentMainView();
              fragmentMainView.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragmentMainView).commit();
                break;
            case R.id.nav_navstore:
                //Setting bundle to pass data
                Bundle storebundle = new Bundle();
                storebundle.putString("Address","200 connie crescent"); //TODO replace  value with variable | KEY , VALUE
                FragmentMainView fragmentMainViewStore = new FragmentMainView();
                fragmentMainViewStore.setArguments(storebundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragmentMainViewStore).commit();
                break;
            case R.id.nav_navmore:
                FragmentTestNav fragmentTestNav = new FragmentTestNav();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        fragmentTestNav).commit();
                break;
                case R.id.nav_training:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FragmentInformationItem()).commit();
                    break;
          /*  case R.id.nav_usersettings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentOptions()).commit();
                break;*/
                //TODO add more
        }
    drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // Overriding backbutton press to not leave activity but close drawer if open
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed(); // If drawer is not open, will close the activity
        }
    }

    //TODO work or remove
    public void TransFragmentInformationItem(){
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            FragmentInformation fragmentInformation = new FragmentInformation();
            transaction.replace(R.id.mainmenu, fragmentInformation);
            transaction.addToBackStack(null);
            transaction.commit();

// Commit the transaction
            transaction.commit();
        }
        catch(Exception e)
        {
            Log.d(TAG, "replaceToFragmentInformationItem: Exception " + e);
        }

        Log.d(TAG, "!!!! WORKING !!!! " );

    }


}




