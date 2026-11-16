package com.example.guia_turistica_tokio;

import java.util.ArrayList;
import java.util.List;

public class PlaceData {
    public static List<Place> all() {
        List<Place> places = new ArrayList<>();
        places.add(new Place("Templo Sensō-ji", "Monumentos", "🏯",
                "Uno de los templos budistas más conocidos de Tokio. Su gran puerta Kaminarimon y la calle comercial Nakamise son visitas imprescindibles.",
                "2 Chome-3-1 Asakusa, Taito City, Tokio, Japón", "", "https://www.senso-ji.jp/"));
        places.add(new Place("Tokyo Skytree", "Monumentos", "🗼",
                "Una de las torres más altas del mundo. Sus miradores ofrecen vistas panorámicas de la ciudad.",
                "1 Chome-1-2 Oshiage, Sumida City, Tokio, Japón", "", "https://www.tokyo-skytree.jp/en/"));
        places.add(new Place("Palacio Imperial", "Monumentos", "🏯",
                "Residencia del emperador de Japón, rodeada de jardines, fosos y zonas históricas.",
                "1-1 Chiyoda, Chiyoda City, Tokio, Japón", "", "https://www.kunaicho.go.jp/eindex.html"));
        places.add(new Place("Ichiran Shibuya", "Restaurantes", "🍜",
                "Restaurante popular especializado en ramen tonkotsu. Una opción conocida para probar ramen japonés.",
                "1 Chome-22-7 Jinnan, Shibuya, Tokio, Japón", "", "https://ichiran.com/"));
        places.add(new Place("Tsukiji Outer Market", "Restaurantes", "🍣",
                "Mercado famoso por sus puestos de comida, sushi, marisco y productos japoneses.",
                "4 Chome-16-2 Tsukiji, Chuo City, Tokio, Japón", "", "https://www.tsukiji.or.jp/"));
        places.add(new Place("Afuri Ramen", "Restaurantes", "🍋",
                "Cadena conocida por su ramen ligero y su caldo con yuzu, un cítrico japonés.",
                "Ebisu, Shibuya, Tokio, Japón", "", "https://afuri.com/"));
        places.add(new Place("Cruce de Shibuya", "Ocio", "🌃",
                "Uno de los cruces peatonales más famosos del mundo, rodeado de pantallas, tiendas y ambiente urbano.",
                "Shibuya Station, Shibuya, Tokio, Japón", "", "https://www.gotokyo.org/en/"));
        places.add(new Place("Parque Ueno", "Ocio", "🌸",
                "Gran parque urbano con museos, estanques y cerezos en flor durante la primavera.",
                "Uenokoen, Taito City, Tokio, Japón", "", "https://www.kensetsu.metro.tokyo.lg.jp/"));
        places.add(new Place("Odaiba", "Ocio", "🎡",
                "Zona moderna junto a la bahía de Tokio, con centros comerciales, paseos y vistas del puente Rainbow.",
                "Daiba, Minato City, Tokio, Japón", "", "https://www.gotokyo.org/en/"));
        return places;
    }
}
