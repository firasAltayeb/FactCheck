import java.util.ArrayList;

class Animal {
    protected String name;

    protected void display() {
        System.out.println("I am an animal.");
    }

    public void sleep() {
        System.out.println(name + " slept for 8 hours.");
    }
}

class Lion extends Animal {
    @Override
    public void sleep() {
        System.out.println(name + " slept for 21 hours.");
    }

    public String hunt(String animal) {
        return name + " ate " + animal + " meat.";
    }

    public void run(int distance) {
        System.out.println("You ran " + distance + "!");
    }
}

class Chameleon extends Animal {
    public Chameleon(String name) {
        this.name = name;
    }

    public Integer[] changeColors(String color) {
        ArrayList<Integer> colorSequence = new ArrayList();
        colorSequence.add(0);
        colorSequence.add(0);
        colorSequence.add(0);
        switch (color) {
            case "red":
                colorSequence.set(0, 255);
                break;
            case "green":
                colorSequence.set(1, 255);
                break;
            case "blue":
                colorSequence.set(2, 255);
                break;
            default:
                break;
        }
        Integer[] finalArray = colorSequence.toArray(new Integer[colorSequence.size()]);
        // Integer[] integerArray = Arrays.stream(colorSequence.toArray()).map(o -> (Integer) o).toArray(Integer[]::new);
        return finalArray;
    }
}

class Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Chameleon chameleon = new Chameleon("George");
        // Arrays.stream(chameleon.changeColors("blue")).map(color -> System.out.println("" + color));
        System.out.println("Color changed to " + chameleon.changeColors("blue").toString());
        chameleon.sleep();
        lion.name = "Simba";
        System.out.println(lion.hunt(chameleon.name));
        lion.sleep();
    }
}