package tests;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.beans.Genre;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.datasourse.Hibernate;

import java.util.ArrayList;
import java.util.List;


public class HibernateTest extends TestCase {

    private Hibernate hibernate = new Hibernate();

    public static int idArtist;
    public static int idAlbum;

    private Artist artist = new Artist("hibernate_test",2010,"RUS","test_artist");
    private Album album = new Album("hibernate_test",12,9,"album_art",2015);
    //   private Genre genre = new Genre(?,"genre_name");


    public static List<Artist> artistList = new ArrayList<Artist>();
    public static List<Album> albumList = new ArrayList<Album>();
    public static List<Genre> genreList = new ArrayList<Genre>();

    @BeforeClass
    public void testConfigInit(){
        assertTrue(Config.init());
    }

    @BeforeClass
    public void testHibernateInit(){
        assertTrue(Config.initHibernate());
    }

    @BeforeClass
    public void testSessionFactory(){
        assertNotNull(Config.getSessionFactory());
    }


    @BeforeClass
    public void setUp() throws Exception {
        idAlbum = hibernate.insertAlbumReturnId(album);
        idArtist = hibernate.insertArtistReturnId(artist);


        artist = new Artist(idArtist,"hibernate_test",2010,"RUS","test_artist");
        album = new Album(idAlbum,"hibernate_test",12,9,"album_art",2015);

        artistList.add(artist);
        albumList.add(album);
    }


    @BeforeClass
    public void testAddArtist() throws Exception {
        assertTrue(hibernate.addArtist(artist));
    }

    @BeforeClass
    public void testAddAlbum() throws Exception {
        assertTrue(hibernate.addAlbum(album));
    }



    //Test cru for Artists

    @Test
    public void testGetArtists() throws Exception {
        assertNotNull(hibernate.getArtists());
    }

    @Test
    public void testGetArtistById() throws Exception {
        assertNotNull(hibernate.getArtistById(1));
    }

    @Test
    public void testUpdateArtist() throws Exception {
        assertTrue(hibernate.updateArtist(hibernate.getArtists()));
    }


    //Test cru for Albums

    @Test
    public void testGetAlbums() throws Exception {
        assertNotNull(hibernate.getAlbums());
    }

    @Test
    public void testGetAlbumById() throws Exception {
        assertNotNull(hibernate.getAlbumById(1));
    }

    @Test
    public void testUpdateAlbums() throws Exception {
        assertTrue(hibernate.updateAlbum(hibernate.getAlbums()));
    }





    //Test Delete

    @AfterClass
    public void testDeleteArtist() throws Exception {
        assertTrue(hibernate.removeArtist(artistList));
    }

    @AfterClass
    public void testDeleteAlbum() throws Exception {
        assertTrue(hibernate.removeAlbum(albumList));
    }


}
