import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    PlayList p1 = new PlayList("sample");
    Song s1 = new Song("Palette","IU");
    Song s2 = new Song("Baby", "Justin Bieber");
    Song s3 = new Song("Firework", "Katy Perry");

    Command addS1 = p1.addPlayableCommand(s1);
    Command addS2 = p1.addPlayableCommand(s2);
    Command addS3 = p1.addPlayableCommand(s3);

    Command remove0 = p1.removePlayableCommand(0);


    @Test
    void undo() {
        addS1.execute();
        addS2.execute();
        addS3.execute();

        p1.undo();
        p1.undo();

        remove0.execute();


        p1.undo();

        Command setName = p1.setNameCommand("not sample");
        setName.execute();
        p1.undo();

        assertAll(
                ()-> assertEquals("[Palette by IU]", p1.getList().toString()),
                () -> assertEquals("sample",p1.getName())
        );



    }

    @Test
    void redo() {

        addS1.execute();
        addS2.execute();
        addS3.execute();

        p1.undo();
        p1.undo();

        p1.redo();
        p1.redo();

        addS1.execute();
        p1.redo();

        assertEquals("[Palette by IU, Baby by Justin Bieber, Firework by Katy Perry, Palette by IU, Palette by IU]", p1.getList().toString());
    }


}