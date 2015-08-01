package ru.sfedu.coursework.main.datasourse;

import org.apache.log4j.Logger;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.dao.AlbumDao;
import ru.sfedu.coursework.main.dao.ArtistDao;
import ru.sfedu.coursework.main.utils.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class MySQL implements ArtistDao, AlbumDao{
    private Logger logger = Logger.getLogger(MySQL.class);
    Connection connection = null;

    public MySQL(){
        Config.init();
    }

    public boolean connect(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                logger.error(e.getMessage());
            }
            connection = DriverManager.getConnection("jdbc:mysql://" + (Config.getProp()).getProperty(Config.SERVER_KEY) + "/" + (Config.getProp()).getProperty(Config.DATABASE_KEY) + "?user=" + (Config.getProp()).getProperty(Config.LOGIN_KEY));
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    //Artist

    @Override
    public boolean addArtist(Artist artist) {
        try {
            connection.createStatement().executeUpdate("insert into Artist (artist,rise,country,artist_art) values('" + artist.getArtist() + "' , " + artist.getRise() + " , '" + artist.getCountry() + "' ,'" + artist.getArtist_art() +"' )");
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateArtist(List<Artist> artist) {
        for(int i=0; i<artist.size(); i+=1){
            try {
                (connection.createStatement()).executeUpdate("update Artist set artist='" + artist.get(i).getArtist() + "', rise='" + artist.get(i).getRise() + "', country='" + artist.get(i).getCountry() + "', artist_art='"+ artist.get(i).getArtist_art() + "'  where id=" + artist.get(i).getId());
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeArtist(List<Artist> artist) {
        for(int i=0; i<artist.size(); i+=1){
            try {
                (connection.createStatement()).executeUpdate("delete from Artist where id=" + artist.get(i).getId());
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Artist> getArtistById(int artistId) {
        try {
            return Utils.getBeansForArtist(connection.createStatement().executeQuery("select * from Artist where id = "+artistId));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Artist> getArtists() {
        try {
            return Utils.getBeansForArtist(connection.createStatement().executeQuery("select * from Artist"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    //Album
    @Override
    public boolean addAlbum(Album album) {
        try {
            connection.createStatement().executeUpdate("insert into Album (album_name,artist_name,tracks_sum,album_art,relise) values('" + album.getAlbum() + "' , " + album.getArtist() + ","+album.getTrackSum() +" , '" + album.getAlbumArt() + "' ," + album.getRelise() +" )");
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAlbum(List<Album> album) {
        for(int i=0; i<album.size(); i+=1){
            try {
                (connection.createStatement()).executeUpdate("update Album set album_name='" + album.get(i).getAlbum() + "', artist_name='" + album.get(i).getArtist() + "', artist_name='" + album.get(i).getArtist() + "', tracks_sum='"+ album.get(i).getTrackSum() + "', album_art='"+ album.get(i).getAlbumArt() +"', relise='"+ album.get(i).getRelise() +"'  where id=" + album.get(i).getId());
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAlbum(List<Album> album) {
        for(int i=0; i<album.size(); i+=1){
            try {
                (connection.createStatement()).executeUpdate("delete from Album where id=" + album.get(i).getId());
            } catch (SQLException e) {
                logger.error(e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Album> getAlbumById(int albumId) {
        try {
            return Utils.getBeansForAlbum(connection.createStatement().executeQuery("select * from Album where id = " + albumId));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Album> getAlbums() {
        try {
            return Utils.getBeansForAlbum(connection.createStatement().executeQuery("select * from Album"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
            return null;
        }
    }  
    
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }




}

