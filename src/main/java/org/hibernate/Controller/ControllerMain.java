package org.hibernate.Controller;

import java.math.BigDecimal;
import java.net.http.HttpResponse;
import java.util.List;

import org.hibernate.NotFounder;
import org.hibernate.Entity.Car;
import org.hibernate.Service.ServiceShowImpl;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ControllerMain {
	@Autowired
	private ServiceShowImpl show;
	
	@GetMapping("/show")
	public ModelAndView getAll(Model model){
		List<Car> cars = show.showAllInfo();
		model.addAttribute("cars",cars);
		model.addAttribute("car",new Car());
		return new ModelAndView("car_dot");
	}
	@GetMapping("/getResult")
	public ModelAndView getById(@RequestParam int id,Model model){
		System.out.println(id);
		if(id!=0) {
			Car car = show.showCarAsId(id);
			model.addAttribute("cars",car);
			return new ModelAndView("showCarById");
		}else {
			NotFounder notFound = new NotFounder();
			model.addAttribute("cars",notFound);
			return new ModelAndView("showCarById");
		}
	}
	@RequestMapping("/get")
	public ModelAndView getAddPage(Model model) {
		model.addAttribute("car",new Car());
		return new ModelAndView("getCarById");
	}
	
	
	@GetMapping("/del")
	public ModelAndView delById(@RequestParam int id,Model model){
		String res = show.deleteCar(id);
		if(res.equals("1")) {
			res="Куплен!";
		}
		else {
			res="Произошла ошибка(";
		}
		model.addAttribute("car",res);
		return new ModelAndView("ResulDel");
	}
	@RequestMapping("/create")
	public ModelAndView create(Model model) {
		model.addAttribute("car",new Car());
		return new ModelAndView("AddCar");
	}
	@PostMapping("/createCar")
	public RedirectView createCar(@RequestParam BigDecimal price,String model,String age,String name,String creator_name){
		Car car = new Car();
		car.setPrice(price);
		car.setAge(age);
		car.setName(name);
		car.setModel(model);
		car.setCreator_name(creator_name);
		
		show.createCar(car);
		return new RedirectView("show");
	}

	
}
