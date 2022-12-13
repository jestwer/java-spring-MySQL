package org.hibernate.DAO;

import java.util.List;

import org.hibernate.Entity.Car;

public interface ShowDao {
	public List<Car> showAllInfo();
	public Car showCarAsId(int id);
	public String deleteCar(int id);
	public String createCar(Car car);
}

