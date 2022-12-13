package org.hibernate.Service;

import java.util.List;

import org.hibernate.Entity.Car;

public interface ServiceShow {
	public List<Car> showAllInfo();
	public Car showCarAsId(int id);
	public String deleteCar(int id);
	public String createCar(Car car);

}
