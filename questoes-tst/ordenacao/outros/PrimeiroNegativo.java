import java.util.Scanner;

public class PrimeiroNegativo {

    public static String encontraNegativo(int i, String[] arr) {
        if (i >= arr.length) return "-";
        if (Integer.parseInt(arr[i]) < 0) return arr[i];
        return encontraNegativo(i+1, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
    
        System.out.println(encontraNegativo(0, entrada));
    }
}
