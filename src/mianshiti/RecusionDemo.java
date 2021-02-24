package mianshiti;

public class RecusionDemo {

    //1.求一个数的阶乘
    public static int getJC(int n,int z){
        if(z==0){
            return 1;
        }else{
            return doCount(n,z);
        }
    }

    public static int doCount(int n,int z){
        if(z==1){
            return n;
        }else{
            return n*doCount(n,z-1);
        }
    }

    public static void main(String[] args) {
        int res = getJC(5,0);
        System.out.println(res);
    }


}
