package ru.sfedu.coursework.main.beans;

import org.hibernate.annotations.GenericGenerator;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.persistence.*;
import java.io.Serializable;

//@Entity
//@Table(name = "Album")
//@Root(name = "Album")
public class Album {
  //  @Id
 //   @Column(name = "id")
 //   @GeneratedValue(generator="increment")
//    @GenericGenerator(name="increment", strategy = "increment")
//    @Attribute
    private int id;

//    @Column(name = "album_name")
//    @Element(name = "album_name")
    private String album_name;
  //  @Column(name = "artist_name")
 //   @Element(name = "artist_name")
    private int artist_name;
//    @Column(name = "tracks_sum")
//    @Element(name = "tracks_sum")
    private int tracks_sum;
//    @Column(name = "album_art")
//    @Element(name = "album_art")
    private String album_art;
//    @Column(name = "relise")
//    @Element(name = "relise")
    private int relise;

    public Album(){}

    public Album(int id, String album_name, int artist_name,int tracks_sum, String album_art, int relise) {
        this.id = id;
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.tracks_sum = tracks_sum;
        this.album_art = album_art;
        this.relise = relise;
    }

    public Album(String album_name, int artist_name,int tracks_sum, String album_art, int relise) {
        this.album_name = album_name;
        this.artist_name = artist_name;
        this.tracks_sum = tracks_sum;
        this.album_art = album_art;
        this.relise = relise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum() {
        return album_name;
    }

    public void setAlbum(String album_name) {
        this.album_name = album_name;
    }

    public int getArtist() {
        return artist_name;
    }

    public void setArtist(int artist_name) {
        this.artist_name = artist_name;
    }

    public int getTrackSum() {
        return tracks_sum;
    }

    public void setTrackSum(int tracks_sum) {
        this.tracks_sum = tracks_sum;
    }

    public String getAlbumArt() {
        return album_art;
    }

    public void setAlbumArt(String album_art) {
        this.album_art = album_art;
    }

    public int getRelise() {
        return relise;
    }

    public void setRelise(int relise) {
        this.relise = relise;
    }

}
