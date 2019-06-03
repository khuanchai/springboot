package springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.dao.IMaterialDao;
import springboot.model.Material;

@Transactional
@Service
public class MaterialServiceImpl implements IMaterialService {

	@Autowired
	private IMaterialDao iMaterialDao;

	@Override
	public List<Material> getMaterial() {
		return this.iMaterialDao.findAll();
	}

}
