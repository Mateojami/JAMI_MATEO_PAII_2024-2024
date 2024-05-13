package ec.edu.uce.Proyecto_004;

import javax.swing.SwingUtilities;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Student;
import models.Subject;
import models.Professor;
import view.MultiCRUDFrame;

public class App {
    public static void main(String[] args) {
        // Configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Professor.class);
        configuration.addAnnotatedClass(Subject.class);
        
        // Por ejemplo:
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/instituto");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "jami2001");
        
        // Creación de la SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MultiCRUDFrame(sessionFactory).setVisible(true);
            }
        });
    }
}
