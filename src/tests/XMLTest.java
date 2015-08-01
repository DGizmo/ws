package tests;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.beans.Genre;
import ru.sfedu.coursework.main.config.Config;
import ru.sfedu.coursework.main.datasourse.XML;

import java.util.ArrayList;
import java.util.List;


public class XMLTest extends TestCase {
    private XML xml = new XML();
    private Artist artist = new Artist(2,"xmltest",2010,"RUS","test_artist");
    private Album album = new Album(1,"album_name",12,9,"album_art",2015);
    //   private Genre gnre = new Genre(?,"genre_name");


    public static List<Artist> artistList = new ArrayList<Artist>();
    private List<Album> albumList = new ArrayList<Album>();
    private List<Genre> genreList = new ArrayList<Genre>();

    @BeforeClass
    public void testConfigInit(){
        assertTrue(Config.init());
    }

    @BeforeClass
    public void testAddArtist() throws Exception {
        assertTrue(xml.addArtist(artist));
    }

    @BeforeClass
    public void testAddAlbum() throws Exception {
        assertTrue(xml.addAlbum(album));
    }

    //Test cru for ARTISTS

    @Test
    public void testGetArtists() throws Exception {
        assertNotNull(xml.getArtists());
    }

    @Test
    public void testGetArtistById() throws Exception {
        assertNotNull(xml.getArtistById(0));
    }

    @Test
    public void testUpdateArtist() throws Exception {
        //players.get(0).setCountry("RF");
        assertTrue(xml.updateArtist(xml.getArtists()));
    }


    //Test cru for ALBUMS
    @Test
    public void testGetAlbums() throws Exception {
        assertNotNull(xml.getAlbums());
    }

    @Test
    public void testGetAlbumsById() throws Exception {
        assertNotNull(xml.getAlbumById(1));
    }

    @Test
    public void testUpdateAlbums() throws Exception {
        assertTrue(xml.updateAlbum(xml.getAlbums()));
    }





    @AfterClass
    public void testRemoveAlbum() throws Exception {
        assertTrue(xml.removeAlbum(xml.getAlbums()));
    }


    @AfterClass
    public void testRemoveArtist() throws Exception {
        assertTrue(xml.removeArtist(xml.getArtists()));
    }

}
