import java.util.*;

public class Trick implements Movement{

    private final Tricks trick;

    private final ArrayList<Direction> directions = new ArrayList<>();
    private final ArrayList<Double> distances = new ArrayList<>();
    private final ArrayList<Speed> speeds = new ArrayList<>();
    private Format format;
    private Boolean isRecorded = false; //Assume we do not want to record in the beginning


    /**
     * Constructor
     * @param t is name of trick
     */
    public Trick(Tricks t) {this.trick = t; set(t);}

    /**
     * Getters for movements in trick, using iterators to not directly access our arraylist.
     * @return lists of directions, distance, speed.
     */
    public Iterator<Direction> getDirections() {
        return this.directions.iterator();}
    public Iterator<Double> getDistances() {
        return this.distances.iterator();}
    public Iterator<Speed> getSpeeds() {
        return this.speeds.iterator();}
    public Format getFormat() {return format;}

    @Override
    public boolean isRecorded() {return isRecorded;}

    /**
     * Trick Getter
     * @return current trick name
     */
    public Tricks getTrick() {
        return trick;
    }

    @Override
    public void execute() {

        System.out.println("Executing a " + getTrick() + " maneuver :");

        Iterator<Direction> direction = getDirections(); Iterator<Double> distance = getDistances(); Iterator<Speed> speed = getSpeeds();
        while(direction.hasNext()){
            System.out.println("Going " + direction.next() + " at " + speed.next() + " speed for " + distance.next() + "m.");
        }


    }

    //add movement into list
    @Override
    public void setMovement(Direction d, double dist, Speed s) {
        directions.add(d); distances.add(dist); speeds.add(s);
    }


    @Override
    public boolean isEmpty() {
        return getDirections() == null || getDistances() == null || getSpeeds() == null;
    }


    public void record() {
        List<String> format = Arrays.asList("MP4", "MOV", "WMV", "AVI", "FLV", "MKV");
        isRecorded = true;
        Scanner sc= new Scanner(System.in);
        System.out.println("Recording on for trick "+ getTrick());
        while (true) {
            System.out.println( "Enter save video format(MP4,MOV,WMV,AVI,FLV,MKV):");
            String f = sc.nextLine();
            if(format.contains(f.toUpperCase())){
                this.format = Format.valueOf(f.toUpperCase());
                System.out.println("Trick saved as " + getFormat() + " file.");
                break;
            }else {
                System.out.println("ERROR: Invalid video format");
            }

        }
    }

    /**
     * Adding correct moves for our trick
     * @param trick that we wish to set up
     */
    private void set(Tricks trick){
        switch (trick) {
            case TakeOff -> takeOff();
            case Land -> land();
            case Pucker -> pucker();
        }
    }

    //For our design, we assume that a trick has a preset distance for each movement in order to execute the trick well.

    private void takeOff(){
        setMovement(Direction.UP, 3.0, Speed.LOW );
        setMovement(Direction.UP, 4.0, Speed.MODERATE);
    }

    //I assume the movement said in instruction is correct.
    //Preset fast pucker
    private void pucker(){
        setMovement(Direction.UP, 3.0, Speed.MODERATE);
        setMovement(Direction.LEFT, 1.0, Speed.HIGH);
        setMovement(Direction.LEFT, 1.0, Speed.HIGH);
        setMovement(Direction.LEFT, 1.0, Speed.HIGH);
        setMovement(Direction.LEFT, 1.0, Speed.HIGH);
        setMovement(Direction.DOWN, 3.0, Speed.MODERATE);
    }

    //I assume a land trick would simply be reverse of a takeOff trick
    private void land(){
        setMovement(Direction.DOWN, 3.0, Speed.MODERATE );
        setMovement(Direction.DOWN, 4.0, Speed.LOW);

    }
}
