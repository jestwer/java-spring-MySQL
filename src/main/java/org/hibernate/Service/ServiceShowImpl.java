package org.hibernate.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.DAO.ShowAllData;
import org.hibernate.Entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ServiceShowImpl implements ServiceShow{
	
	private ShowAllData show;
	
	@Autowired
	ServiceShowImpl(ShowAllData show){
		this.show = show;
	}

	@Override
	public List<Car> showAllInfo() {
		List<Car> cars = show.showAllInfo();
		return cars;
	}

	@Override
	public Car showCarAsId(int id) {
		Car car= show.showCarAsId(id);
		return car;
	}

	@Override
	public String deleteCar(int id) {
		return show.deleteCar(id);
	}

	@Override
	public String createCar(Car car) {
		return show.createCar(car);
	}

}
