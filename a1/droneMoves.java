import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class droneMoves {

    private Actions aAction;
    //private boolean isFocus = false;
    private Drone drone;
    //private boolean isFocus; //boolean tracking if an object is in focus of camera
    public void action(Actions bAction){
        assert bAction != null;
        aAction = bAction;

        switch (aAction) {
            case TakeOff -> takeOff();
            case Land -> land();
            case goForward -> forward();
            case goBackward -> backward();
            case goUp -> up();
            case goDown -> down();

            case Focus -> camera(Actions.Focus);
            case Unfocus -> camera(Actions.Unfocus);
            case CaptureSave -> camera(Actions.CaptureSave);

        }
    }

    //constructor
    public droneMoves(Actions cAction, Drone aDrone){
        aAction = cAction;
        drone = aDrone;

    }




    /*============================== MOVEMENTS ================================================== */

    //WE ASSUME EACH MOVE IS FOR 1 METER, IF WE WISH TO MOVE FOR E.G. 2 METERS, SIMPLY CALL METHOD TWICE

    private void forward() {System.out.println("Drone moving forward by 1m");}

    private void backward() {System.out.println("Drone moving backward by 1m");}

    private void up() {System.out.println("Drone moving up by 1m");}

    private void down() {System.out.println("Drone moving down by 1m");}
    /* ======================================================================================== */

    /*============================== TAKE-OFF, LAND, AND TAKE PICTURE ================================================== */


    private void takeOff(){System.out.println("Taking Off");}

    private void land(){
        System.out.println("Landing");
    }

    private void camera(Actions a) {

        assert a == Actions.Focus || a == Actions.Unfocus || a == Actions.CaptureSave;
        aAction = a;
        switch (aAction) {
            case Focus -> {
                if (!drone.getFocused()) {
                    drone.changeFocus();
                    System.out.println("Focusing on object...");
                    System.out.println("Object is now focused, can proceed to capture");
                } else {
                    System.out.println("Focusing on object...");
                    System.out.println("an object is already in focus, proceed to capture or un-focus object");
                }

            }
            case Unfocus -> {
                if (drone.getFocused()) {
                    drone.changeFocus();
                    System.out.println("De-focusing...");
                    System.out.println("Object is now un-focused");
                } else {
                    System.out.println("De-focusing...");
                    System.out.println("There is no object in focus");
                }
            }
            case CaptureSave -> {
                if(drone.getFocused()){
                    capture();
                }else{
                    System.out.println("Drone must focus on an object before taking picture!");
                }
            }
        }
    }

    //Here, we presume that photo is saved directly after capturing
    //Scanner program and how to use it found at : https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
    private void capture() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter picture name:");
        String pName = sc.nextLine();
        while (true) {
            System.out.println("Enter picture type (jpg,png,pdf,raw):");
            String pType = sc.nextLine();

            if (pType.equals("jpg") || pType.equals("png") || pType.equals("pdf") || pType.equals("raw")) {
                System.out.println("Picture saved as " + pName + "." + pType);
                break;
            }else {
                System.out.println("Invalid picture type. Try again");
            }
        }
    }



}




