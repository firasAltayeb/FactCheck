import java.util.ArrayList;

interface Mammal {
    boolean hasFur();

    void run();
}

class Animal {
    protected String name;

    public void sleep() {
        System.out.println(name + " slept for 8 hours.");
    }
}

class Lion extends Animal implements Mammal {
    @Override
    public void sleep() {
        System.out.println(name + " slept for 21 hours.");
    }

    public String hunt(String animal) {
        return name + " ate " + animal + " meat.";
    }

    @Override
    public boolean hasFur() {
        return true;
    }

    public void run() {
        System.out.println(name + " ran for 8 kilometers!");
    }
}

class Platypuses extends Animal implements Mammal {
    @Override
    public void sleep() {
        System.out.println(name + " slept for 14 hours.");
    }

    @Override
    public void run() {
        System.out.println(name + " ran for 1 kilometers!");
    }

    @Override
    public boolean hasFur() {
        System.out.println(name + " has fur!");
        return false;
    }
}

class Chameleon extends Animal {
    public Chameleon(String name) {
        this.name = name;
    }

    public ArrayList<Integer> changeColors(String color) {
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
        // Integer[] finalArray = colorSequence.toArray(new Integer[colorSequence.size()]);
        // Integer[] integerArray = Arrays.stream(colorSequence.
        // toArray()).map(o -> (Integer) o).toArray(Integer[]::new);
        return colorSequence;
    }

    public ArrayList<String> allColors() {
        ArrayList<String> colors = new ArrayList();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        return colors;
    }
}

class Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Chameleon chameleon = new Chameleon("George");
        chameleon.changeColors("blue").forEach(color -> System.out.print(color + ", "));
        chameleon.allColors().stream().map(color -> color.toUpperCase()).
                forEach(color -> System.out.print(color + ", "));
        System.out.println();
        chameleon.sleep();
        lion.name = "Simba";
        System.out.println(lion.hunt(chameleon.name));
        lion.sleep();
        Platypuses platypuses = new Platypuses();
        platypuses.name = "perry";
        platypuses.hasFur();
    }
}