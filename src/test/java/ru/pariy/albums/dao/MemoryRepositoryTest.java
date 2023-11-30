package ru.pariy.albums.dao;

import org.junit.Before;
import org.junit.Test;
import ru.pariy.albums.model.Album;
import ru.pariy.albums.repository.AlbumRepository;
import ru.pariy.albums.repository.MemoryAlbumRepository;

import java.util.List;

import static org.junit.Assert.*;

public class MemoryRepositoryTest {

    private AlbumRepository albumRepository;

    @Before
    public void setUp() {

        albumRepository = new MemoryAlbumRepository();

        long nextId = 1;
        for (int i = 1; i <= 10; i++) {
            Album album = new Album("Test Artist" + i, "Test Album" + i,
                    "Test Genre" + i, "2023-01-01", "2022-01-01",
                    "30:00", "Test Country" + i, "Test Label" + i,
                    "Test Producer" + i, 10 + i);
            album.setId(nextId++);
            albumRepository.addAlbum(album);
        }
    }

    @Test
    public void whenOneAlbumIsAddedTheSizeWillIncreaseBy1() {
        Album album = new Album("Test Artist11", "Test Album11",
                "Test Genre11", "2023-01-01", "2022-01-01",
                "30:00", "Test Country11", "Test Label11",
                "Test Producer11", 21);
        album.setId(11);
        albumRepository.addAlbum(album);
        List<Album> result = albumRepository.getAllAlbums();
        assertEquals(11, result.size());
    }

    @Test
    public void getAllAlbumsFromNotEmptyList() {
        List<Album> result = albumRepository.getAllAlbums();
        assertFalse(result.isEmpty());
    }

    @Test
    public void getAllAlbumsFromEmptyList() {
        AlbumRepository albumRepository = new MemoryAlbumRepository();
        assertTrue(albumRepository.getAllAlbums().isEmpty());
    }

    @Test
    public void getAlbumByIdWillFound() {
        assertNotNull(albumRepository.getAlbumById(1));
    }

    @Test
    public void getAlbumByIdWillNotFound() {
        assertNull(albumRepository.getAlbumById(199));
    }

    @Test
    public void theAlbumWillBeUpdated() {
        Album updatedAlbum = new Album("Test Artist50", "Test Album50",
                "Test Genre50", "2023-01-01", "2022-01-01",
                "30:00", "Test Country50", "Test Label50",
                "Test Producer50", 100);
        assertTrue(albumRepository.updateAlbum(5, updatedAlbum));
        Album result = albumRepository.getAlbumById(5);
        assertEquals(updatedAlbum.getArtist(), result.getArtist());
        assertEquals(updatedAlbum.getName(), result.getName());
        assertEquals(updatedAlbum.getGenre(), result.getGenre());
    }

    @Test
    public void theAlbumBeingUpdatedWasNotFoundById() {
        Album updatedAlbum = new Album("Test Artist50", "Test Album50",
                "Test Genre50", "2023-01-01", "2022-01-01",
                "30:00", "Test Country50", "Test Label50",
                "Test Producer50", 100);
        assertFalse(albumRepository.updateAlbum(199, updatedAlbum));
    }

    @Test
    public void theAlbumWillBeDeleted() {
        albumRepository.deleteAlbum(11);
        List<Album> result = albumRepository.getAllAlbums();
        assertEquals(10, result.size());
    }

    @Test
    public void theAlbumToBeDeletedWasNotFoundById() {
        assertFalse(albumRepository.deleteAlbum(199));
    }

}