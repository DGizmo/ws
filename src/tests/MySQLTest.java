package tests;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.beans.Genre;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.datasourse.MySQL;

import java.util.ArrayList;
import java.util.List;


public class MySQLTest extends TestCase {

    public static MySQL mysql = new MySQL();
    private Artist artist = new Artist("mysqltest",2010,"RUS","test_artist");
    private Album album = new Album("album_name",12,9,"album_art",2015);
    //   private Genre gnre = new Genre(?,"genre_name");


    public static List<Artist> artistList = new ArrayList<Artist>();
    public static List<Album> albumList = new ArrayList<Album>();
    private List<Genre> genreList = new ArrayList<Genre>();


    @BeforeClass
    public void testConfigInit(){
        assertTrue(Config.init());
    }

    @BeforeClass
    public static void testConnect() throws Exception {
        assertTrue(mysql.connect());
        artistList = mysql.getArtists();
        albumList = mysql.getAlbums();
    }

    @BeforeClass
    public void testInsertArtist() throws Exception {
        assertTrue(mysql.addArtist(artist));
    }

    @BeforeClass
    public void testInsertAlbum() throws Exception {
        assertTrue(mysql.addAlbum(album));
    }


    //_________TESTS
    //Artist

    @Test
    public void testGetArtists(){
        assertNotNull(mysql.getArtists());
    }

    @Test
    public void testGetArtistById() throws Exception {
        assertNotNull(mysql.getArtistById(artistList.get(artistList.size()-1).getId()));
    }

    @Test
    public void testUpdateArtist(){
        artistList.get(artistList.size()-1).setArtist("mysqltest_name");
        assertTrue(mysql.updateArtist(artistList));
    }


    //________ALBUM______

    public void testGetAlbum(){
        assertNotNull(mysql.getAlbums());
    }

    @Test
    public void testGetAlbumById() throws Exception {
        assertNotNull(mysql.getAlbumById(albumList.get(albumList.size()-1).getId()));
    }

    @Test
    public void testUpdateAlbums(){
        albumList.get(albumList.size()-1).setAlbum("album_name_test");
        assertTrue(mysql.updateAlbum(albumList));
    }




    @AfterClass
    public void testRemoveArtist(){
        assertTrue(mysql.removeArtist(artistList.subList(artistList.size()-2,artistList.size()-1) ) );
    }

    @AfterClass
    public void testRemoveAlbum(){
        assertTrue(mysql.removeAlbum(albumList.subList(albumList.size()-2,albumList.size()-1) ) );
    }



}
