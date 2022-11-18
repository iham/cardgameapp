package ddb.international;

public class BlackJackCard {
    private String name;
    private String color;
    private int value;

    public BlackJackCard() {}

    public BlackJackCard(String name, String color, int value) {
        setName(name);
        setColor(color);
        setValue(value);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BlackJackCard [" + name + " of " + color + ", value=" + value + "]";
    }

    
}
