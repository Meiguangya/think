package chapter8.part1;

class Cycle {


    static String cycleing() {
        System.out.println("static cycle...");
        return "cycle";
    }
    private String cycleName = cycleing();


    Cycle() {
        System.out.println("cycle...");
    }

    void ride() {
        System.out.println("cycle ride...");
    }

    void sale(){
        System.out.println("cycle sale");
    }
}

class Unicycle extends Cycle {
    Unicycle() {
        System.out.println("unicycle...");
    }

    @Override
    void ride() {
        System.out.println("unicycle ride...");
    }
}

class Bicycle extends Cycle {
    Bicycle() {
        System.out.println("Bicycle...");
    }

    @Override
    void ride() {
        System.out.println("Bicycle ride...");
    }
    @Override
    void sale(){
        System.out.println("Bicycle sale...");
    }
}

class TriCycle extends Cycle {
    TriCycle() {
        System.out.println("TriCycle...");
    }

    @Override
    void ride() {
        System.out.println("TriCycle ride...");
    }
}


public class CyCleDemo {

    static void ride(Cycle c) {
        c.ride();
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Cycle unicycle = new Unicycle();
        Cycle bicycle = new Bicycle();
        Cycle tricycle = new TriCycle();

        unicycle.sale();
        bicycle.sale();

        ride(unicycle);
        ride(bicycle);
        ride(tricycle);
    }
}
