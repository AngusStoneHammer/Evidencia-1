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
    public static void saveUser() throws IOException {
        Properties properties = new Properties();

        for (Map.Entry<String,String> entry : User.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        properties.store(new FileOutputStream("src/db/User.txt"), null);
    }
}
public class Evidencia {
}
