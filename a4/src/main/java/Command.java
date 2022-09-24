public interface Command {

    //defining commands as objects

    /**
     * execute the command
     */
    void execute();


    /**
     * undo the last state changing command
     */
    void undo();



}
