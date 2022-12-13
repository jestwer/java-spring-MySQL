package org.hibernate.DAO;

import static org.hamcrest.CoreMatchers.endsWith;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ShowAllData implements ShowDao{
	
	@Autowired
	private EntityManager manager;
	

	@Override
	public List<Car> showAllInfo() {
		Session session = manager.unwrap(Session.class);
		Query query = manager.createQuery("from Car");
		List<Car> entity = query.getResultList();
		String result = "";
		for (Car carEntity : entity) {
			result += carEntity.toString();
		}
		return entity;
	}


	@Override
	public Car showCarAsId(int id) {
		Car car = manager.find(Car.class, id);
		return car;
	}


	@Override
	public String deleteCar(int car) {
		int result = manager.createQuery("delete from Car c where c.id =:id").setParameter("id", car).executeUpdate();		
		return Integer.toString(result);
	}


	@Override
	public String createCar(Car car) {
		try {
			manager.persist(car);
			return "Added car" + car.getName();
		}catch(Exception ex) {
			return "Can't add";
		}
		
	}


}
