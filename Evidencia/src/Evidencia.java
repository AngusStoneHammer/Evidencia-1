import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
class User {

    static HashMap<String, String> User = new HashMap<>();

    public static void loadUser() throws IOException {
        String filePath = "Evidencia/src/db/User.txt";
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

        properties.store(new FileOutputStream("Evidencia/src/db/User.txt"), null);
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
        String filePath = "Evidencia/src/db/paciente.txt";

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

        properties.store(new FileOutputStream("Evidencia/src/db/paciente.txt"), null);
    }
}
class Doctor {
    static String Nombre = null;
    static String especialidad = null;

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
    static HashMap<String, String> doctor = new HashMap<>();
    private static String Nombre;
    private static String especialidad;

    public static void loaddoctor() throws IOException {
        String filePath = "Evidencia/src/db/doctor.txt";

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

        properties.store(new FileOutputStream("Evidencia/src/db/doctor.txt"), null);
    }
}
class cita{
    private static String motivo;
    private static String FechayHora;
    public cita(String motivo, String FechayHora) {
        this.motivo = motivo;
        this.FechayHora = FechayHora;
    }

    @Override
    public String toString() {
        return "con el Motivo " + motivo + " con la Fecha de " + FechayHora;
    }
}
class citacrear {
    static HashMap<String, String> cita = new HashMap<>();
    public static void citaload() throws IOException {
        String filePath = "Evidencia/src/db/cita.txt";

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
    public static void citasave() throws IOException {
        Properties properties = new Properties();

        for (Map.Entry<String, String> entry : cita.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(new FileOutputStream("Evidencia/src/db/cita.txt"), null);
    }
}
public class Evidencia {
    public static void main (String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        User user = new User();
        user.loadUser();
        if (user.User.size() == 0) {
            System.out.println("creando usuario");
            System.out.println("introduce nombre");
            String name = null;
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("introduce contrasena");
            String contrasena = null;
            try {
                contrasena = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!User.User.containsKey(name)) {
                User.User.put(name, contrasena);
                user.saveUser();
                System.out.println("Usuario guardado");

            } else {
                System.out.println("paciente existente");
            }
        } else {
            System.out.println("introduce nombre de usuario");
            String name = null;
            try {
                name = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (user.User.containsKey(name)) {
                System.out.println("introduce contrasena");
                String contrasena = null;
                try {
                    contrasena = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (user.User.containsValue(contrasena)) {
                    pacientecrear paciente = new pacientecrear();
                    doctorcrear doctor = new doctorcrear();
                    citacrear cita = new citacrear();
                    System.out.println("\n");
                    paciente.loadpaciente();
                    doctor.loaddoctor();
                    cita.citaload();
                    boolean salir = false;
                    int option = 0;
                    while (!salir) {
                        System.out.println("1. registrar paciente");
                        System.out.println("2. registrar Doctor");
                        System.out.println("3. registrar cita");
                        System.out.println("4. Salir");

                        System.out.println("Introduce un numero: ");
                        try {
                            option = Integer.parseInt(reader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        switch (option) {
                            case 1:
                                System.out.println("agregar a un paciente");
                                int a = 0;
                                while (a == 0) {
                                    System.out.println("introduce nombre");
                                    String Nombre = null;
                                    try {
                                        Nombre = reader.readLine();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    String pacienteid = "pa" + String.valueOf(200 + pacientecrear.paciente.size());
                                    if (!pacientecrear.paciente.containsKey(pacienteid)) {
                                        pacientecrear.paciente.put(pacienteid, String.valueOf(new Paciente(Nombre)));
                                        System.out.println("paciente guardado");
                                    } else {
                                        System.out.println("paciente existente");
                                    }
                                    System.out.println("desea agregar otro Paciente 1/0");
                                    int L = 0;
                                    try {
                                        L = Integer.parseInt(reader.readLine());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (L == 1) {
                                        a = 0;
                                    } else {
                                        a = 1;
                                    }

                                }
                                break;
                            case 2:
                                System.out.println("agregar a un doctor");
                                int b = 0;
                                while (b == 0) {
                                    System.out.println("introduce nombre");
                                    String Nombred = null;
                                    try {
                                        Nombred = reader.readLine();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("introduce especialidad");

                                    String especialidad = null;
                                    try {
                                        especialidad = reader.readLine();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    String doctorid = "dr" + String.valueOf(200 + doctorcrear.doctor.size());
                                    if (!doctorcrear.doctor.containsKey(doctorid)) {
                                        doctorcrear.doctor.put(doctorid, String.valueOf(new Doctor(Nombred, especialidad)));
                                        System.out.println("Doctor guardado");
                                    } else {
                                        System.out.println("Doctor existente");
                                    }
                                    System.out.println("desea agregar otro doctor 1/0");
                                    int k = 0;
                                    try {
                                        k = Integer.parseInt(reader.readLine());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (k == 1) {
                                        b = 0;
                                    } else {
                                        b = 1;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("crear una cita");
                                int c = 0;
                                while (c == 0) {
                                    if (!cita.cita.containsKey("ci" + String.valueOf(300+doctorcrear.doctor.size() - 1))) {
                                        if (!cita.cita.containsKey("ci" + String.valueOf(300+pacientecrear.paciente.size() - 1))) {
                                            System.out.println(doctorcrear.doctor.get("dr" + String.valueOf(200 + doctorcrear.doctor.size() - 1)));
                                            System.out.println(pacientecrear.paciente.get("pa" + String.valueOf(200 + pacientecrear.paciente.size() - 1)));

                                            System.out.println("introduce Motivo");
                                            String motivo = null;
                                            try {
                                                motivo = reader.readLine();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("introduce Fecha mm/dd/yy");
                                            String Fecha = null;
                                            try {
                                                Fecha = reader.readLine();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("introduce hora hh/mm");
                                            String hora = null;
                                            try {
                                                hora = reader.readLine();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            String fyh = Fecha + " a las " + hora;

                                            if (doctorcrear.doctor.containsKey("dr" + String.valueOf(200 + doctorcrear.doctor.size() - 1))) {
                                                if (pacientecrear.paciente.containsKey("pa" + String.valueOf(200 + pacientecrear.paciente.size() - 1))) {
                                                    String citaid = "ci" + String.valueOf(300 + cita.cita.size());
                                                    if (!cita.cita.containsKey(citaid)) {
                                                        cita.cita.put(citaid, String.valueOf("se agendo una cita " + new cita(motivo, fyh) + ", a cargo del " + doctorcrear.doctor.get("dr" + String.valueOf(200 + doctorcrear.doctor.size() - 1)) + ", atendiendo al " + pacientecrear.paciente.get("pa" + String.valueOf(200 + pacientecrear.paciente.size() - 1))));
                                                        System.out.println("cita agendada");
                                                        System.out.println(cita.cita.get(citaid));
                                                    } else {
                                                        System.out.println("cita existente");
                                                    }

                                                } else {
                                                    System.out.println("paciente no existente");
                                                }
                                            } else {
                                                System.out.println("doctor no existente");
                                            }
                                        }else {
                                            System.out.println("No hay otro paciente registrado");
                                        }
                                    } else {
                                        System.out.println("todos los doctores estan ocupadps");
                                    }
                                    System.out.println("desea crear otra cita 1/0");
                                    int P = 0;
                                    try {
                                        P = Integer.parseInt(reader.readLine());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    if (P == 1) {
                                        c = 0;
                                    } else {
                                        c = 1;
                                    }
                                }
                                break;
                            case 4:
                                salir = true;
                                break;
                        }

                    }
                    paciente.savepaciente();
                    doctor.savedoctor();
                    cita.citasave();
                    System.out.println("Fin del menu");
                }else{
                    System.out.println("contrasena incorrecta");
                }
            }else{
                System.out.println("Usuario incorrecto");
            }
        }
        user.saveUser();
    }
}
