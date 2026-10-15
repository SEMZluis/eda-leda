

import java.util.Scanner;

public class Duplos {

    public static boolean checaDuplos(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            for (int j = i+1; j < tokens.length; j++) {
                if (tokens[i].equals(tokens[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");

        System.out.println(checaDuplos(tokens));

        sc.close();
    }

}