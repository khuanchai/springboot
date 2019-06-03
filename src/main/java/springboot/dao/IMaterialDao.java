package springboot.dao;

import java.util.List;

import springboot.model.Material;

public interface IMaterialDao {
	
	public List<Material> findAll();

}
