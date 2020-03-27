package co.two.lecture.dto;

public class LectureDto {
	private int course_id;
	private String professor_code;
	private String subject_code;
	private String lacture_room;
	private String professor_name;
	private String subject_name;

	public LectureDto() {
	}

	public int getCourse_id() {
		return course_id;
	}

	public String getProfessor_code() {
		return professor_code;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public String getLacture_room() {
		return lacture_room;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public void setProfessor_code(String professor_code) {
		this.professor_code = professor_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public void setLacture_room(String lacture_room) {
		this.lacture_room = lacture_room;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

}
