import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColorGame {

    private static final int totalColors = 5;

    static List<Thing> interestedThingsList = new ArrayList<>();

    static Color white = new Color();
    static Color brown = new Color();
    static Color yellow = new Color();
    static Color green = new Color();
    static Color red = new Color();
    static Thing salt = new Thing("salt");
    static Thing ink = new Thing("ink");
    static Thing banana = new Thing("banana");
    static Thing sun = new Thing("Sun");
    static Thing sugar = new Thing("sugar");
    static Thing frog = new Thing("frog");

    static List<Color> colors = new ArrayList<>();

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        colors.add(white);
        colors.add(brown);
        colors.add(yellow);
        colors.add(green);
        colors.add(red);

        interestedThingsList.add(salt);
        interestedThingsList.add(banana);
        interestedThingsList.add(sun);
        interestedThingsList.add(sugar);

        /* interestedThingsList here is the dynamic list of things that get added with + and subtracted with -.
        for example, +sun adds sun to the list and -sun removes it
        */

        defaultSetup();

        System.out.println("Enter Command");

        String command = scanner.nextLine();

        //TODO: Implement logic to append to interested things list and remove the same. For now it contains all the things by default
        //TODO: Also handle the frog and ink exception
        Boolean shouldExit = false;

        while(!shouldExit){
            if(command.equals("white"))
                white.getThingsOfColor("white", interestedThingsList);

            else if(command.equals("brown"))
                brown.getThingsOfColor("brown", interestedThingsList);

            else if(command.equals("yellow"))
                yellow.getThingsOfColor("yellow", interestedThingsList);

            else if(command.equals("red"))
                red.getThingsOfColor("red", interestedThingsList);

            else if(command.equals("green"))
                green.getThingsOfColor("green", interestedThingsList);
            else if(command.equals("exit"))
                shouldExit = true;
        }
    }

    public static void defaultSetup(){

        //salt
        salt.subscribeToColor(white);

        for(int i=0; i<colors.size(); i++){
            ink.subscribeToColor(colors.get(i));  // ink has all colors
        }

        //sugar
        sugar.subscribeToColor(brown);
        sugar.subscribeToColor(white);

        //banana
        banana.subscribeToColor(green);
        banana.subscribeToColor(yellow);

        //sun
        sun.subscribeToColor(red);
        sugar.subscribeToColor(yellow);




        white.bindThingToColor(salt);
        red.bindThingToColor(sun);
        green.bindThingToColor(banana);
        yellow.bindThingToColor(sun);
        yellow.bindThingToColor(banana);
        brown.bindThingToColor(sugar);
        white.bindThingToColor(sugar);
    }
}
