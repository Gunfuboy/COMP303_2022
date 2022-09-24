import java.util.*;

/**
 * Represents a sequence of playables to play in FIFO order.
 */
public class PlayList implements Playable, Cloneable {

    //the playlist itself
    private List<Playable> aList = new LinkedList<>();

    //copy of the playlist before shuffling
    List<Playable> OGList = new LinkedList<>(aList);

    //name of playlist
    private String aName;

    //copy of playlist name for undo
    String undoName;


    //keeping track of the commands
    private Stack<Command> commands =  new Stack<>();

    //keeping track of undone commands for redo
    private Stack<Command> undoneCommands = new Stack<>();

    //keeping track of the most recent command for redo()
    private Command lastCommand = null;

    //keeping track of removed playable for removePlayable in case of undo()
    private Playable removed;
    

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
     * remove a playable from the Playlist given its index
     * @param pIndex
     *          the index of playable to be removed
     * @return the removed playable
     */



    public Playable removePlayable(int pIndex) {
        assert pIndex >= 0 && pIndex < aList.size();


        return aList.remove(pIndex);
    }

    /**
     * @return The name of the playlist.
     */
    public String getName() {
        return aName;
    }

    public List<Playable> getList() {  return aList; }

    public Stack<Command> getCommands() {
        return commands;
    }

    public Stack<Command> getUndoneCommands() {
        return undoneCommands;
    }

    /**
     * modify the name of the playlist
     * @param pName
     *          the new name of the playlist
     */
    public void setName(String pName) {
        assert pName != null;

        this.aName = pName;
    }

    /**
     * change the order how playlist play the playables it contains
     */
    public void shuffle() {
        Collections.shuffle(aList);
    }

    //create command method for AddPlayable()
    public Command addPlayableCommand(Playable pPlayable) {


        Command addPlayable = new Command() {

            Playable aPlayed = pPlayable;


            public void execute() {
                addPlayable(pPlayable);
                lastCommand = addPlayableCommand(pPlayable);
                commands.push(addPlayableCommand(pPlayable));
            }

            public void undo() {
                removePlayable(aList.size() - 1);
            }

        };



        return addPlayable;

    }




    //create command method for removePlayable()
    public Command removePlayableCommand(int pIndex) {

        Command removePlayable = new Command() {




            public void execute() {

                OGList.clear();
                for (Playable p: aList){
                    OGList.add(p);
                }

                removePlayable(pIndex);
                lastCommand = removePlayableCommand(pIndex);
                commands.push(removePlayableCommand(pIndex));
            }

            public void undo() {
               aList.add(pIndex,OGList.get(pIndex));
            }


        };


        return removePlayable;

    }

    //create command method for shuffle()
    public Command shuffleCommand() {

         Command shuffle = new Command() {


            public void execute() {
                //update backup before shuffling in case of undo()
                OGList.clear();
                for (Playable p: aList){
                    OGList.add(p);
                }

                shuffle();
                lastCommand = shuffleCommand();
                commands.push(shuffleCommand());
            }


            public void undo() {
                aList = OGList;
            }

        };


         return shuffle;

    }

    //create command method for setName()
    public Command setNameCommand(String pName) {


        Command setName =  new Command() {



            public void execute() {
                undoName = getName();
                setName(pName);
                lastCommand = setNameCommand(pName);
                commands.push(setNameCommand(pName));
            }

            public void undo() {
                aName = undoName;
            }

        };

        return setName;

    }



    /**
     * undo method, revert to state before last state-modifying method
     * uses undo from Command methods
     */
    public void undo(){

        if(!commands.empty()) {
            Command c = commands.pop();
            c.undo();
            undoneCommands.push(c);
            lastCommand = null;
        }
    }

    public void redo(){
        if (lastCommand != null) {
            lastCommand.execute();
            lastCommand = null;
        }else if(undoneCommands.empty()){
            return;
        }else{
            Command c = undoneCommands.pop();
            c.execute();
            lastCommand = null;

        }
    }







    /**
     * Iterating through the playlist to play playable content.
     */
    @Override
    public void play() {
        for(Playable playable:aList){
            playable.play();
        }
    }

    /**
     * Checks is two playlists are equal based on playable objects and their order
     *
     * @param o
     *            The object to compare a playlist to
     * @return    This method returns true if the playlist is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayList playList = (PlayList) o;
        return this.aList.equals(playList.aList);
    }

    /**
     * Equal playlists have the same hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(aList);
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
