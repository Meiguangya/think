package mianshiti;

import java.util.ArrayList;

public class RecusionDemo {

    //1.求一个数的幂
    public static int getMi(int n,int z){
        if(z==0){
            return 1;
        }
        int res = n;
        while(z>1){
            res = res * n;
            z--;
        }
        return res;
    }


    //2.求一个数的阶乘
    public static int getJieCheng(int n) throws Exception {
        if(n<0){
            throw new Exception("参数不合法");
        }
        if(n==0 || n==1){
            return 1;
        }else{
            return n*getJieCheng(n-1);
        }
    }

    //3.斐波数列
    //数字规律 1，1，2，3，5，8，13。。。。
    //给n 求出n位的数
    public static int getFeiBo(int n){
        if(n==1 || n==2){
            return 1;
        }else{
            return getFeiBo(n-1)+getFeiBo(n-2);
        }
    }

    //给定结果数 找到第几位
    public static int getFeiBoIndex(int n){
        int temp = 2;
        int index = 3;
        while(temp!=n){
            index++;
            temp = getFeiBo(index);
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        int res = getMi(2,3);
        int res2 = getJieCheng(0);
        int res3 = getFeiBo(20);
        int res4 = getFeiBoIndex(6765);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        Integer.valueOf(10);
    }


}
