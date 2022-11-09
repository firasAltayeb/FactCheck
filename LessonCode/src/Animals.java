class Animal {
    protected String name;

    protected void display() {
        System.out.println("I am an animal.");
    }

    public void eat() {
        System.out.println("I can eat");
    }
}

class Dog extends Animal {

    public void getInfo() {
        System.out.println("My name is " + name);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("I eat dog food");
    }

    public void bark() {
        System.out.println("I can bark");
    }
}

class Main {
    public static void main(String[] args) {
        Dog labrador = new Dog();
        labrador.bark();
        labrador.eat();

        labrador.name = "Rocky";
        labrador.display();

        labrador.getInfo();
    }
}