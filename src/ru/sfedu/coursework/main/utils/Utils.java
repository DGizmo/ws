package ru.sfedu.coursework.main.utils;

import au.com.bytecode.opencsv.CSVReader;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.datasourse.CSV;

import ru.sfedu.coursework.main.beans.Artist;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Utils {
    //_______ARTIST____
    public static List<Artist> getBeansForArtist(ResultSet resultSet){
        List<Artist> list = new ArrayList<Artist>();
        int id,rise;
        String name,art ,country;
        try {
            while(resultSet.next()){
                id = resultSet.getInt(resultSet.findColumn("id"));
                name = resultSet.getString(resultSet.findColumn("artist"));
                rise = resultSet.getInt(resultSet.findColumn("rise"));
                country = resultSet.getString(resultSet.findColumn("country"));
                art = resultSet.getString(resultSet.findColumn("artist_art"));
                list.add(new Artist(id, name, rise, country, art));
            }
            resultSet.close();
        } catch (SQLException e) {
        }
        return list;
    }

    // csv Artist

    public static List<Artist> getListBeansForArtistFromCSV(CSVReader reader) {
        String[] row;
        int id,rise;
        String name,art ,country;
        List<Artist> artists = new ArrayList<Artist>();
        try {
            while((row = reader.readNext()) != null){
                id = Integer.parseInt(row[0]);
                name = row[1];
                rise = Integer.parseInt(row[2]);
                country = row[3];
                art = row[4];
                artists.add(new Artist(id,name,rise,country,art));
            }
            reader.close();
        } catch (IOException e) {
        }
        return artists;
    }

    public static List<Artist> getBeanForArtistFromCSV(CSVReader reader, int artistId){
        String[] row;
        int id,rise;
        String name,art ,country;
        List<Artist> artist = new ArrayList<Artist>();
        try {
            while((row = reader.readNext()) != null){
                id = Integer.parseInt(row[0]);
                if(id == artistId){
                    name = row[1];
                    rise = Integer.parseInt(row[2]);
                    country = row[3];
                    art = row[4];
                    artist.add(new Artist(id,name,rise,country,art));
                }
            }
            reader.close();
        } catch (IOException e) {
        }
        return artist;
    }

    // xml Artist

    @Root(name = "artists")
    public static class Artists  extends ArrayList<Artist>{
        @ElementList(inline = true)
        private List<Artist> list = this;

        public List<Artist> getList() {
            return list;
        }

        public void setList(List<Artist> list) {
            this.list = list;
        }
    }


    //________ALBUM________
    public static List<Album> getBeansForAlbum(ResultSet resultSet){
        List<Album> list = new ArrayList<Album>();
        int id,artist_name,tracks_sum,relise;
        String album_name,album_art;
        try {
            while(resultSet.next()){
                id = resultSet.getInt(resultSet.findColumn("id"));
                album_name = resultSet.getString(resultSet.findColumn("album_name"));
                artist_name = resultSet.getInt(resultSet.findColumn("artist_name"));
                tracks_sum = resultSet.getInt(resultSet.findColumn("tracks_sum"));
                album_art = resultSet.getString(resultSet.findColumn("album_art"));
                relise = resultSet.getInt(resultSet.findColumn("relise"));
                list.add(new Album(id, album_name, artist_name, tracks_sum, album_art,relise));
            }
            resultSet.close();
        } catch (SQLException e) {
        }
        return list;
    }
    // csv Album

    public static List<Album> getListBeansForAlbumFromCSV(CSVReader reader) {
        String[] row;
        int id,artist_name,tracks_sum,relise;
        String album_name,album_art;
        List<Album> albums = new ArrayList<Album>();
        try {
            while((row = reader.readNext()) != null){
                id = Integer.parseInt(row[0]);
                album_name = row[1];
                artist_name = Integer.parseInt(row[2]);
                tracks_sum = Integer.parseInt(row[3]);
                album_art = row[4];
                relise = Integer.parseInt(row[5]);
                albums.add(new Album(id,album_name,artist_name,tracks_sum,album_art,relise));
            }
            reader.close();
        } catch (IOException e) {
        }
        return albums;
    }

    public static List<Album> getBeanForAlbumFromCSV(CSVReader reader, int albumId){
        String[] row;
        int id,artist_name,tracks_sum,relise;
        String album_name,album_art;
        List<Album> albums = new ArrayList<Album>();
        try {
            while((row = reader.readNext()) != null){
                id = Integer.parseInt(row[0]);
                if(id == albumId){
                    album_name = row[1];
                    artist_name = Integer.parseInt(row[2]);
                    tracks_sum = Integer.parseInt(row[3]);
                    album_art = row[4];
                    relise = Integer.parseInt(row[5]);
                    albums.add(new Album(id,album_name,artist_name,tracks_sum,album_art,relise));
                }
            }
            reader.close();
        } catch (IOException e) {
        }
        return albums;
    }

    //xml Album
    @Root(name = "albums")
    public static class Albums  extends ArrayList<Album>{
        @ElementList(inline = true)
        private List<Album> list = this;

        public List<Album> getList() {
            return list;
        }

        public void setList(List<Album> list) {
            this.list = list;
        }
    }



}