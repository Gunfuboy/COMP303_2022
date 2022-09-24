import java.util.ArrayList;

public class RunDrone {

    //Executing what the client has input in the ProgramSequence() method in remoteControl
    public static void main(String[] args){

        remoteControl control = new remoteControl(new ArrayList<Actions>());

        control.programSequence();

    }

}
