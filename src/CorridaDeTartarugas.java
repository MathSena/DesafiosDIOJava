import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CorridaDeTartarugas {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int m = 2;


        do {
            n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String s[] = str.split(" ");
            Integer inteiro[] = new Integer[n];
            int veloz = 0;

            for (int i = 0; i < n; i++) {
                inteiro[i] = Integer.parseInt(s[i]);

                if (inteiro[i] > veloz) {
                    veloz = inteiro[i];
                }
            }
            if (veloz < 10) {
                System.out.println(1);
            }
            if (veloz >= 10 && veloz < 20) {
                System.out.println(2);
            }
            if (veloz >= 20) {
                System.out.println(3);
            }

            m--;
        } while (m >= 0);
    }
}