package cn.zxc.Demo14String;

public class IsIsomorphic_205 {

    public static void main(String[] args) {
        String s = "egg";
        String t = "ree";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];


        for(int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if(preIndexOfS[curS] != preIndexOfT[curT]){//上一次出现的位置一样就是同构的
                return false;
            }
            preIndexOfS[curS] = i+1;
            preIndexOfT[curT] = i+1;
        }

        return true;
    }
}
