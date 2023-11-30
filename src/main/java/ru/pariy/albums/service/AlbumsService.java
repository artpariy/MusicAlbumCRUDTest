package ru.pariy.albums.service;

import ru.pariy.albums.repository.AlbumRepository;
import ru.pariy.albums.model.Album;

import java.util.List;

public class AlbumsService {

    private final AlbumRepository albumRepository;

    public AlbumsService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums() {
        return albumRepository.getAllAlbums();
    }

    public Album getAlbum(long id) {
        return albumRepository.getAlbumById(id);
    }

    public void add(Album album) {
        albumRepository.addAlbum(album);
    }
    public void update(long id, Album album) {
        albumRepository.updateAlbum(id, album);
    }

    public void delete(long id) {
        albumRepository.deleteAlbum(id);
    }

}
