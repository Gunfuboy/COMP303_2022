public class Main {
    public static void main(String[] args) {
        PlayList p1 = new PlayList("sample");
        Song s1 = new Song("Palette","IU");
        Song s2 = new Song("Baby", "Justin Bieber");
        Song s3 = new Song("Firework", "Katy Perry");

        Command addS1 = p1.addPlayableCommand(s1);
        Command addS2 = p1.addPlayableCommand(s2);
        Command addS3 = p1.addPlayableCommand(s3);

        Command removeFirst = p1.removePlayableCommand(0);

        Command setLarry = p1.setNameCommand("Larry");


        System.out.println(p1.getList());
        addS1.execute();
        addS2.execute();
        addS3.execute();
        System.out.println(p1.getList());

        p1.undo();
        p1.undo();

        p1.redo();
        p1.redo();
        System.out.println(p1.getList());




//        System.out.println(p1.getCommands());
//
//        p1.undo();
//        System.out.println(p1.getList());
//        p1.undo();
//
//

//        System.out.println(p1.getList());
//        p1.undo();
//        System.out.println(p1.getList());
//
//        p1.redo();
//        System.out.println(p1.getList());
//        p1.redo();
//        System.out.println(p1.getList());
//        p1.redo();
//        System.out.println(p1.getList());
//        System.out.println(p1.getUndoneCommands());
//        p1.redo();
//        System.out.println(p1.getList());
//
//
//        System.out.println(p1.getName());
//        setLarry.execute();
//        System.out.println(p1.getName());
//        p1.undo();
//        System.out.println(p1.getName());
//        p1.redo();
//        System.out.println(p1.getName());
    }
}
