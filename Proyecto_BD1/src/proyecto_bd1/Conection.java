package proyecto_bd1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conection {

    private String base_datos;
    private Connection dbcon;
    public Statement query;

    public Conection(String base_datos) {
        this.base_datos = base_datos;
    }

    public void setBase_datos(String base_datos) {
        this.base_datos = base_datos;
    }

    public void conectar() {
        try {
            String driver = "jdbc:ucanaccess://";
            String url = "jdbc:mysql://localhost:3306/Aeropuerto";
            String user = "root";
            String pass = "Iliana98maria";
            System.out.println("Conectando...");
            dbcon = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!");
            query = dbcon.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {
            query.close();
            dbcon.close();
        } catch (Exception e) {
        }
    }

    public void commit() {
        try {
            dbcon.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
