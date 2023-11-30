package ru.pariy.albums.model;

/**
 * Класс, представляющий музыкальный альбом
 */
public class Album {
    private long id;
    private String artist;
    private String name;
    private String genre;
    private String released;
    private String recorded;
    private String duration;
    private String country;
    private String label;
    private String producer;
    private int tracksNumber;

    /**
     * Конструктор класса. Создает объект альбома с указанными параметрами.
     *
     * @param artist      Исполнитель альбома.
     * @param name        Название альбома.
     * @param genre       Жанр альбома.
     * @param released    Дата выпуска альбома.
     * @param recorded    Дата записи альбома.
     * @param duration    Продолжительность альбома.
     * @param country     Страна происхождения альбома.
     * @param label       Лейбл альбома.
     * @param producer    Продюсер альбома.
     * @param tracksNumber Количество треков на альбоме.
     */
    public Album(String artist, String name,
                 String genre,
                 String released, String recorded,
                 String duration, String country, String label,
                 String producer, int tracksNumber) {
        this.artist = artist;
        this.name = name;
        this.genre = genre;
        this.released = released;
        this.recorded = recorded;
        this.duration = duration;
        this.country = country;
        this.label = label;
        this.producer = producer;
        this.tracksNumber = tracksNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRecorded() {
        return recorded;
    }

    public void setRecorded(String recorded) {
        this.recorded = recorded;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getTracksNumber() {
        return tracksNumber;
    }

    public void setTracksNumber(int tracksNumber) {
        this.tracksNumber = tracksNumber;
    }



    @Override
    public String toString() {
        return  "id=" + id + "\n" +
                "artist='" + artist + '\'' + "\n" +
                "name='" + name + '\'' + "\n" +
                "genre='" + genre + '\'' + "\n" +
                "released='" + released + '\'' + "\n" +
                "recorded='" + recorded + '\'' + "\n" +
                "duration='" + duration + '\'' + "\n" +
                "country='" + country + '\'' + "\n" +
                "label='" + label + '\'' + "\n" +
                "producer='" + producer + '\'' + "\n" +
                "tracksNumber=" + tracksNumber + "\n" +
                "-------------------";
    }
}
