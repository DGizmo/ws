package ru.sfedu.coursework.main.datasourse;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.log4j.Logger;

import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.dao.AlbumDao;
import ru.sfedu.coursework.main.dao.ArtistDao;
import ru.sfedu.coursework.main.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;




public class CSV implements ArtistDao,AlbumDao{

    private final String ARTIST_PATH;
    private final String ALBUM_PATH;
    private final String GENRE_PATH;

    Logger logger = Logger.getLogger(CSV.class);

    public CSV() {
        Config.init();
        ARTIST_PATH = (Config.getProp()).getProperty(Config.CSVARTIST);
        ALBUM_PATH = (Config.getProp()).getProperty(Config.CSVALBUM);
        GENRE_PATH = (Config.getProp()).getProperty(Config.CSVGENRE);
    }


    //___ARTIST____

    @Override
    public boolean addArtist(Artist artist) {
//        if((getArtistById(artist.getId())).size()>0){
//            logger.error("Исполнитель с таким id уже существует");
//            return false;
//        }
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARTIST_PATH,true),',');
                String[] row = {Integer.toString(artist.getId()), String.valueOf(artist.getArtist()), String.valueOf(artist.getRise()), String.valueOf(artist.getCountry()),artist.getArtist_art()};
            writer.writeNext(row);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateArtist(List<Artist> artist) {
        List<Artist> allArtists = getArtists();
        for (Artist aArtist : artist) {
            for(Artist bArtist : allArtists){
                if(aArtist.getId() == bArtist.getId()){
                    bArtist.setArtist(aArtist.getArtist());
                    bArtist.setRise(aArtist.getRise());
                    bArtist.setCountry(aArtist.getCountry());
                    bArtist.setArtist_art(aArtist.getArtist_art());
                }
            }
        }
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARTIST_PATH),',');
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        for(Artist artists : allArtists){
            addArtist(artists);
        }
        return true;
    }

    @Override
    public boolean removeArtist(List<Artist> artist) {
        List<Artist> allArtists = getArtists();
        List<Artist> buffer = new ArrayList<Artist>();
        boolean flag;
        for (Artist allArtist : allArtists) {
            flag = true;//false;
//            for (Artist artists : artist) {
//                if (allArtist.getId() == artists.getId()) {
//                    if((getArtistById(allArtist.getId())).size() == 0)flag = true;
//                    else logger.warn("Не удалось удалить артиста id="+allArtist.getId()+", так как с ним связанна запись в файле "+ARTIST_PATH);
//                }
//            }
            if (!flag) buffer.add(allArtist);
        }
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ARTIST_PATH),',');
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        for(Artist artists : buffer){
            addArtist(artists);
        }
        return true;
    }

    @Override
    public List<Artist> getArtistById(int artistId) {
        try {
            return Utils.getBeanForArtistFromCSV(new CSVReader(new FileReader(ARTIST_PATH), ','), artistId);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Artist> getArtists() {
        try {
            return Utils.getListBeansForArtistFromCSV(new CSVReader(new FileReader(ARTIST_PATH), ','));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        }
    }


    //_____ALBUMS_____

    @Override
    public boolean addAlbum(Album album) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ALBUM_PATH,true),',');
            String[] row = {Integer.toString(album.getId()), album.getAlbum(), Integer.toString(album.getArtist()),Integer.toString(album.getTrackSum()) ,album.getAlbumArt(), Integer.toString(album.getRelise())};
            writer.writeNext(row);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAlbum(List<Album> album) {
        List<Album> allAlbums = getAlbums();
        for (Album aAlbum : album) {
            for(Album bAlbum : allAlbums){
                if(aAlbum.getId() == bAlbum.getId()){
                    bAlbum.setAlbum(aAlbum.getAlbum());
                    bAlbum.setArtist(aAlbum.getArtist());
                    bAlbum.setTrackSum(aAlbum.getTrackSum());
                    bAlbum.setAlbumArt(aAlbum.getAlbumArt());
                    bAlbum.setRelise(aAlbum.getRelise());
                }
            }
        }
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ALBUM_PATH),',');
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        for(Album albums: allAlbums){
            addAlbum(albums);
        }
        return true;
    }

    @Override
    public boolean removeAlbum(List<Album> album) {
        List<Album> buffer = new ArrayList<Album>();
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(ALBUM_PATH),',');
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
        for(Album albums : buffer){
            addAlbum(albums);
        }
        return true;
    }

    @Override
    public List<Album> getAlbumById(int albumId) {
        try {
            return Utils.getBeanForAlbumFromCSV(new CSVReader(new FileReader(ALBUM_PATH), ','), albumId);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Album> getAlbums() {
        try {
            return Utils.getListBeansForAlbumFromCSV(new CSVReader(new FileReader(ALBUM_PATH), ','));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
