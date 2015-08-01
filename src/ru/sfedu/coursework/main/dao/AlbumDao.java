package ru.sfedu.coursework.main.dao;

import ru.sfedu.coursework.main.beans.Album;

import java.util.List;

public interface AlbumDao {

        public boolean addAlbum(Album album);
        public boolean updateAlbum(List<Album> album);
        public boolean removeAlbum(List<Album> album);
        public List<Album> getAlbumById(int albumId);
        public List<Album> getAlbums();

}
