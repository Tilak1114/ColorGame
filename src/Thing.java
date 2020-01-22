public class Thing {
    private String name;
    private Color color = new Color();

    public String getName() {
        return name;
    }

    public Thing(String name) {
        this.name = name;
    }

    public void respond(String respClr){
        System.out.println(name+": Hey! I am sometimes "+respClr);
    }

    public void subscribeToColor(Color clr){
        color = clr;
    }
}
