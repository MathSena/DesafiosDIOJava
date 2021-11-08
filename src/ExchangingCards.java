import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Iterator;


public class ExchangingCards {
    private static final boolean DEBUG = false;
    private BufferedReader cin;
    private PrintWriter cout;
    private StreamTokenizer tokenizer;
    private HashSet<Integer> s1, s2;
    private int a, b;

    public void init()
    {
        try {
            if (DEBUG) {
                cin = new BufferedReader(new InputStreamReader(
                        new FileInputStream("e:\\uva_in.txt")));
            } else {
                cin = new BufferedReader(new InputStreamReader(System.in));
            }

            tokenizer = new StreamTokenizer(cin);

            cout = new PrintWriter(new OutputStreamWriter(System.out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String next()
    {
        try {
            tokenizer.nextToken();
            if (tokenizer.ttype == StreamTokenizer.TT_EOF) return null;
            else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                return String.valueOf((int)tokenizer.nval);
            } else return tokenizer.sval;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean input()
    {
        a = Integer.parseInt(next());
        b = Integer.parseInt(next());

        if (a == 0 && b == 0) return false;

        s1 = new HashSet<Integer>();
        s2 = new HashSet<Integer>();

        for (int i = 0; i < a; i++) {
            s1.add(Integer.parseInt(next()));
        }

        for (int i = 0; i < b; i++) {
            s2.add(Integer.parseInt(next()));
        }
        return true;
    }

    public void solve()
    {
        int ans = s1.size();
        Iterator<Integer> it = s2.iterator();

        int cnt = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (!s1.contains(num)) cnt++;
            else ans--;
        }

        ans = Math.min(ans, cnt);
        cout.println(ans);
        cout.flush();
    }

    public static void main(String[] args)
    {
        ExchangingCards solver = new ExchangingCards();
        solver.init();

        while (solver.input()) {
            solver.solve();
        }
    }
}