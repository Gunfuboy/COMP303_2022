public class Drone {

    //drone characteristic knowing if drone camera is focusing on an object or not.
    private boolean isFocused = false;

    private boolean isGrounded = true;


    //getter and changer for isFocused
    public boolean getFocused() {
        return isFocused;
    }
    public void changeFocus(){
        this.isFocused = !isFocused;
    }

    //getter and changer for isGrounded
    public boolean getGrounded() { return isGrounded; }
    public void changeGrounded(boolean bool){ this.isGrounded = bool;}
}
