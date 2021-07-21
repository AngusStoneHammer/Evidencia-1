import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
class User {

    static HashMap<String, String> User = new HashMap<>();

    public static void loadUser() throws IOException {
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
class Paciente {
    static String Nombre = null;

    public Paciente(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Paciente " + Nombre;
    }
}
class pacientecrear {

    static HashMap<String, String> paciente = new HashMap<>();
    private static String Nombre;

    public static void loadpaciente() throws IOException {
        String filePath = "src/db/paciente.txt";

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                paciente.put(key, value);
            }
        }
    }
    public static void savepaciente() throws IOException {
        Properties properties = new Properties();

        for (Map.Entry<String,String> entry : paciente.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        properties.store(new FileOutputStream("src/db/paciente.txt"), null);
    }
}
class Doctor {
    static String Nombre = null;
    static String especialidad = null;
    static String doctorid = null;

    public Doctor(String Nombre, String especialidad) {
        this.Nombre = Nombre;
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctor " + Nombre + " con la Especialidad " + especialidad;
    }

}
class doctorcrear {
    static HashMap<String, String> doctor = new HashMap<String, String>();
    private static String Nombre;
    private static String especialidad;

    public static void loaddoctor() throws FileNotFoundException, IOException {
        String filePath = "src/db/doctor.txt";

        String lined;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((lined = reader.readLine()) != null) {
            String[] parts = lined.split("=", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                doctor.put(key, value);
            }
        }
    }
    public static void savedoctor() throws IOException {
        Properties properties = new Properties();

        for (Map.Entry<String,String> entry : doctor.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        properties.store(new FileOutputStream("src/db/doctor.txt"), null);
    }
}
class cita{
    private static String motivo;
    private static String Fecha;
    public cita(String motivo, String Fecha) {
        this.motivo = motivo;
        this.Fecha = Fecha;
    }

    public cita() {

    }

    @Override
    public String toString() {
        return "con el Motivo " + motivo + " con la Fecha de " + Fecha;
    }
}
class citacrear {
    static HashMap<String, String> cita = new HashMap<>();
    public static void citaload() throws FileNotFoundException, IOException {
        String filePath = "src/db/cita.txt";

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                cita.put(key, value);
            }
        }
    }
}
public class Evidencia {
}
