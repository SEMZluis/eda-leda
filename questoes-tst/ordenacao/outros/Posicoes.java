import java.util.Scanner;

public class Posicoes {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        String[] tokens = sc.nextLine().split(" ");
        String posicoes = "-1";

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(n)) {
                if (posicoes.equals("-1")) posicoes = String.format("%d", i);
                else posicoes += " "+i;
            }
        }

        System.out.println(posicoes);
    }

}
