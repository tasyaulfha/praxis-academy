public class Color {
    private int value;
    private transient String name;

    public static final Color RED = new Color(0, "Red");
    public static final Color BLUE = new Color(1, "Blue");
    public static final Color GREEN = new Color(2, "Green");

    private Color (int value, String name){
        this.value= value;
        this.name=name;


    }
    public int getValue(){
        return value;
    }
    public String toString(){
        return name;
    }

}