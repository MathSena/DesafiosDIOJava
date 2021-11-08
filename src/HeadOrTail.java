import java.util.Scanner;

public class HeadOrTail {

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            final int cases = input.nextInt();

            if (cases == 0) {
                break;
            }

            int mary = 0;
            int john = 0;
            for (int i = 0; i < cases; i++) {
                if (input.nextInt() == 0) {
                    mary++;
                } else {
                    john++;
                }
            }

            System.out.printf("Mary won %d times and John won %d times%n", mary, john);
        }
    }
}

