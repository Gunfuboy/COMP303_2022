import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Represents a single Song, with at least a title, and an artist name.
 */
public class Song implements Playable{

    private final String aTitle;
    private final String aArtist;



    /**
     * Creates a Song.
     * Add your constructor here
     */

    //----IMPLEMENTING THE FLYWEIGHT DESIGN PATTERN --- //
    /**
     * TODO 1. Private constructor
     *      2. static flyweight store
     *      3. access method
     */

    /**
     * Constructor
     * @param aTitle title of the song
     * @param aArtist name of the artist
     * @pre aTitle and aArtist != null
     */

    private Song(String aTitle, String aArtist) {
            assert aTitle != null && aArtist != null; //I assume that instruction request both title/artist be not null
            this.aTitle = aTitle;
            this.aArtist = aArtist;
    }

    private static final HashMap SONGS =
            new HashMap();

    //public getter of the flyweight, avoid user creating duplicated song, will instead take from hashmap
    public static Song getSong(String aTitle, String aArtist){

        //set to all uppercase for case insensitivity
        String aT = aTitle.toUpperCase();
        String aA = aArtist.toUpperCase();
        assert aTitle != null;

        Song s = (Song) SONGS.get(aT.concat(aA));
        if (s == null){
            s = new Song(aTitle, aArtist);
            SONGS.put(aT.concat(aA), s);



        }
        return s;
    }







    //--------------------OVERRIDE EQUALS AND HASHCODE--------------------------//

    @Override
    public boolean equals(Object pObject){
        if (pObject == null){return false;}
        else if (pObject == this) {return true;}
        else if (pObject.getClass() != getClass()){ return false; }
        else
        {
            return ((Song) pObject).aTitle.equalsIgnoreCase(aTitle)
                    && ((Song) pObject).aArtist.equalsIgnoreCase(aArtist);
        }
    }

    @Override
    public int hashCode() {
        return hash(aTitle, aArtist);
    }

    //EQUIVALENT TO THIS
//
//        @Override
//    //equal instances always produce the same hashcode
//    //equal hashcode do not mean equal instances
//    public int hashCode(){
//        int hash = 7; //prime non zero number
//        hash = 31 * hash + Objects.hashCode(this.aArtist);
//        hash = 31 * hash + Objects.hashCode(this.aTitle);
//        return hash;
//
//    }



    //------------------------------------------------------------//


    public void play() {
        // Just a stub.
        // We don't expect you to implement an actual music player!
        System.out.println("Now playing " + aTitle);
    }

    //Override toString for better printout in Main
    @Override
    public String toString(){
        return (aTitle + " by " + aArtist);

    }

}