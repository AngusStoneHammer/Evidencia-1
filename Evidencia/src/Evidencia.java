import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
class User {

    static HashMap<String, String> User = new HashMap<>();

    public static void loadUser() throws FileNotFoundException, IOException {
        String filePath = "src/db/User.txt";
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                User.put(key, value);
            }
        }
    }
}
public class Evidencia {
}
