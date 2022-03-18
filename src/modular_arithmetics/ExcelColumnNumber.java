package modular_arithmetics;
/*
* Problem Description
Given a column title as appears in an Excel sheet, return its corresponding column number.



Problem Constraints
1 <= length of the column title <= 5



Input Format
The only argument is a string that represents the column title in the excel sheet.



Output Format
Return a single integer that represents the corresponding column number.



Example Input
Input 1:

 AB
Input 2:

 ABCD


Example Output
Output 1:

 28
Output 2:

 19010


Example Explanation
Explanation 1:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
* */
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        A = A.toLowerCase();
        int res = 0;
        int data;
        int temp_val = 96;
        for(int i =0; i<A.length(); i++){
            int temp = ((int) A.charAt(i));
            data = temp-temp_val;
            if(i==A.length()-1){
                res += data;
            }else
                res += data*(Math.pow(26, (A.length()-1-i)));

        }
        return res;
    }
}
