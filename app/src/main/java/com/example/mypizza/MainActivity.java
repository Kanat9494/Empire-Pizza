package com.example.mypizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mypizza.Fragments.AboutFragment;
import com.example.mypizza.Fragments.CallbackFragment;
import com.example.mypizza.Fragments.ContactsFragment;
import com.example.mypizza.Fragments.CouponFragment;
import com.example.mypizza.Fragments.GuestCardFragment;
import com.example.mypizza.Fragments.HomeFragment;
import com.example.mypizza.adapter.MainRecyclerAdapter;
import com.example.mypizza.model.AllCategory;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    View headerView;
    ImageView goToProfileImageView;
    RelativeLayout relative_layout_orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open,
                R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        headerView = navigationView.getHeaderView(0);
        goToProfileImageView = headerView.findViewById(R.id.go_to_profile_image_view);

        goToProfileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        relative_layout_orders = headerView.findViewById(R.id.relative_layout_orders);

        relative_layout_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setFragments(new HomeFragment());
        navigationView.setCheckedItem(R.id.action_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_home) {
            setFragments(new HomeFragment());
            toolbar.setTitle("Главная");
        } else if(id == R.id.action_guest_card) {
            setFragments(new GuestCardFragment());
            toolbar.setTitle("Карта постоянного гостя");
        } else if(id == R.id.action_coupon) {
            setFragments(new CouponFragment());
            toolbar.setTitle("Купоны");
        } else if(id == R.id.action_contacts) {
            setFragments(new ContactsFragment());
            toolbar.setTitle("Контакты");
        } else if(id == R.id.action_about) {
            setFragments(new AboutFragment());
            toolbar.setTitle("О приложении");
        } else if(id == R.id.action_callback) {
            setFragments(new CallbackFragment());
            toolbar.setTitle("Обратная связь");
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setFragments(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings) {
            showSettings();
        }

        return super.onOptionsItemSelected(item);
    }

    public void showSettings() {
        Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intentSettings);
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList) {
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}