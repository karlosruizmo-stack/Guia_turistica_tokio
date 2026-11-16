package com.example.guia_turistica_tokio;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new PlacesPagerAdapter(this));

        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            String[] titles = {"Monumentos", "Restaurantes", "Ocio"};
            tab.setText(titles[position]);
        }).attach();
    }
}
