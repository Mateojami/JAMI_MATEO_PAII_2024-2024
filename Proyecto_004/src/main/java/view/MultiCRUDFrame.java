package view;

import javax.swing.*;
import org.hibernate.SessionFactory;
import dao.StudentDAO;
import dao.ProfessorDAO;
import dao.SubjectDAO; 
import models.Student;
import models.Professor;
import models.Subject; 

public class MultiCRUDFrame extends JFrame {

    private JTextField idField, nameField, lastnameField, ageField, descriptionField, levelField;
    private JButton createButton, readButton, updateButton, deleteButton;
    private JComboBox<String> entityTypeComboBox;
    private JLabel idLabel;

    private StudentDAO studentDAO;
    private ProfessorDAO professorDAO;
    private SubjectDAO subjectDAO; 

    public MultiCRUDFrame(SessionFactory sessionFactory) {
        super("CRUD Operations");

        studentDAO = new StudentDAO(sessionFactory);
        professorDAO = new ProfessorDAO(sessionFactory);
        subjectDAO = new SubjectDAO(sessionFactory); 

        idField = new JTextField(10);
        nameField = new JTextField(10);
        lastnameField = new JTextField(10);
        ageField = new JTextField(10);
        descriptionField = new JTextField(20); 
        levelField = new JTextField(10); 
        entityTypeComboBox = new JComboBox<>(new String[]{"Student", "Professor", "Subject"}); 
        entityTypeComboBox.addActionListener(e -> updateFields());
        idLabel = new JLabel("ID:");

        createButton = new JButton("Create");
        readButton = new JButton("Read");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        createButton.addActionListener(e -> createEntity());
        readButton.addActionListener(e -> readEntity());
        updateButton.addActionListener(e -> updateEntity());
        deleteButton.addActionListener(e -> deleteEntity());

        JPanel panel = new JPanel();
        setSize(600, 400);
        panel.add(new JLabel("Entity Type:"));
        panel.add(entityTypeComboBox);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Lastname:"));
        panel.add(lastnameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Level:"));
        panel.add(levelField);
        panel.add(createButton);
        panel.add(readButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        updateFields();
    }

    private void updateFields() {
        String selectedEntity = (String) entityTypeComboBox.getSelectedItem();
        idLabel.setText(selectedEntity + " ID:");

        // Cambiar los campos según la entidad seleccionada
        if (selectedEntity.equals("Student") || selectedEntity.equals("Professor")) {
            ageField.setEnabled(true); // Habilitar el campo de edad
            lastnameField.setEnabled(true); // Habilitar el campo de apellido
            descriptionField.setEnabled(false); // Deshabilitar el campo de descripcion
            levelField.setEnabled(false); // Deshabilitar el campo de level
        } else if (selectedEntity.equals("Subject")) {
        	descriptionField.setEnabled(true); // habilitar el campo de descripcion
            levelField.setEnabled(true); // habilitar el campo de level
            ageField.setEnabled(false); // Deshabilitar el campo de edad
            lastnameField.setEnabled(false); // Deshabilitar el campo de apellido
        }
    }

    private void createEntity() {
        String selectedEntity = (String) entityTypeComboBox.getSelectedItem();
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String lastname = lastnameField.getText();
        
        int age = 0; // Valor predeterminado
        if (!ageField.getText().isEmpty()) {
            try {
                age = Integer.parseInt(ageField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age value. Please enter a valid number.");
                return; // Salir del método si ocurre una excepción
            }
        }
        
        String description = descriptionField.getText();
        
        int level = 0; // Valor predeterminado
        if (!levelField.getText().isEmpty()) {
            try {
                level = Integer.parseInt(levelField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid level value. Please enter a valid number.");
                return; // Salir del método si ocurre una excepción
            }
        }

        if (selectedEntity.equals("Student")) {
            Student student = new Student(id, name, lastname, age);
            studentDAO.create(student);
        } else if (selectedEntity.equals("Professor")) {
            Professor professor = new Professor(id, name, lastname, age);
            professorDAO.create(professor);
        } else if (selectedEntity.equals("Subject")) {
            Subject subject = new Subject(id, name, description, level); 
            subjectDAO.create(subject);
        }

        clearFields();
    }


    private void readEntity() {
        String selectedEntity = (String) entityTypeComboBox.getSelectedItem();
        int id = Integer.parseInt(idField.getText());

        if (selectedEntity.equals("Student")) {
            Student student = studentDAO.read(id);
            if (student != null) {
                nameField.setText(student.getName());
                lastnameField.setText(student.getLastname());
                ageField.setText(String.valueOf(student.getAge()));
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
                clearFields();
            }
        } else if (selectedEntity.equals("Professor")) {
            Professor professor = professorDAO.read(id);
            if (professor != null) {
                nameField.setText(professor.getName());
                lastnameField.setText(professor.getLastname());
                ageField.setText(String.valueOf(professor.getAge()));
            } else {
                JOptionPane.showMessageDialog(this, "Professor not found.");
                clearFields();
            }
        } else if (selectedEntity.equals("Subject")) {
            Subject subject = subjectDAO.read(id);
            if (subject != null) {
                nameField.setText(subject.getName());
                descriptionField.setText(subject.getDescription());
                levelField.setText(String.valueOf(subject.getLevel()));
            } else {
                JOptionPane.showMessageDialog(this, "Subject not found.");
                clearFields();
            }
        }
    }


    private void updateEntity() {
        String selectedEntity = (String) entityTypeComboBox.getSelectedItem();
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String lastname = lastnameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String description = descriptionField.getText();
        int level = Integer.parseInt(levelField.getText());


        if (selectedEntity.equals("Student")) {
            Student student = new Student(id, name, lastname, age);
            studentDAO.update(student);
        } else if (selectedEntity.equals("Professor")) {
            Professor professor = new Professor(id, name, lastname, age);
            professorDAO.update(professor);
        } else if (selectedEntity.equals("Subject")) {
            Subject subject = new Subject(id, name, description, level);
            subjectDAO.update(subject);
        }
    }

    private void deleteEntity() {
        String selectedEntity = (String) entityTypeComboBox.getSelectedItem();
        int id = Integer.parseInt(idField.getText());

        if (selectedEntity.equals("Student")) {
            Student student = new Student();
            student.setId(id);
            studentDAO.delete(student);
        } else if (selectedEntity.equals("Professor")) {
            Professor professor = new Professor();
            professor.setId(id);
            professorDAO.delete(professor);
        } else if (selectedEntity.equals("Subject")) {
            Subject subject = new Subject();
            subject.setId(id);
            subjectDAO.delete(subject);
        }

        clearFields();
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        lastnameField.setText("");
        ageField.setText("");
        descriptionField.setText("");
        levelField.setText("");
    }
}
