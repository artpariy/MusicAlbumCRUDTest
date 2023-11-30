package ru.pariy.albums.repository;

import ru.pariy.albums.model.Album;

import java.util.List;

/**
 * Интерфейс, представляющий репозиторий альбомов.
 */
public interface AlbumRepository {
    /**
     * Получает все альбомы из репозитория.
     * @return Список всех альбомов. Если репозиторий пуст, возвращается пустой список.
     */
    List<Album> getAllAlbums();

    /**
     * Получает альбом по его идентификатору из репозитория.
     * @param id Идентификатор альбома для получения.
     * @return Альбом с указанным id, если альбом не найден то возвращается null.
     */
    Album getAlbumById(long id);

    /**
     * Добавляет новый альбом в репозиторий.
     * @param album Альбом для добавления. Не должен быть null
     */
    void addAlbum(Album album);

    /**
     *
     * @param id Идентификатор альбома для обновления.
     * @param album Альбом для обновления.
     * @return Возвращает true в случае успешного обновления,
     * false в случае, если альбом с указанным id не найден.
     */
    boolean updateAlbum(long id, Album album);

    /**
     *
     * @param id Идентификатор альбома для удаления.
     * @return Возвращает true в случае успешного удаления,
     * false в случае, если альбом с id не найден
     */
    boolean deleteAlbum(long id);

}

