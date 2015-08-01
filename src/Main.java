import ru.sfedu.coursework.main.beans.Album;
import ru.sfedu.coursework.main.beans.Artist;
import ru.sfedu.coursework.main.datasourse.CSV;
import ru.sfedu.coursework.main.datasourse.MySQL;
import ru.sfedu.coursework.main.datasourse.XML;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        MySQL mySQL = new MySQL();
        mySQL.connect();
        List<Album> list;
        List<Album> list2;

        Album album;
        boolean flag;
        list =  mySQL.getAlbums();

        album = new Album(1,"album_test",12,9,"art",2010);
//        flag = mySQL.addArtist(artist);
//        System.out.println(flag);

       // list = mySQL.getArtistById(list.get(list.size()-1).getId());
       // System.out.println(mySQL.getArtists());

       // List<Artist> artistList = new ArrayList<Artist>();
       // artistList = mySQL.getArtists();
       // System.out.println( mySQL.getArtists());
        //System.out.println(list.get(1).getId()); //6
        //System.out.println(list.remove(0)); //6
        //list.remove(0);
        //flag = mySQL.removeArtist(list);
        //System.out.println(flag);
        //list2.add(list.get(1));

        CSV csv = new CSV();
        //csv.addArtist(artist);

        //System.out.println(csv.updateArtist(csv.getArtists()) );
        //System.out.println(csv.removeArtist(csv.getArtists()  ));

//        XML xml = new XML();
//
//        System.out.println(xml.removeArtist(xml.getArtists()));
        //System.out.println(mySQL.removeAlbum(mySQL.getAlbums()) );

        //list  = mySQL.getAlbums();
        System.out.println(csv.removeAlbum(csv.getAlbums()));

    }
}
