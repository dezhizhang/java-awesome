package shop.xiaozhi.kmp;

public class Violence {
    public static void main(String[] args) {
        String s1 = "hello world";
        String s2 = "world";

        int index = violence(s1, s2);

        System.out.println(index);
    }


    public static int violence(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;
        int j = 0;

        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == s2Len) {
            return i - j;
        }

        return -1;
    }


}
