import java.util.Scanner;

public class PotRecursiva {
    
    public static int elevarRecursivo(int base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        return base * elevarRecursivo(base, exp-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = Integer.parseInt(sc.nextLine());
        int j = Integer.parseInt(sc.nextLine());

        System.out.println(elevarRecursivo(i, j));
    }

}
