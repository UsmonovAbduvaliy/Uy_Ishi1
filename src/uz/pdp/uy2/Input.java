package uz.pdp.uy2;

import java.util.Scanner;

public interface Input {
    static String str(String msg){
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    static int num(String msg){
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
