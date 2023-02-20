package com.example.polemistesfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }
    HomeFragment homefragment= new HomeFragment();
    WorkoutFragment workoutfragment = new WorkoutFragment();
    HistoryFragment historyfragment = new HistoryFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.container, homefragment)
                        .addToBackStack(null)

                         .commit();
                return true;

            case R.id.workout:
                //   getSupportFragmentManager().beginTransaction().replace(R.id.container, cuisinefragment).commit();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.container, workoutfragment)
                        .addToBackStack(null)
                        .commit();
                return true;

            case R.id.history:
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, attractionsfragment).commit();
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in,  // enter
                                R.anim.fade_out,  // exit
                                R.anim.fade_in,   // popEnter
                                R.anim.slide_out  // popExit
                        )
                        .replace(R.id.container, historyfragment)
                        .addToBackStack(null)
                        .commit();
                return true;


        }
        return false;
    }
}