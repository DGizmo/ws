package tests;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.beans.Genre;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.datasourse.CSV;

import java.util.ArrayList;
import java.util.List;


public class CSVTest extends TestCase {

    private CSV csv = new CSV();
    private Artist artist = new Artist(1,"csvtest",2010,"RUS","test_artist");
    private Album album = new Album(1,"album_name",12,9,"album_art",2015);
    //   private Genre gnre = new Genre(?,"genre_name");


    public static List<Artist> artistList = new ArrayList<Artist>();
    public static List<Album> albumList = new ArrayList<Album>();
    public static List<Genre> genreList = new ArrayList<Genre>();

    @BeforeClass
    public void testConfigInit(){
        assertTrue(Config.init());
    }

    @BeforeClass
    public void testAddArtist() throws Exception {
        assertTrue(csv.addArtist(artist));
    }

    @BeforeClass
    public void testAddAlbum() throws Exception {
        assertTrue(csv.addAlbum(album));
    }

    //Test cru for Artists

    @Test
    public void testGetArtists() throws Exception {
        assertNotNull(csv.getArtists());
    }

    @Test
    public void testGetArtistById() throws Exception {
        assertNotNull(csv.getArtistById(1));
    }

    @Test
    public void testUpdateArtist() throws Exception {
        assertTrue(csv.updateArtist(csv.getArtists()));
    }


    //Test cru for Albums

    @Test
    public void testGetAlbums() throws Exception {
        assertNotNull(csv.getAlbums());
    }

    @Test
    public void testGetAlbumById() throws Exception {
        assertNotNull(csv.getAlbumById(1));
    }

    @Test
    public void testUpdateAlbums() throws Exception {
        assertTrue(csv.updateAlbum(csv.getAlbums()));
    }






    @AfterClass
    public void testRemoveArtist() throws Exception {
        assertTrue(csv.removeArtist(csv.getArtists()));
    }

    @AfterClass
    public void testRemoveAlbum() throws Exception {
        assertTrue(csv.removeAlbum(csv.getAlbums()));
    }

}
