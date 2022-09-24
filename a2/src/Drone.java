
public class Drone implements Movement {

    final private String name;
    private Direction direction;
    private double distance;
    private Speed speed;
    private Format format;
    private Boolean isRecorded = false; //Assume we do not want to record in the beginning



    /**
     * Constructor
     * @param name of the drone
     */
    public Drone(String name) {
        this.name = name;
    }

    /**
     * Name getter
     * @return drone name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Drone info getters
     * @return current movement direction, distance (m), speed, and saved video format if recording
     */

    private Direction getDirection() {return direction;}
    private double getDistance() {return distance;}
    private Speed getSpeed() {return speed;}
    private Format getFormat() {return format;}

    @Override
    public boolean isRecorded() {return isRecorded;}

    @Override
    public boolean isEmpty(){
        return getDirection() == null || getDistance() == 0.0 || getSpeed() == null;
    }

    /**
     * get all info on current drone's movement
     */
    public void getInfo(){
        if (isEmpty()){
            System.out.println("There is no current movement set up.");
        }else {
            System.out.println("Current movement is: going " + getDirection() + " at " + getSpeed() + " for " + getDistance() + "m.");
        }

        if (isRecorded()){
            System.out.println("Video will save as " + getFormat() + " file.");
        }

    }



    @Override
    public void setMovement(Direction d, double dist, Speed s) {
        if (dist < 0.0) {
            System.out.println("Distance must be positive and non null");
        } else {
            direction = d;
            distance = dist;
            speed = s;
        }
    }

    //helper to reset all info
    private void reset(){direction = null;distance = 0.0; speed = null; format = null; isRecorded = false;}

    @Override
    public void execute(){
        if (direction == null || distance == 0.0 || speed == null) {
            System.out.println("No movement to execute. Please set movements before executing.");
        }else {
            System.out.println("Executing...");
            System.out.println("Moved " + getDirection() + " " + getDistance() + "m " + "at " + getSpeed() + " speed");
            if (isRecorded) {
                System.out.println("Movement recorded. Video saved as " + getFormat() + " file.");
            }
            reset(); //reset the info after running. We assume that a movement can only be running once.
        }
    }

    public void record(Format f) {
        isRecorded = true;
        format = f;
        System.out.println("Next movement execution will be recorded and saved as " + getFormat() + " file.");
    }
    //======================================TRICK OPERATOR================================================
    /**
     * execute a trick
     * @param trick name of the trick
     * @param record client decide if we want to record this trick or not.
     */
    public void doTrick( Trick trick, boolean record){
        trick.execute();
        if(record){trick.record();}
    }






}
