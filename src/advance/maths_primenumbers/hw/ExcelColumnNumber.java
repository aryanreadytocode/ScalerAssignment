package advance.maths_primenumbers.hw;
/*
* A >> 65
* Z >>90
* a >>97
* z >> 122
* */
public class ExcelColumnNumber {

    public static void main(String[] args) {

        String s = "CW";
        System.out.println(getValue(s));

    }

    public static int getValue(String s) {  //AB
        int length = s.length()-1; //1
        int ans = 0;
        int i = 0;
        while (i<=length) { //0
            ans += Math.pow(26, i) * (s.charAt(length-i) - 64); //
            i++;
        }
        return ans;
    }
}
