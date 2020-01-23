import java.util.ArrayList;
import java.util.HashMap;
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
    static Thing sun = new Thing("sun");
    static Thing sugar = new Thing("sugar");
    static Thing frog = new Thing("frog");

    static HashMap<String, Thing> strThingMap = new HashMap<>();

    static List<Color> colors = new ArrayList<>();
    static List<Thing> allThings = new ArrayList<>();

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        colors.add(white);
        colors.add(brown);
        colors.add(yellow);
        colors.add(green);
        colors.add(red);

        allThings.add(sun);
        allThings.add(salt);
        allThings.add(sugar);
        allThings.add(banana);

        interestedThingsList.add(salt);
        interestedThingsList.add(banana);
        //interestedThingsList.add(sun);
        interestedThingsList.add(sugar);

        /* interestedThingsList here is the dynamic list of things that get added with + and subtracted with -.
        for example, +sun adds sun to the list and -sun removes it
        */

        defaultSetup();

        String command = "";

        //TODO: Implement logic to append to interested things list and remove the same. For now it contains all the things by default
        //TODO: Also handle the frog and ink exception

        while(!command.equals("exit")){

            System.out.println("\nEnter Command");

            command = scanner.nextLine();

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

            else if(command.substring(0, 1).equals("+")){
                String objectName = command.substring(1);
                boolean exists = false;
                for(int i=0; i<interestedThingsList.size(); i++){
                    if(interestedThingsList.get(i).getName().equals(command.substring(1))){
                        exists = true;
                    }
                }
                if(!exists)
                    interestedThingsList.add(strThingMap.get(objectName));
            }

            else if(command.substring(0, 1).equals("-")){
                String objectName = command.substring(1);
                boolean exists = false;
                for(int i=0; i<interestedThingsList.size(); i++){
                    if(interestedThingsList.get(i).getName().equals(command.substring(1))){
                        exists = true;
                    }
                }
                if(exists)
                    interestedThingsList.remove(strThingMap.get(objectName));
            }

            else if(command.equals("list")){
                for(int i=0; i<interestedThingsList.size(); i++){
                    System.out.println(interestedThingsList.get(i).getName());
                }
            }

            else
                System.out.println("Doesnt support "+ command);
        }
    }

    public static void defaultSetup(){

        strThingMap.put("sun", sun);
        strThingMap.put("salt", salt);
        strThingMap.put("sugar", sugar);
        strThingMap.put("banana", banana);

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
