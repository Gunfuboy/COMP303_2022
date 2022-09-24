public interface Movement {
    /**
     * Execute a drone movement
     */
    void execute() ;

    /**
     * Specify the direction, speed, and distance of movement
     */
    void setMovement(Direction d, double dist, Speed s);

    /**
     * @return True if movement is recorded.
     */
    boolean isRecorded();

    /**
     * @return True if at least one movement info is not set up (null)
     */
    boolean isEmpty();


}
