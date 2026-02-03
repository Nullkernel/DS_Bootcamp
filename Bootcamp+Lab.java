/*
---DS_Bootcamp---
public class RecursiveNumberDemo {
    public static void main(String[] args) {
        NumberSequencePrinter.printDescending(5, 1);
    }
}
class NumberSequencePrinter {
    public static void printDescending(int n, int step) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDescending(n - 1, step + 1);
    }
}


public class MutualRecursionDemo {
    public static void main(String[] args) {
        RecursiveFlow.startProcess(10);
    }
}
class RecursiveFlow {
    public static void startProcess(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println("A: " + n);
        continueProcess(n - 1);
    }
    public static void continueProcess(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println("B: " + n);
        startProcess(n / 2);
    }
}

public class CountdownDemo {
    public static void main(String[] args) {
        CountdownPrinter.startCountdown(5);
    }
}
class CountdownPrinter {
    public static void startCountdown(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        startCountdown(n - 1);
    }
}

import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        int a = 0;
        int b = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        sc.close();
    }
}

---Lab---
import java.util.Scanner;

public class AlternateStringCombine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String first = sc.nextLine();
        System.out.println("Enter the second string:");
        String second = sc.nextLine();
        String result = alternateCombine(first, second);
        System.out.println("Combined string: " + result);
        sc.close();
    }
    public static String alternateCombine(String a, String b) {
        StringBuilder result = new StringBuilder();
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            result.append(a.charAt(i));
            result.append(b.charAt(i));
        }
        if (a.length() > minLength) {
            result.append(a.substring(minLength));
        } else if (b.length() > minLength) {
            result.append(b.substring(minLength));
        }
        return result.toString();
    }
}

import java.util.Scanner;

public class NumberRelationChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a == 0 || b == 0) {
            System.out.println(3);
        } else if (b % a == 0) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
        sc.close();
    }
}

import java.util.Scanner;

public class AddSecondLastDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();
        int result = addSecondLastDigits(input1, input2);
        System.out.println(result);
        sc.close();
    }
    public static int addSecondLastDigits(int input1, int input2) {
        int digit1 = Math.abs(input1 / 10) % 10;
        int digit2 = Math.abs(input2 / 10) % 10;
        return digit1 + digit2;
    }
}

import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        String g = sc.next();
        String f = g.toUpperCase();
        int p = 0, q = 0, r = 0, s = 0, t = 0;
        if (f.equals("EVEN")) {
            if (a % 2 == 0) p = 1;
            else p = 0;
            if (b % 2 == 0) q = 1;
            else q = 0;
            if (c % 2 == 0) r = 1;
            else r = 0;
            if (d % 2 == 0) s = 1;
            else s = 0;
            if (e % 2 == 0) t = 1;
            else t = 0;
        } else if (f.equals("ODD")) {
            if (a % 2 != 0) p = 1;
            else p = 0;
            if (b % 2 != 0) q = 1;
            else q = 0;
            if (c % 2 != 0) r = 1;
            else r = 0;
            if (d % 2 != 0) s = 1;
            else s = 0;
            if (e % 2 != 0) t = 1;
            else t = 0;
        }
        int n = p + q + r + s + t;
        System.out.println(n);
        sc.close();
    }
}
*/