package com.example.guia_turistica_tokio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private String name, category, emoji, description, address, phone, website;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent data = getIntent();
        name = data.getStringExtra("name");
        category = data.getStringExtra("category");
        emoji = data.getStringExtra("emoji");
        description = data.getStringExtra("description");
        address = data.getStringExtra("address");
        phone = data.getStringExtra("phone");
        website = data.getStringExtra("website");

        ((TextView)findViewById(R.id.detailEmoji)).setText(emoji == null ? "🌸" : emoji);
        ((TextView)findViewById(R.id.detailCategory)).setText(category == null ? "" : category.toUpperCase());
        ((TextView)findViewById(R.id.detailName)).setText(name == null ? "Lugar de Tokio" : name);
        ((TextView)findViewById(R.id.detailDescription)).setText(description == null ? "" : description);
        ((TextView)findViewById(R.id.detailAddress)).setText("📍 " + (address == null ? "" : address));

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
        Button map = findViewById(R.id.mapButton);
        map.setOnClickListener(v -> openMap());
        Button phoneButton = findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(v -> {
            if (phone == null || phone.trim().isEmpty()) {
                Toast.makeText(this, "No hay teléfono disponible para este lugar.", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
            }
        });
        findViewById(R.id.webButton).setOnClickListener(v -> {
            if (website != null && !website.isEmpty()) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(website)));
            }
        });
        findViewById(R.id.shareButton).setOnClickListener(v -> {
            String shareText = name + "\n" + description + "\n" + address;
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, shareText);
            startActivity(Intent.createChooser(share, "Compartir lugar"));
        });
    }

    private void openMap() {
        String query = Uri.encode(address == null ? name : address);
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/search/?api=1&query=" + query));
        startActivity(intent);
    }
}
