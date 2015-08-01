package ru.sfedu.coursework.main.dao;

import ru.sfedu.coursework.main.beans.Artist;

import java.util.List;

public interface ArtistDao {

    public boolean addArtist(Artist artist);
    public boolean updateArtist(List<Artist> artist);
    public boolean removeArtist(List<Artist> artist);
    public List<Artist> getArtistById(int artistId);
    public List<Artist> getArtists();

}
