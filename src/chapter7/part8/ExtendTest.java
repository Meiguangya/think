package chapter7.part8;

class Father{
    private String name = "father";
    private int age = 40;

    public void toStr(){
        System.out.println(name+"-----"+age);
    }
}

class Son extends Father{
    private String name = "son";
    private int age = 18;

    public void toStr(){
        System.out.println(name+"******"+age);
    }

}

public class ExtendTest {

    public static void main(String[] args) {
        Father f = new Son();

        f.toStr();

        //向下转型
        Son s = (Son) f;
        s.toStr();
    }
}
