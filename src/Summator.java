import java.util.Scanner;

/**
 * Created by java on 2/7/2016.
 */
class BigNumbers {
    int A[] = new int[5];
}

class MainClass {
    public String replace(String s, int index, char c) {
        s = s.substring(0, index - 1) + c + s.substring(index);
        return s;
    }

    public int sum(int a, int b) {
        System.out.print("1 ");
        return (a + b);
    }

    public double sum(double a, double b) {
        System.out.print("2 ");
        return (a + b);
    }

    public double sum(int a, double b) {
        System.out.print("3 ");
        return (a + b);
    }

    public double sum(double a, int b) {
        System.out.print("4 ");
        return (a + b);
    }

    public String sum(String s1, String s2) {//big numbers
        System.out.print("5 ");
        int max = 0;
        int replacement = 0;
        char repl = ' ';
        int i;
        int bonus = 0;
        String s3 = "";
        if (s2.length() > s1.length()) {
            max = s2.length();
            s3 = s2;
        } else {
            max = s1.length();
            s3 = s1;
        }
        for (i = 1; i < max + 1; i++) {
            //System.out.println("Working...");
            //System.out.println("bonus = " + bonus);

            //System.out.println(s3+" str1");
            if (s1.length() - i >= 0 && s2.length() - i >= 0) {
                replacement = ((Character.getNumericValue(s1.charAt(s1.length() - i)) + Character.getNumericValue(s2.charAt(s2.length() - i))) + bonus) % 10;
                if ((Character.getNumericValue(s1.charAt(s1.length() - i)) + Character.getNumericValue(s2.charAt(s2.length() - i)) + bonus) / 10 > 0) {
                    bonus = 1;
                } else {
                    System.out.println((Character.getNumericValue(s1.charAt(s1.length() - i))+ Character.getNumericValue(s2.charAt(s2.length() - i)) + bonus)+"!!!");
                    bonus = 0;
                }
                //System.out.println("1");
            } else {
                if (s1.length() - i < 0) {
                    replacement = Character.getNumericValue(s2.charAt(s2.length() - i)) % 10 + bonus;
                    //System.out.println("2");
                    if ((Character.getNumericValue(s2.charAt(s2.length() - i)) + bonus) / 10 > 0) {
                        bonus = 1;
                    } else {
                        bonus = 0;
                    }
                }
                if (s2.length() - i < 0) {
                    replacement = Character.getNumericValue(s1.charAt(s1.length() - i)) % 10 + bonus;
                    //System.out.println("3");
                    if ((Character.getNumericValue(s1.charAt(s1.length() - i)) + bonus) / 10 > 0) {
                        bonus = 1;
                    } else {
                        bonus = 0;
                    }
                }
            }
            //System.out.println(replacement + "!");
            repl = Character.forDigit(replacement, 10);
            //System.out.println(repl);
            //System.out.println(s3 + "," + (s3.length() - i) + "," + repl);
            s3 = replace(s3, (s3.length() - i + 1), repl);
            //System.out.println(s3 + " str");
        }

        return s3;
    }
}

public class Summator {
    public static void main(String[] args) {
        MainClass s = new MainClass();
        System.out.println(s.sum(1, 1));
        System.out.println(s.sum(1.25, 1.25));
        System.out.println(s.sum(1, 1.25));
        System.out.println(s.sum(1.25, 1));
        char repl = '5';
        //System.out.println(s.replace("35488", 4,repl ));
        //System.out.println(s.replace("35488", 4,'5' ));
        System.out.println(s.sum("5555555555555555555", "5555555555555"));
    }
}
