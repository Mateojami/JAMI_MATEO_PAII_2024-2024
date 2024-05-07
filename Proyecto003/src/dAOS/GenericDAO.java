package dAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Alumno;
import clases.Horarios;
import clases.Materias;
import clases.Profesor;
import interfaces.IDAO;

public class GenericDAO<T> implements IDAO<T> {

    private final Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(T entity) throws SQLException {
        if (entity instanceof Alumno) {
            createAlumno((Alumno) entity);
        } else if (entity instanceof Profesor) {
            createProfesor((Profesor) entity);
        } else if (entity instanceof Materias) {
            createMaterias((Materias) entity);
        } else if (entity instanceof Horarios) {
            createHorarios((Horarios) entity);
        } else {
            throw new IllegalArgumentException("Entity type not supported.");
        }
    }

    @Override
    public T read(int id) throws SQLException {
     
        return null;
    }

    @Override
    public void update(T entity) throws SQLException {
        // Implementación del método update
        
    }

    @Override
    public void delete(int id) throws SQLException {
        // Implementación del método delete
       
    }

    @Override
    public List<T> getAll() throws SQLException {
        // Implementación del método getAll
        return new ArrayList<>();
    }

    private void createAlumno(Alumno alumno) throws SQLException {
        String query = "INSERT INTO alumno (idAlumno, name, lastname, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, alumno.getId());
            ps.setString(2, alumno.getName());
            ps.setString(3, alumno.getLast_name());
            ps.setInt(4, alumno.getAge());
            ps.executeUpdate();
        }
    }

    private void createProfesor(Profesor profesor) throws SQLException {
        String query = "INSERT INTO profesor (idProfesor, nameProfesor, lastnameProfesor, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, profesor.getId());
            ps.setString(2, profesor.getName());
            ps.setString(3, profesor.getLast_name());
            ps.setInt(4, profesor.getAge());
            ps.executeUpdate();
        }
    }

    private void createMaterias(Materias materias) throws SQLException {
        String query = "INSERT INTO materias (idMaterias, nameMateria, description, level) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, materias.getId());
            ps.setString(2, materias.getName());
            ps.setString(3, materias.getDescription());
            ps.setInt(4, materias.getLevel());
            ps.executeUpdate();
        }
    }
    
    private void createHorarios(Horarios horarios) throws SQLException{
		String query = "INSERT INTO horarios (idmat, idProfesor, idAlumnos, hora_inicio, hora_fin, dia) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, horarios.getId_mat());
            ps.setInt(2, horarios.getId_alumnos());
            ps.setInt(3, horarios.getId_profesor());
            ps.setString(4, horarios.getHora_inicio());
            ps.setString(5, horarios.getHora_fin());
            ps.setString(6, horarios.getDay());
            ps.executeUpdate();
        }
	}
}
