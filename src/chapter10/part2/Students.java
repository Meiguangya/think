package chapter10.part2;

public class Students {

    private String name;
    private int age;

    class Inner {

        private String innerStr = "innner....";

        public void changeOut() {
            name = "李";
            age = 10;
            System.out.println(Students.this.toString());
        }
    }

    @Override
    public String toString() {
        return name + "-" + age;
    }


    public static void main(String[] args) {
        Students s = new Students();
        Students.Inner i = s.new Inner();

        i.changeOut();

        System.out.println(i.innerStr);


    }





}
