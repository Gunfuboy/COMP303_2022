import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Represents a single Podcast, with at least a name and a host. Each Podcast aggregates episodes.
 */
public class Podcast{

    private String aName;
    private String aHost;

    private List<Episode> aEpisodes = new ArrayList<>();

    /**
     * Creates a Podcast
     * Add your constructor below
     *
     */
    private Podcast(String aName, String aHost) {
        assert aName != null && aHost != null; //I assume that instruction request both title/artist be not null
        this.aName = aName;
        this.aHost = aHost;
    }

    private static final HashMap PODCASTS =
            new HashMap();

    //public getter of the flyweight, avoid user creating duplicated song, will instead take from hashmap
    public static Podcast getPodcast(String aName, String aHost){
        assert aName != null;
        //set to all uppercase for case insensitivity, for the keys
        String aN = aName.toUpperCase();
        String aH = aHost.toUpperCase();


        Podcast p = (Podcast) PODCASTS.get(aN.concat(aH));
        if (p == null){
            p = new Podcast(aName, aHost);
            PODCASTS.put(aN.concat(aH), p);


        }
        return p;
    }

    /**
     * Add one episode to the podcast
     * @param pEpisode to be put into the podcast
     * @pre
     */
    protected void addEpisode(Episode pEpisode) {
        if(!aEpisodes.contains(pEpisode)) {
            aEpisodes.add(pEpisode);
        }
    }

    /**
     * retrieve one episode from the podcast
     * @param pIndex
     *
     */

    public Episode getEpisode(int pIndex) {
       //
        List<Episode> list = new ArrayList<>(aEpisodes);
        return list.get(pIndex);
    }


    public String getName() {
        return aName;
    }

    public String getaHost() {
        return aHost;
    }

    //--------------------Override equals() and hashCode()--------------------//


    @Override
    public boolean equals(Object pObject){
        if (pObject == null){return false;}
        else if (pObject == this) {return true;}
        else if (pObject.getClass() != getClass()){ return false; }
        else
        {
            return ((Podcast) pObject).aName.equalsIgnoreCase(aName)
                    && ((Podcast) pObject).aHost.equalsIgnoreCase(aHost);
        }
    }


    @Override
    public int hashCode() {
        return Objects.hash(aName, aHost);
    }

    public String toString(){
        return (aName + " hosted by " + aHost);
    }
}