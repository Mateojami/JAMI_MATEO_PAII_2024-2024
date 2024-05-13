package models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
	@Id
	private int id_sub;
	
	@Column(name="id_student")
	private int id_student;

	@Column(name="id_profesor")
	private int id_profesor;

	@Column(name="hora_inicio")
	private Time hora_inicio;
	
	@Column(name="hora_fin")
	private Time hora_fin;
	
	public Schedule() {
		
	}

	public Schedule(int id_sub, int id_student, int id_profesor, Time hora_inicio, Time hora_fin) {
		super();
		this.id_sub = id_sub;
		this.id_student = id_student;
		this.id_profesor = id_profesor;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public int getId_sub() {
		return id_sub;
	}

	public void setId_sub(int id_sub) {
		this.id_sub = id_sub;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Time hora_fin) {
		this.hora_fin = hora_fin;
	}

	
	

}