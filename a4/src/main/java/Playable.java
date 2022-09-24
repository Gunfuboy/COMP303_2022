/**
 * Represents an audio object that can be played
 */
interface Playable extends Cloneable{

    /**
     * Plays the audio to the user
     */
    void play();

    Object clone();


}