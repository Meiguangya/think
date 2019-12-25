public class Solution1 {
    public int game(int[] guess, int[] answer) {
        int num = 0;
        for(int i=0;i<guess.length;i++){
            if(guess[i]==answer[i])
                num ++;
        }
        return num;
    }

    public static void main(String[] args) {

        Solution1 s = new Solution1();
        int res = s.game(new int[]{2,2,3},new int[]{3,2,1});
        System.out.println(res);
    }
}
