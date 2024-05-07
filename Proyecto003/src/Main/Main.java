package Main;

import java.sql.Connection;
import java.sql.SQLException;

import clases.Alumno;
import clases.DatabaseConnection;
import clases.Horarios;
import clases.Materias;
import clases.Profesor;
import dAOS.GenericDAO;

public class Main {

    public static void main(String[] args) {
        try {
            // Establecer conexión a la base de datos
            Connection connection = DatabaseConnection.getInstance().getConnection();

            // Crear un alumno
            Alumno alumno = new Alumno(2, "Juan", "Pérez", 20);
            GenericDAO<Alumno> alumnoDAO = new GenericDAO<>(connection);
            alumnoDAO.create(alumno);
            System.out.println("Alumno creado correctamente");

            // Crear un profesor
            Profesor profesor = new Profesor(2, "María", "González", 35);
            GenericDAO<Profesor> profesorDAO = new GenericDAO<>(connection);
            profesorDAO.create(profesor);
            System.out.println("Profesor creado correctamente");

            // Crear una materia
            Materias materia = new Materias(4, "Redes", "Redes y protocolos", 6);
            GenericDAO<Materias> materiaDAO = new GenericDAO<>(connection);
            materiaDAO.create(materia);
            System.out.println("Materia creada correctamente");
            
         // Crear un horario
            Horarios horario = new Horarios(4, 2, 20, "18:00", "20:00", "Miercoles");
            GenericDAO<Horarios> horarioDAO = new GenericDAO<>(connection);
            horarioDAO.create(horario);
            System.out.println("Horario creado correctamente");

            // Cerrar la conexión a la base de datos
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
