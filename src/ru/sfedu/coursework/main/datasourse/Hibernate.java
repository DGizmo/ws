package ru.sfedu.coursework.main.datasourse;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.dao.AlbumDao;
import ru.sfedu.coursework.main.dao.ArtistDao;

import java.util.ArrayList;
import java.util.List;

public class Hibernate implements ArtistDao,AlbumDao{
    private Logger logger = Logger.getLogger(Hibernate.class);

    //_____ARTIST____
    @Override
    public boolean addArtist(Artist artist) {
        Session session = null;
        Transaction transaction = null;
        Artist artist1;
        try{
            session = Config.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            artist1 = (Artist)session.save(artist);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateArtist(List<Artist> artist) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = Config.getSessionFactory().openSession();
            for(Artist art : artist){
                transaction = session.beginTransaction();
                session.update(art);
                session.getTransaction().commit();
            }
            session.close();
            return true;
        }catch (HibernateException e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeArtist(List<Artist> artist) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = Config.getSessionFactory().openSession();
            for(Artist art : artist){
                transaction = session.beginTransaction();
                session.delete(art);
                session.getTransaction().commit();
            }
            session.close();
            return true;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Artist> getArtistById(int artistId) {
        Session session = null;
        List<Artist> artists = new ArrayList<Artist>();
        try {
            session = Config.getSessionFactory().openSession();
            artists.add((Artist)session.get(Artist.class,new Integer(artistId)));
            session.close();
            return artists;
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<Artist>();
        Session session = null;
        try {
            session = Config.getSessionFactory().openSession();
            artists = session.createCriteria(Artist.class).list();
            session.close();
            return artists;
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public Integer insertArtistReturnId(Artist artist) {
        Session session = null;
        Transaction transaction = null;
        Integer id;
        try{
            session = Config.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (Integer)session.save(artist);
            session.getTransaction().commit();
            session.close();
            return id;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return null;
        }
    }


    //_____ALBUM____
    @Override
    public boolean addAlbum(Album album) {
        Session session = null;
        Transaction transaction = null;
        Album album1;
        try{
            session = Config.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            album1 = (Album)session.save(album);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAlbum(List<Album> album) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = Config.getSessionFactory().openSession();
            for(Album alb : album){
                transaction = session.beginTransaction();
                session.update(alb);
                session.getTransaction().commit();
            }
            session.close();
            return true;
        }catch (HibernateException e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean removeAlbum(List<Album> album) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = Config.getSessionFactory().openSession();
            for(Album alb : album){
                transaction = session.beginTransaction();
                session.delete(alb);
                session.getTransaction().commit();
            }
            session.close();
            return true;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Album> getAlbumById(int albumId) {
        Session session = null;
        List<Album> albums = new ArrayList<Album>();
        try {
            session = Config.getSessionFactory().openSession();
            albums.add((Album)session.get(Album.class,new Integer(albumId)));
            session.close();
            return albums;
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Album> getAlbums() {
        List<Album> albums = new ArrayList<Album>();
        Session session = null;
        try {
            session = Config.getSessionFactory().openSession();
            albums = session.createCriteria(Album.class).list();
            session.close();
            return albums;
        }catch (Exception e){
            logger.error(e.getMessage());
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public Integer insertAlbumReturnId(Album album) {
        Session session = null;
        Transaction transaction = null;
        Integer id;
        try{
            session = Config.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (Integer)session.save(album);
            session.getTransaction().commit();
            session.close();
            return id;
        }catch (Exception e){
            if(transaction != null)transaction.rollback();
            if (session != null && session.isOpen()) {
                session.close();
            }
            logger.error(e.getMessage());
            return null;
        }
    }


}
