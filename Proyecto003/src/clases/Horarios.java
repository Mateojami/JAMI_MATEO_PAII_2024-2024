package clases;

public class Horarios {

	int id_mat;
	int id_alumnos;
	int id_profesor;
	String hora_inicio;
	String hora_fin;
	String day;
	
	public Horarios(int id_mat, int id_alumnos, int id_profesor, String hora_inicio, String hora_fin, String day) {
		super();
		this.id_mat = id_mat;
		this.id_alumnos = id_alumnos;
		this.id_profesor = id_profesor;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
		this.day = day;
	}

	public int getId_mat() {
		return id_mat;
	}

	public void setId_mat(int id_mat) {
		this.id_mat = id_mat;
	}

	public int getId_alumnos() {
		return id_alumnos;
	}

	public void setId_alumnos(int id_alumnos) {
		this.id_alumnos = id_alumnos;
	}

	public int getId_profesor() {
		return id_profesor;
	}

	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	
	


}
