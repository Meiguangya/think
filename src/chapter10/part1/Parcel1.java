package chapter10.part1;

public class Parcel1 {

    //内部类
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    //内部类
    class Destination {
        private String label;

        Destination(String whereto) {
            label = whereto;
        }

        String readLabel() {
            return label;
        }
    }

    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("你好");
    }
}
