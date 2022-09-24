import java.util.ArrayList;

/**
 * Represents an Audio library, with individual Song titles, Podcasts and playlists.
 */
public class Library {

    //** SINGLETON DESIGN PATTERN WILL BE USED TO ENSURE ONE INSTACE OF LIBRARY AT ANY TIME **//
    /** TODO 1. private constructor
     *        2. global variable
     *        3. accessor method (instance())
     */

    /**
     * Adds your design of fields for Library
     */

     //Library name and description
    private String name;
     private String description;

     //List of songs, podcasts and playlists in the library
     private ArrayList<Song> songs = new ArrayList<>();
     private ArrayList<Podcast> podcasts = new ArrayList<>();
     private ArrayList<PlayList> playLists = new ArrayList<>();
     private ArrayList<Episode> episodes = new ArrayList<>();

     //---------------SINGLETON IMPLEMENTATION-------------------------//
    /**
     * GLOBAL VARIABLE storing the instance
     */
    private static final Library INSTANCE = new Library();

    /**
     * PRIVATE CONSTRUCTOR
     */
    private Library() {}

    /**
     * ACCESSOR ref to the instance
     * @return global variable referring to instance
     */
    public static Library instance() {return INSTANCE;}

    //-------------------------------------------------------------//

    /**
     * initialize name and description. Description could be null
     * @param n name of library
     *        d description of library
     */
    public void addName(String n){
        assert n != null;
        this.name = n;
    }
    public void addDescription(String d){this.description = d;}


    /**
     * getters for name and description, songs, podcasts, and playlists
     * @return name, description, songs, podcasts, playlists of library
     */
    public String getName() {return name;}
    public String getDescription() {return description;}
    //shallow copy for getters for simplicity's sake as all objects in respective classes are primitive/immutable
    public ArrayList<Song> getSongs() {return new ArrayList<>(songs);}
    public ArrayList<PlayList> getPlayLists() {return new ArrayList<>(playLists);}
    public ArrayList<Podcast> getPodcasts() {return new ArrayList<>(podcasts);}
    public ArrayList<Episode> getEpisodes() {return new ArrayList<>(episodes);}



    /**
     * Adds a Song to the library. Duplicate Songs aren't added twice.
     *
     * @param pSong the Song to add
     */
    public void addSong(Song pSong) {
        // Please add you implementation here

        boolean duplicate = false;
        //check for duplicate
        for (Song s : this.songs){
            if (s.equals(pSong)) { duplicate = true; }
        }
        if (!duplicate){
            this.songs.add(pSong);
        }else{
            System.out.println("Song "+ pSong.toString()+ " is already in library, cannot add again.");
        }


    }

    /**
     * Adds a PlayList to the library. All Songs from the list are also added as individual Songs to the library.
     *
     * @param pList
     *            the PlayList to add
     * @pre pList!=null;
     */
    public void addPlayList(PlayList pList) {
       // Please add you implementation here
        if(getPlayLists().size()==0){
            playLists.add(pList);
        }else {
            for (PlayList p : getPlayLists()) {
                if (p.pCompare(pList)) {
                    playLists.add(pList);
                    for (Playable m : pList.getaList()) {
                        if (m.getClass() == Song.class) songs.add((Song) m);
                    }
                } else System.out.println("Playlist " + pList + " is a duplicate. Cannot be added.");
            }
        }
    }



    /**
     * Adds a Podcast to the library. All Episodes from the list are also added as individual episodes to the library.
     *
     * @param pPodcast
     *            the Podcast to add
     * @pre pPodcast!=null;
     */
    public void addPodcast(Podcast pPodcast) {
        // Please add you implementation here

        boolean duplicate = false;
        //check for duplicate
        for (Podcast p : this.podcasts){
            if (p.equals(pPodcast)) { duplicate = true; }
        }

        if (!duplicate){
            this.podcasts.add(pPodcast);
        }else{
            System.out.println("Podcast "+ pPodcast.toString()+ " is already in library, cannot add again.");
        }

    }

}
