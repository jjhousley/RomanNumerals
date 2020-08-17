/*
    @brief This class will contain methods for converting from Number to Numeral and vice versa

    @author Joe Housley
 */
public class RomanNumeral {

    //default constructor. I probably wont use this since most of the methods will be static
    public RomanNumeral(){

    }

    //static method to convert from number to numeral
    public static String toNumeral(int pass){
        String numeral = new String();
        //put the code for number to numeral here
        //It's pretty much just long division, but not base 10
        int num = pass;
        while(num > 0) {
            if (num - 1000 >= 0) {//see if M fits into it
                numeral += "M";//if it does then add M to the String
                num -= 1000;        //then subtract 1000 from the number else
            } else if (num - 900 >= 0) {//check if CM fits
                numeral += "CM";
                num -= 900;
            } else if (num - 500 >= 0) {//check if D fits
                numeral += "D";
                num -= 500;
            } else if (num - 400 >= 0) {//check if CD fits
                numeral += "CD";
                num -= 400;
            } else if (num - 100 >= 0) {//check if C fits
                numeral += "C";
                num -= 100;
            } else if (num - 90 >= 0) {//check if XC fits
                numeral += "XC";
                num -= 90;
            } else if (num - 50 >= 0) {//check if L fits
                numeral += "L";
                num -= 50;
            } else if (num - 40 >= 0) {//check if XL fits
                numeral += "XL";
                num -= 40;
            } else if (num - 10 >= 0) {//check if X fits
                numeral += "X";
                num -= 10;
            } else if (num - 9 >= 0) {//check if IX fits
                numeral += "IX";
                num -= 9;
            } else if (num - 5 >= 0) {//check if V fits
                numeral += "V";
                num -= 5;
            } else if (num - 4 >= 0) {//check if IV fits
                numeral += "IV";
                num -= 4;
            } else if (num - 1 >= 0) {//check if I fits
                numeral += "I";
                num -= 1;
            }
        }
        return numeral;
    }
    public static boolean isNumeral(String numeral){
        boolean isNumeral = true;
        //check to see if the input is valid
        char[] numArray = numeral.toCharArray(); //I do this to be able to go through the string one character at a time
        for(char c : numArray){ //check every character in the string
            if(RomanNumeral.getNumber(c) == -1){ //we can use get Number to check if the character is a roman Numeral
                return false; //if even one character is bad, the whole thing is bad.
            }
        }
        return isNumeral;
    }
    //static method to convert from numeral to number
    public static int toNumber(String numeral){
        int num = 0;
        numeral = numeral.toUpperCase(); //this is to fix bad input without having to throw an error
        if(RomanNumeral.isNumeral(numeral) == false){ //then we check to see if the characters in the string are valid roman numerals
            return -1;
        }
        char[] numeralArray = numeral.toCharArray();
        //put the code for numeral to number here
        //initialize a to zero and b to 1 for here and next markers
        int a = 0;
        int b = 1;
        for(int i=0; i<numeralArray.length; i++){
            //the current Numeral
            a = RomanNumeral.getNumber(numeralArray[i]);
            if (i+1 <numeralArray.length){
                b = RomanNumeral.getNumber(numeralArray[i+1]);
            }

            if(a<b){ //if it is IV VX XL XC etc
                if(b/a > 10){ //this checks to see if the preceding character is more than one digit bigger than the next one
                    return -2; //return this error code to distinguish from all bad input
                }
                num+=b-a; //add the difference of the larger from the greater
                i++; //then skip the next numeral because we already used it
            }else{
                num+=a; //add the numeral to the total
            }
        }
        return num;
    }
    //convert the character(numeral) to it's corresponding number
    public static int getNumber(char c){
        int num = 0;

        //check which character it is
        if(c==73){//I looked these values up in an ASCII table
            num=1;
        }else if(c==86){
            num=5;
        }else if(c==88){
            num=10;
        }else if(c==76){
            num=50;
        }else if(c==67){
            num=100;
        }else if(c==68){
            num=500;
        }else if(c==77){
            num=1000;
        }else
        {
            num = -1;
        }
        return num;
    }
}
