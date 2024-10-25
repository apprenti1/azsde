package org.ToutDouxList;

import java.time.LocalDate;
import java.util.Scanner;
import org.ToutDouxList.test.CalculatriceTest;
import org.ToutDouxList.User;



public class Main {



    private void calculatrice() {
        CalculatriceTest test = new CalculatriceTest();
        test.testAll();
        Scanner scann = new Scanner(System.in);
        System.out.println("premier nombre de l'oppération : \n >>>");
        int a = scann.nextInt();
        System.out.println("\nquel oppérateur souhaitez vous appliquer (*,+,/,-) :\n >>>");
        char o = scann.next().charAt(0);
        System.out.println("\ndeuxième nombre de l'oppération : \n >>>");
        int b = scann.nextInt();
        float result = 0;
        switch (o) {
            case '*':
                result = a*b;
                break;
            case '+':
                result = a+b;
                break;
            case '/':
                result = a/b;
                break;
            case '-':
                result = a-b;
                break;
        }
        System.out.println("\n  Le résultat de l'opération est "+result+"  !!");
    }
    private static void user() {
        User user = new User("aitboukha", "elias", "elias.aitboukha@gmail.com", "aaA34dqddssd", LocalDate.now().minusYears(20));

        System.out.println(user.calculateAgeFromBirthDate());
    }


    public static void main(String[] args) {
        user();
    }

}