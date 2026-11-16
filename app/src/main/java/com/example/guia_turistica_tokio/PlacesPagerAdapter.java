package com.example.guia_turistica_tokio;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PlacesPagerAdapter extends FragmentStateAdapter {
    private final String[] categories = {"Monumentos", "Restaurantes", "Ocio"};
    public PlacesPagerAdapter(@NonNull FragmentActivity activity) { super(activity); }
    @NonNull @Override public Fragment createFragment(int position) {
        return PlacesFragment.newInstance(categories[position]);
    }
    @Override public int getItemCount() { return categories.length; }
}
