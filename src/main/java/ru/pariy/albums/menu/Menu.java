package ru.pariy.albums.menu;

import ru.pariy.albums.repository.MemoryAlbumRepository;
import ru.pariy.albums.model.Album;
import ru.pariy.albums.service.AlbumsService;

import java.util.Scanner;

/**
 * Класс, представляющий пользовательский ввод и вывод данных.
 * Взаимодействует с сервисом альбомов.
 */
public class Menu {
    /**
     * Точка входа в приложение. Создает сервис альбомов
     * и обеспечивает взаимодействие с пользователем через консольное меню.
     *
     * @param args Параметры командной строки не используются
     */
    public static void main(String[] args) {
        // Создание сервиса с использованием репозитория в памяти
        AlbumsService service = new AlbumsService(new MemoryAlbumRepository());
        Scanner input = new Scanner(System.in);

        int option;

        do {
            menu();
            option = Integer.parseInt(input.nextLine());
            // Обработка выбора пользователя
            switch (option) {
                // Добавление нового альбома
                case 1:
                    System.out.println("Enter album artist:");
                    String artist = input.nextLine();
                    System.out.println("Enter album name:");
                    String name = input.nextLine();
                    System.out.println("Enter album genre:");
                    String genre = input.nextLine();
                    System.out.println("Enter album released:");
                    String released = input.nextLine();
                    System.out.println("Enter album recorded:");
                    String recorded = input.nextLine();
                    System.out.println("Enter album duration:");
                    String duration = input.nextLine();
                    System.out.println("Enter album country:");
                    String country = input.nextLine();
                    System.out.println("Enter album label:");
                    String label = input.nextLine();
                    System.out.println("Enter album producer:");
                    String producer = input.nextLine();
                    System.out.println("Enter number of tracks on the album:");
                    int tracksNumber = Integer.parseInt(input.nextLine());
                    service.add(new Album(artist, name, genre, released, recorded,
                            duration, country, label, producer, tracksNumber));

                    break;

                // Вывод всех альбомов коллекции
                case 2:
                    System.out.println("Albums collection\n" + "-------------------");
                    service.getAlbums().forEach(System.out::println);

                    break;

                // Вывод отдельного альбома по id
                case 3:
                    System.out.println("Enter album id: ");
                    long id = Long.parseLong(input.nextLine());
                    Album album = service.getAlbum(id);
                    System.out.println("Album\n" + "-------------------\n" + album);

                    break;

                // Обновление альбома по id
                case 4:
                    System.out.println("Enter album id: ");
                    long albumIdForUpdate = Long.parseLong(input.nextLine());
                    if (service.getAlbum(albumIdForUpdate) == null) {
                        System.out.println("Try with another album id");
                        break;
                    }
                    System.out.println("Enter new album artist: ");
                    String artistForUpdate = input.nextLine();
                    System.out.println("Enter new album name: ");
                    String nameForUpdate = input.nextLine();
                    System.out.println("Enter new album genre:");
                    String genreForUpdate = input.nextLine();
                    System.out.println("Enter new album released:");
                    String releasedForUpdate = input.nextLine();
                    System.out.println("Enter new album recorded:");
                    String recordedForUpdate = input.nextLine();
                    System.out.println("Enter new album duration:");
                    String durationForUpdate = input.nextLine();
                    System.out.println("Enter new album country:");
                    String countryForUpdate = input.nextLine();
                    System.out.println("Enter new album label:");
                    String labelForUpdate = input.nextLine();
                    System.out.println("Enter new album producer:");
                    String producerForUpdate = input.nextLine();
                    System.out.println("Enter new number of tracks on the album:");
                    int tracksNumberForUpdate = Integer.parseInt(input.nextLine());

                    Album updateAlbum = new Album(artistForUpdate, nameForUpdate, genreForUpdate, releasedForUpdate,
                            recordedForUpdate, durationForUpdate, countryForUpdate,
                            labelForUpdate, producerForUpdate, tracksNumberForUpdate);
                    updateAlbum.setId(albumIdForUpdate);
                    service.update(albumIdForUpdate, updateAlbum);
                    System.out.println("Updated album\n" + "-------------------\n" + updateAlbum);

                    break;

                // Удаление альбома по id
                case 5:
                    System.out.println("Enter album id: ");
                    long albumIdForDelete = Long.parseLong(input.nextLine());
                    service.delete(albumIdForDelete);

                    break;

                // Завершение программы
                case 0:
                    System.out.println(
                            "\nThe program has ended\n");
                    System.exit(0);

                    break;

                default:
                    // Некорректный ввод пользователя
                    System.out.println("\nInvalid input\n");

                    break;
            }
        }

        while (option != 0);
    }

    /**
     * Текстовое меню с пунктами действий, отображаемое в консоли
     */
    public static void menu() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("1: Add Album");
        System.out.println("2: Get all Albums");
        System.out.println("3: Get Album");
        System.out.println("4: Update Album");
        System.out.println("5: Delete Album");
        System.out.println("0: Exit program");
        System.out.print("Enter your selection: ");
    }
}

