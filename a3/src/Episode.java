/**
 * Represents a single episode, with at least a title, and an episode number.
 */
public class Episode implements Playable {

    private final Podcast aPodcast;
    private final String aTitle;
    private final int aEpisodeNumber;

    /**
     * Creates an episode
     *
     * @param pPodcast
     *            Podcast that this episode is a part of
     * @param pTitle
     *            title of the episode
     * @param pEpisodeNumber
     *            the episode number that identifies the episode
     * @pre   pPodcast != null && pTitle!=null
     * @throws IllegalArgumentException
     */
    Episode(Podcast pPodcast, String pTitle, int pEpisodeNumber) {
        assert (pPodcast != null) && (pTitle != null);
        aPodcast = pPodcast;
        aTitle = pTitle;
        aEpisodeNumber = pEpisodeNumber;
        aPodcast.addEpisode(this);
    }


    public Podcast getaPodcast() {
        return aPodcast;
    }

    public String getaTitle() {
        return aTitle;
    }

    public int getaEpisodeNumber() {
        return aEpisodeNumber;
    }

    @Override
    public void play() {
        System.out.println("Now playing " + aPodcast.getName() + " [" + aEpisodeNumber + "]: " + aTitle);
    }

}
