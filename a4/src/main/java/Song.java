import java.util.*;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable, Cloneable {

    private final String aTitle;
    private final String aArtist;

    /**
     * Creates a new Song.
     *
     * @param pTitle
     *            the title of the song
     * @param pArtist
     *            the artist of the song
     * @pre pTitle!=null && pArtist!=null;
     */
    public Song(String pTitle, String pArtist)
    {
        assert  pTitle!=null && pArtist!=null;
        aTitle=pTitle;
        aArtist=pArtist;
    }

    /**
     * @return The title of the song.
     */
    public String getTitle() {
        return aTitle;
    }

    /**
     * @return The artist of the song.
     */
    public String getArtist() {
        return aArtist;
    }

    @Override
    public void play() {
        // Just a stub.
        System.out.println("Now playing " + aTitle);
    }

    /**
     * Checks is two songs are equal based on song title and artist
     *
     * @param o
     *            The object to compare a song to
     * @return    This method returns true if the song is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return aTitle.equalsIgnoreCase(song.aTitle) && aArtist.equalsIgnoreCase(song.aArtist);
    }

    /**
     * Equal songs have the same hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(aTitle, aArtist);
    }


    @Override
    public String toString(){
        return (aTitle + " by " + aArtist);
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

}