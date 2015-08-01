package ru.sfedu.coursework.main.datasourse;


import org.apache.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.dao.AlbumDao;
import ru.sfedu.coursework.main.dao.ArtistDao;
import ru.sfedu.coursework.main.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XML implements ArtistDao,AlbumDao{

    Logger logger = Logger.getLogger(XML.class);
    private final String XMLARTIST;
    private final String XMLALBUM;
    private final String XMLGENRE;

    public XML(){
        Config.init();
        XMLARTIST = (Config.getProp()).getProperty(Config.XMLARTIST);
        XMLALBUM = (Config.getProp()).getProperty(Config.XMLALBUM);
        XMLGENRE = (Config.getProp()).getProperty(Config.XMLGENRE);
    }

    //____ARTISTS_____
    @Override
    public boolean addArtist(Artist artist) {
        if((getArtistById(artist.getId())).size()>0){
            logger.warn("Артист с таким id=" + artist.getId() + " уже существует");
            return false;
        }
        Serializer serializer = new Persister();
        File source = new File(XMLARTIST);
        Utils.Artists inserted = new Utils.Artists();
        List<Artist> all = getArtists();
        all.add(artist);
        inserted.setList(all);
        try {
            serializer.write(inserted,source);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateArtist(List<Artist> artist) {
        List<Artist> all = getArtists();
        for(Artist update : artist){
            for(Artist art :all){
                if(update.getId() == art.getId()){
                    art.setArtist(update.getArtist());
                    art.setRise(update.getRise());
                    art.setCountry(update.getCountry());
                    art.setArtist_art((update.getArtist_art()));
                }
            }
        }
        try {
            FileWriter writer = new FileWriter(XMLARTIST);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        for(Artist art : all){
            addArtist(art);
        }
        return true;
    }

    @Override
    public boolean removeArtist(List<Artist> artist) {
        List<Artist> all = getArtists();
        Boolean flag;
        for (Artist delete : artist) {
            Iterator<Artist> iterator = all.iterator();
            while (iterator.hasNext()) {
                Artist art = iterator.next();
                if (art.getId() == delete.getId()) {

                    //if((getArtistById(art.getId())).size() == 0) {
                        iterator.remove();
                    //}
                    //else logger.warn("Не удалось удалить артиста id="+art.getId()+", так как с ним связанна запись в файле "+XMLALBUM);

                }
            }
        }
        try {
            FileWriter writer = new FileWriter(XMLARTIST);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        for(Artist art : all){
            addArtist(art);
        }
        return true;
    }

    @Override
    public List<Artist> getArtistById(int artistId) {
        List<Artist> artists = new ArrayList<Artist>();
        Serializer serializer = new Persister();
        File source = new File(XMLARTIST);
        List<Artist> output = new ArrayList<Artist>();
        try {
            if (source.length() > 0) {
                Utils.Artists data = serializer.read(Utils.Artists.class, source);
                for (Artist artist : data) {
                    if (artist.getId() == artistId) {
                        output.add(artist);
                        return output;
                    }
                }
                return output;
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return output;
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<Artist>();
        Serializer serializer = new Persister();
        File source = new File(XMLARTIST);
        try {
            if(source.length()>0) {
                Utils.Artists example = serializer.read(Utils.Artists.class, source);
                return example;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return artists;
    }

    //____ALBUMS_____

    @Override
    public boolean addAlbum(Album album) {
        if((getAlbumById(album.getId())).size()>0){
            logger.warn("Альбом с таким id=" + album.getId() + " уже существует");
            return false;
        }
        Serializer serializer = new Persister();
        File source = new File(XMLALBUM);
        Utils.Albums inserted = new Utils.Albums();
        List<Album> all = getAlbums();
        all.add(album);
        inserted.setList(all);
        try {
            serializer.write(inserted,source);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateAlbum(List<Album> album) {
        List<Album> all = getAlbums();
        for(Album update : album){
            for(Album art :all){
                if(update.getId() == art.getId()){
                    art.setAlbum(update.getAlbum());
                    art.setArtist(update.getArtist());
                    art.setTrackSum(update.getTrackSum());
                    art.setAlbumArt((update.getAlbumArt()));
                    art.setRelise((update.getRelise()));
                }
            }
        }
        try {
            FileWriter writer = new FileWriter(XMLALBUM);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        for(Album alb : all){
            addAlbum(alb);
        }
        return true;
    }

    @Override
    public boolean removeAlbum(List<Album> album) {
        List<Album> all = getAlbums();
        for (Album delete : album) {
            Iterator<Album> iterator = all.iterator();
            while (iterator.hasNext()) {
                Album alb = iterator.next();
                if (alb.getId() == delete.getId()) {
                    iterator.remove();
                }
            }
        }
        try {
            FileWriter writer = new FileWriter(XMLALBUM);
            writer.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        for(Album alb : all){
            addAlbum(alb);
        }
        return true;
    }

    @Override
    public List<Album> getAlbumById(int albumId) {
        List<Album> albums = new ArrayList<Album>();
        Serializer serializer = new Persister();
        File source = new File(XMLALBUM);
        List<Album> output = new ArrayList<Album>();
        try {
            if (source.length() > 0) {
                Utils.Albums data = serializer.read(Utils.Albums.class, source);
                for (Album album : data) {
                    if (album.getId() == albumId) {
                        output.add(album);
                        return output;
                    }
                }
                return output;
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return output;
    }

    @Override
    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<Album>();
        Serializer serializer = new Persister();
        File source = new File(XMLALBUM);
        try {
            if(source.length()>0) {
                Utils.Albums example = serializer.read(Utils.Albums.class, source);
                return example;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return albums;
    }


}
