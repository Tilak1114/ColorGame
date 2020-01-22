import java.util.ArrayList;
import java.util.List;

public class Color {
    private List<Thing> thingsOfThisColor = new ArrayList<>();
    private String colorName;

    public String getColorName() {
        return colorName;
    }

    public void bindThingToColor(Thing thing){
        thingsOfThisColor.add(thing);
    }

    public void unsubscribeFromColor(Thing thing){
        thingsOfThisColor.remove(thing);
    }

    public void notifyThings(String respClr, List<Thing> interestedList){
        for(Thing thing: thingsOfThisColor){
            if(interestedList.contains(thing)){
                thing.respond(respClr);
            }
        }
    }

    public void getThingsOfColor(String respColor, List<Thing> intersetedList){
        notifyThings(respColor, intersetedList);
    }
}
