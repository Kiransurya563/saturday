package servletm1_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servletm1_crud.dto.StudentDto;

public class StudentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public String insert(StudentDto s) {
		et.begin();
		em.persist(s);
		et.commit();
		return "data inserted successfully";
	}

	public Object fetchById(int id) {
		StudentDto dto = em.find(StudentDto.class, id);
		if (dto != null) {
			return dto;
		} else
			return "no data found";
	}

	public List<StudentDto> fetchAll() {
		// select variable_name from table_name variable_name
		Query q = em.createQuery("select data from StudentDto data");
		List<StudentDto> list = q.getResultList();
		if (list.isEmpty()) {
			return null;
		} else
			return list;
	}

	public String deleteById(int id) {
		StudentDto dto = em.find(StudentDto.class, id);
		if (dto != null) {
			et.begin();
			em.remove(dto);
			et.commit();
			return "data deleted";
		} else
			return "no data found";
	}

	public String deleteAll() {
		Query q = em.createQuery("select data from StudentDto data");
		List<StudentDto> list = q.getResultList();
		if (list.isEmpty()) {
			return "no data found";
		} else {
			for (StudentDto b : list) {
				et.begin();
				em.remove(b);
				et.commit();
			}
			return "data deleted";
		}
	}

}
