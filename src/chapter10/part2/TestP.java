package chapter10.part2;

interface Contents {
    int value();
}

interface Destination {
    String readLable();
}

class Parcel4 {

    private class PContents implements Contents {

        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {

        private String label;

        private PDestination(String whereto) {
            label = whereto;
        }

        @Override
        public String readLable() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }

}

public class TestP{

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("ree");
    }
}

