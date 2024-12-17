package uz.pdp.uy5;

import java.util.Scanner;

public interface Input {
    static int num(String msg){
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    static String str(String msg){
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
