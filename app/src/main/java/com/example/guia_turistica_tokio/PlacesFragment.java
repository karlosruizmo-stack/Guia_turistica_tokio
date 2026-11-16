package com.example.guia_turistica_tokio;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.List;

public class PlacesFragment extends Fragment {
    private static final String ARG_CATEGORY = "category";

    public static PlacesFragment newInstance(String category) {
        PlacesFragment fragment = new PlacesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_places, container, false);
        LinearLayout list = root.findViewById(R.id.placeContainer);
        String category = getArguments() == null ? "Monumentos" :
                getArguments().getString(ARG_CATEGORY, "Monumentos");

        TextView intro = new TextView(requireContext());
        intro.setText("Descubre Tokio a tu ritmo");
        intro.setTextSize(21);
        intro.setTypeface(null, Typeface.BOLD);
        intro.setTextColor(getResources().getColor(R.color.text_primary));
        intro.setPadding(2, 4, 2, 18);
        list.addView(intro);

        List<Place> places = PlaceData.all();
        for (Place place : places) {
            if (!place.category.equals(category)) continue;
            TextView card = new TextView(requireContext());
            card.setText(place.emoji + "   " + place.name + "\n" + place.description);
            card.setTextSize(15);
            card.setTextColor(getResources().getColor(R.color.text_primary));
            card.setLineSpacing(5, 1f);
            card.setPadding(18, 18, 18, 18);
            card.setBackgroundResource(R.drawable.card_background);
            card.setElevation(3f);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 14);
            list.addView(card, params);
            card.setOnClickListener(v -> {
                Intent intent = new Intent(requireContext(), DetailActivity.class);
                intent.putExtra("name", place.name);
                intent.putExtra("category", place.category);
                intent.putExtra("emoji", place.emoji);
                intent.putExtra("description", place.description);
                intent.putExtra("address", place.address);
                intent.putExtra("phone", place.phone);
                intent.putExtra("website", place.website);
                startActivity(intent);
            });
        }
        return root;
    }
}
