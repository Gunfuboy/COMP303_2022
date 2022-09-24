
import java.util.ArrayList;

public class remoteControl  {

    //Some cool methods I found that makes the warning go red.
    //Source: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    //main sequence of move
    private ArrayList<Actions> moves;
    //constructor
    public remoteControl(ArrayList<Actions> aMove){ moves = aMove; }

    //MAIN METHOD THAT ALLOWS USER TO INPUT SEQUENCE. THIS IS BASICALLY THE CLIENT INTERFACE WHERE
    //CLIENT CAN INPUT COMMANDS.
    public void programSequence(){
        System.out.println("================== DRONE RUN #1: TAKE OFF THEN LAND ==================");
        addMove(Actions.TakeOff);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("================== DRONE RUN #2: ADDING MOVEMENTS ==================");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.goForward);
        addMove(Actions.goUp);
        addMove(Actions.goBackward);
        addMove(Actions.goDown);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("=============== DRONE RUN #2: TESTING NO TAKE-OFF/LAND ===============");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.goForward);
        addMove(Actions.goUp);
        addMove(Actions.goBackward);
        addMove(Actions.goDown);
        //addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("=============== DRONE RUN #3: TESTING TAKE-OFF, LAND THEN ACTION ===============");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.goForward);
        addMove(Actions.goUp);
        addMove(Actions.Land);
        addMove(Actions.goBackward);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("=============== DRONE RUN #4: TESTING TAKE-OFF, LAND THEN TAKE-OFF AGAIN ===============");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.goForward);
        addMove(Actions.goUp);
        addMove(Actions.Land);
        addMove(Actions.TakeOff);
        addMove(Actions.goBackward);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("=============== DRONE RUN #5: TESTING SIMPLE PICTURE CAPTURE ===============");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.Unfocus);
        addMove(Actions.Focus);
        addMove(Actions.CaptureSave);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

        System.out.println("=============== DRONE RUN #6: TESTING PICTURE CAPTURE WITHOUT FOCUS ===============");
        System.out.println("Resetting sequence...");
        reset();
        System.out.println("Adding new sequence...");
        addMove(Actions.TakeOff);
        addMove(Actions.Unfocus);
        addMove(Actions.CaptureSave);
        addMove(Actions.Land);
        System.out.print("Current sequence is: ");
        getMoves();
        System.out.println("Executing...");
        execute();

    }

    private void addMove(Actions a){ moves.add(a); } // add a move to the sequence

    private void reset(){ moves.clear(); } //clear the sequence

    //execution method. Client can either call it in programSequence or test is independently using RunDrone class.
    public void execute() {

        //checking if every move is executable depending if on ground or no.
        Drone aDrone = new Drone();
        for (Actions i : moves) {
            droneMoves e = new droneMoves(i, aDrone);
            if (aDrone.getGrounded()){
                if (i == Actions.TakeOff) {
                    aDrone.changeGrounded(false);
                    e.action(i);
                } else if (i != Actions.TakeOff){
                    System.out.println(ANSI_RED + "ERROR: ACTION " + i + " CANNOT BE EXECUTED AS DRONE HAS LANDED" + ANSI_RESET);
                }
            } else {
                if (i == Actions.Land){
                    aDrone.changeGrounded(true);
                }
                e. action(i);
            }
        }
        if (!aDrone.getGrounded()) {
            System.out.println(ANSI_RED + "ERROR: INVALID SEQUENCE. MUST END WITH DRONE LANDING" + ANSI_RESET );
        }

    }

    //Let client access all the moves in the pre-programmed sequence
    private ArrayList<Actions> getMoves() {
        ArrayList<Actions> copy = new ArrayList<Actions>();

        for (int i = 0; i < moves.size(); i++){
            copy.add(moves.get(i));
        }

        System.out.println(copy);

        return copy;
    }





}


