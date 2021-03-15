package huaweijishi.kaoshi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while((input=reader.readLine())!=null){
            if(input.isEmpty()) break;

            String[] nums = input.split(" ");
            int a = Integer.valueOf(nums[0]);
            int b = Integer.valueOf(nums[1]);
            System.out.println(add(a,b));
        }

        reader.close();
    }

    public static int add(int a,int b){
        return a+b;
    }

}
