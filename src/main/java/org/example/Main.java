package org.example;

import org.example.dao.ArtistDAO;
import org.example.models.Artist;

public class Main {
    public static void main(String[] args) {
        ArtistDAO artist = new ArtistDAO();
        Artist a = new Artist();
        a.setName("Shiloh Dynasty");
        Artist b = new Artist();
        b.setName("SadBoyProlific");

        //adding
        artist.add(a);
        artist.add(b);
        //selecting
        artist.findAll();

    }
}