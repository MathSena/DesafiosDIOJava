import java.io.IOException;
import java.util.Scanner;

public class Encaixa {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();

        for (int i =0; i<N; i++) {
            String a = leitor.next();
            String b = leitor.next();
            if (a.length() >= b.length() && a.substring(a.length() - b.length(), a.length()).equalsIgnoreCase(b))
                System.out.println("encaixa");
            else
                System.out.println("nao encaixa");
        }
    }

}