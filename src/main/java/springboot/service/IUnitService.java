package springboot.service;

import java.util.List;

import springboot.model.Unit;


public interface IUnitService {
	
	public List<Unit> getUnit();
	public Unit getUnitName(String unitName);
}
