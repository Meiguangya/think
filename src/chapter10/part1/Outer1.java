package chapter10.part1;

public class Outer1 {

    private String s = "hello";

    class Inner{
        private String label;

        @Override
        public String toString(){
            return s;
        }
    }

    Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.Inner i = outer1.getInner();
        System.out.println(i);
        System.out.println(i.toString());
    }


}
