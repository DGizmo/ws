package ws;

import com.google.gson.Gson;
import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.datasourse.MySQL;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class MusicWebService {

    //webmethode for Artist

    @WebMethod
    public String getArtistsWS() {
        MySQL mysql = new MySQL();
        mysql.connect();
        List<Artist> artists = mysql.getArtists();
        Gson gson = new Gson();
        String json = "{artists:" + gson.toJsonTree(artists) + "}";
        mysql.close();
        return json;
    }

    @WebMethod
    public String getArtistWS(int id) {

        MySQL mysql = new MySQL();
        mysql.connect();
        List<Artist> artists = mysql.getArtistById(id);
        Gson gson = new Gson();
        String json = gson.toJson(artists);
        mysql.close();
        return json;
    }

    @WebMethod
    public boolean addArtistWS(String artist,int rise,String country,String artist_art) {

        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        status = mysql.addArtist(new Artist(artist, rise, country, artist_art));
        mysql.close();
        return status;
    }

    @WebMethod
    public boolean updateArtistWS(int id,String artist,int rise,String country,String artist_art){
        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        List<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist(id,artist, rise, country, artist_art));
        status = mysql.updateArtist(artists);
        mysql.close();
        return status;
    }

    @WebMethod
    public boolean deleteArtistWS(int id){
        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        List<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist(id,"ws_test",2000,"RUS","art_test"));
        status = mysql.removeArtist(artists);
        mysql.close();
        return status;
    }


    //webmethode for Album

    @WebMethod
    public String getAlbumsWS() {
        MySQL mysql = new MySQL();
        mysql.connect();
        List<Album> albums = mysql.getAlbums();
        Gson gson = new Gson();
        String json = "{albums:" + gson.toJsonTree(albums) + "}";
        mysql.close();
        return json;
    }

    @WebMethod
    public String getAlbumsWS(int id) {

        MySQL mysql = new MySQL();
        mysql.connect();
        List<Album> albums = mysql.getAlbumById(id);
        Gson gson = new Gson();
        String json = gson.toJson(albums);
        mysql.close();
        return json;
    }

    @WebMethod
    public boolean addAlbumsWS(String album_name,int artist_name,int tracks_sum,String album_art,int relise) {

        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        status = mysql.addAlbum(new Album(album_name, artist_name, tracks_sum, album_art,relise));
        mysql.close();
        return status;
    }

    @WebMethod
    public boolean updateAlbumsWS(int id, String album_name, int artist_name,int tracks_sum, String album_art, int relise){
        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        List<Album> albums = new ArrayList<Album>();
        albums.add(new Album(id,album_name, artist_name, tracks_sum, album_art,relise));
        status = mysql.updateAlbum(albums);
        mysql.close();
        return status;
    }

    @WebMethod
    public boolean deleteAlbumsWS(int id){
        MySQL mysql = new MySQL();
        mysql.connect();
        boolean status;
        List<Album> albums = new ArrayList<Album>();
        albums.add(new Album(id,"ws_test",12,9,"alb_art",2011));
        status = mysql.removeAlbum(albums);
        mysql.close();
        return status;
    }



}
