package ru.pariy.albums.repository;

import ru.pariy.albums.model.Album;

import java.util.List;

public interface AlbumRepository {
    List<Album> getAllAlbums();
    Album getAlbumById(long id);
    void addAlbum(Album album);
    boolean updateAlbum(long id, Album album);
    boolean deleteAlbum(long id);

}

