import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        // TASK: Write runner code to show your work

        //INSTANTIATE
        Library l1 = Library.instance();
        Library l2 = Library.instance();



        System.out.println("-------------------------TEST 1---------------------------------");
        System.out.println("Testing if instantiating two libraries will output only one object");
        System.out.println("hashcode of library instance l1 is:" + l1.hashCode());
        System.out.println("hashcode of library instance l2 is:" + l2.hashCode());
        System.out.println("Comparing both yields us: " + (l1 == l2));

        System.out.println("-------------------------TEST 2---------------------------------");
        System.out.println("Testing adding duplicate songs and podcasts (with case insensitivity test)");
        Song s1 = Song.getSong("Palette", "IU");
        Song s2 = Song.getSong("PalettE", "IU");
        Song s3 = Song.getSong("Good Day", "IU");
        System.out.println("Adding same two songs with difference capital letters...");
        l1.addSong(s1);
        l1.addSong(s2);
        System.out.println("Adding a second different song but same artist to limit test comparison...");
        l2.addSong(s3);
        System.out.println("Current songs in library are: " + l1.getSongs());
        System.out.println(" ");
        Podcast p1 = Podcast.getPodcast("With Elon Musk", "Joe Rogan");
        Podcast p2 = Podcast.getPodcast("With EloN Musk", "joe rOgan");
        Podcast p3 = Podcast.getPodcast("With Elton John", "Joe Rogan");
        Episode e1 = new Episode(p1,"wtf", 1);
        p1.addEpisode(e1);
        System.out.println("Adding same two podcasts with difference capital letters...");
        l1.addPodcast(p1); l1.addPodcast(p2);
        System.out.println("Adding a second different podcast...");
        l1.addPodcast(p3);
        System.out.println("Current podcasts in library are: "+ l2.getPodcasts());

        System.out.println("-------------------------TEST 3---------------------------------");
        System.out.println("Testing adding playlists and identical playlist test");
        System.out.println("Generating playlists...");
        //l1 = l2.
        PlayList list1 = new PlayList("dlwrma");
        PlayList list2 = new PlayList("dlwrma2");
        PlayList list3 = new PlayList("2001");
        list1.addPlayable(s1);list1.addPlayable(s3);
        list2.addPlayable(s1);list2.addPlayable(s3);
        list3.addPlayable(e1);list3.addPlayable(s2);
        l1.addPlayList(list1);
        l1.addPlayList(list2);
        l1.addPlayList(list3);
        System.out.println(l1.getPlayLists());
    }
}
