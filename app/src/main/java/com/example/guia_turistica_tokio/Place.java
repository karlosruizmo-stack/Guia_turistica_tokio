package com.example.guia_turistica_tokio;

public class Place {
    public final String name, category, emoji, description, address, phone, website;
    public Place(String name, String category, String emoji, String description,
                 String address, String phone, String website) {
        this.name = name; this.category = category; this.emoji = emoji;
        this.description = description; this.address = address;
        this.phone = phone; this.website = website;
    }
}
