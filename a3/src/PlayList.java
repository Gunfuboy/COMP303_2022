import java.util.LinkedList;
import java.util.List;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable {

    private final List<Playable> aList = new LinkedList<>();
    private String aName;
    private int aNext;

    /**
     * Creates a new empty playlist.
     *
     * @param pName
     *            the name of the list
     * @pre pName!=null;
     */
    public PlayList(String pName) {
        assert pName != null;
        aName = pName;
        aNext = 0;
    }

    public String toString(){
        return aName;
    }
    //getter for playlist aList, shallow copy
    public List<Playable> getaList() {
        return new LinkedList<>(aList);
    }

    /**
     * Adds a playable at the end of this playlist.
     *
     * @param pPlayable
     *            the content to add to the list
     * @pre pPlayable!=null;
     */
    public void addPlayable(Playable pPlayable) {
        assert pPlayable != null;
        aList.add(pPlayable);
    }
    /**
     * pseudo .equals() method.
     * Compare current playlist with another. Same if playlists aggregate the same playable objects in the same order
     * @param pPlaylist  playlist to compare
     * @return true if same, false otherwise
     */
    public boolean pCompare(PlayList pPlaylist){

        if (aList.size() != pPlaylist.aList.size()) return false;

        for (Playable p: this.aList){
            for (Playable m: pPlaylist.aList){
                if (p.getClass() != m.getClass() || !p.equals(m)) return false;
            }
        }

        return true;
    }


    @Override
    public void play() {
        for (Playable p : aList){
            p.play();
        }
    }
}
