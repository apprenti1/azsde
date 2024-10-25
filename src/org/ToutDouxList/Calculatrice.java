package org.ToutDouxList;

public class Calculatrice {
    
    public int add(int a, int b) {return a + b;}
    public int sub(int a, int b) {return a - b;}
    public int mul(int a, int b) {return a * b;}
    public int div(int a, int b) {
        if (b == 0) {throw new IllegalArgumentException("division par 0 connard X)");}
        return a / b;
    }

    public double avg(int[] tab) {
        if (tab.length == 0) {throw new IllegalArgumentException("la moyenne d'un tableau vide, bonne question ^^'\nle problème se trouve entre la chaise et le clavier X)");}
        int sum = 0;
        for (int num : tab) {sum += num;}
        return (double) sum / tab.length;
    }
}

