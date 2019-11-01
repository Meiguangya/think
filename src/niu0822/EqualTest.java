package niu0822;

public class EqualTest {
    public static void main(String[] args) {
        Student a = new Student ("hello",10);
        Student b = new Student ("hello",10);
        Student c = a;
        System.out.println(a==b);
        System.out.println(c==a);

        System.out.println(a.equals(b));
        System.out.println(c.equals(a));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());


    }
}


class Student {
    String name;
    Integer age;

    public Student (){

    }

    public Student(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
