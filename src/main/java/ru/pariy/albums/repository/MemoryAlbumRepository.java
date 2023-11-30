package ru.pariy.albums.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.pariy.albums.model.Album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Реализация хранилища альбомов в памяти, соответствующая интерфейсу {@link AlbumRepository}.
 * Это хранилище хранит альбомы в списке в памяти. Класс реализует методы репозитория альбомов.
 */
public class MemoryAlbumRepository implements AlbumRepository {
    private static final Logger logger = LoggerFactory.getLogger(MemoryAlbumRepository.class);
    private final List<Album> albums = new ArrayList<>();
    private long nextId = 1;

    @Override
    public List<Album> getAllAlbums() {
        if (albums.isEmpty()) {
            logger.info("Album collection is empty");
            return Collections.emptyList();
        }
        return albums;
    }

    @Override
    public Album getAlbumById(long id) {
        for (Album album : albums) {
            if (album.getId() == id) {
                logger.info("Album is found by id = " + id);
                return album;
            }
        }
        logger.info("Album is not found by id = " + id);
        return null;
    }

    @Override
    public void addAlbum(Album album) {
        Objects.requireNonNull(album, "Album must be not null");
        album.setId(nextId++);
        albums.add(album);
        logger.info("Album successfully added\n" + album);
    }

    @Override
    public boolean updateAlbum(long id, Album album) {
        Album albumForUpdate = getAlbumById(id);
        if (albumForUpdate != null) {
            albumForUpdate.setArtist(album.getArtist());
                albumForUpdate.setName(album.getName());
                albumForUpdate.setGenre(album.getGenre());
                albumForUpdate.setReleased(album.getReleased());
                albumForUpdate.setRecorded(album.getRecorded());
                albumForUpdate.setDuration(album.getDuration());
                albumForUpdate.setCountry(album.getCountry());
                albumForUpdate.setLabel(album.getLabel());
                albumForUpdate.setProducer(album.getLabel());
                albumForUpdate.setLabel(album.getLabel());
                logger.info("Album by id = " + id + " successfully updated");
                return true;
        }
        logger.info("Album to update with id = " + id + " not found");
        return false;
    }

    @Override
    public boolean deleteAlbum(long id) {
        boolean result = albums.removeIf(album -> album.getId() == id);
        if (result) {
            System.out.println("The album by id = " + id + " has been removed");
            return true;
        }
        logger.info("The album by id = " + id + " not found and can't be deleted");
        return false;
    }
}
