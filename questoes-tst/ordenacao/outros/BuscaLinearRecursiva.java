import java.util.Scanner;

public class BuscaLinearRecursiva {
    
    public static String encontraNum(int i, String n, String[] arr) {
        if (i >= arr.length) return "-1";
        if (n.equals(arr[i])) return String.format("%d", i);
        return encontraNum(i+1, n, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split(" ");
        String n = sc.nextLine();
    
        System.out.println(encontraNum(0, n, tokens));
    }

}
