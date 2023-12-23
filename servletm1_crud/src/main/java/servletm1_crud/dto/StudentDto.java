package servletm1_crud.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

//entity class or dto class
@Entity
public class StudentDto {
	@Id
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + "]";
	}
}
