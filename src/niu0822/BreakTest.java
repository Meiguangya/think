package niu0822;

public class BreakTest {

    /**
     * break 任意位置都能break
     * @param args
     */
    public static void main(String[] args) {

        label1:for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i*j + "  ");
                if(j==5){
                    break label1;
                }
            }
            System.out.println();
        }
    }
}
