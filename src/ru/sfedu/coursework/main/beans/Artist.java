package ru.sfedu.coursework.main.beans;

import org.hibernate.annotations.GenericGenerator;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "Artist")
//@Root(name = "Artist")
public class Artist{
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    @Attribute
    private int id;
//    @Column(name = "artist")
//    @Element
    private String artist;
//    @Column(name = "rise")
//    @Element
    private int rise;
//    @Column(name = "country")
//    @Element
    private String country;
//    @Column(name = "artist_art")
//    @Element
    private String artist_art;

    public Artist(){}

    public Artist(int id, String artist, int rise, String country, String artist_art) {
        this.id = id;
        this.artist = artist;
        this.rise = rise;
        this.country = country;
        this.artist_art = artist_art;
    }

    public Artist(String artist, int rise, String country, String artist_art) {
        this.artist = artist;
        this.rise = rise;
        this.country = country;
        this.artist_art = artist_art;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRise() {
        return rise;
    }

    public void setRise(int rise) {
        this.rise = rise;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArtist_art() {
        return artist_art;
    }

    public void setArtist_art(String artist_art) {
        this.artist_art = artist_art;
    }
}
