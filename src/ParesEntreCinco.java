import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;


public class ParesEntreCinco {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> vetor = new ArrayList<Integer>();

        int count = 0;

        for(int i=0 ; i<5 ; i++) {
            vetor.add(scanner.nextInt());
        }

        for(int elemento : vetor) {
            if(elemento%2==0) {
                count++;
            }
        }

        System.out.println(count + " valores pares");
    }
}
