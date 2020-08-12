import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337


        /* expected exception
        number = new Number(NumberSystemType._2, "120");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);
        */

    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {

        try {
            BigInteger a = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        BigInteger bi = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
        String ans = bi.toString(expectedNumberSystem.getNumberSystemIntValue());
        return new Number(expectedNumberSystem, ans);
    }
}
