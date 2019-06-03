package springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.dao.IUnitDao;
import springboot.model.Unit;

@Transactional
@Service
public class UnitServiceImpl implements IUnitService {

	@Autowired
	private IUnitDao iUnitDao;

	@Override
	public List<Unit> getUnit() {
		return this.iUnitDao.findAll();
	}

	@Override
	public Unit getUnitName(String unitName) {
		System.out.println(unitName);
		Unit result = this.iUnitDao.findByName(unitName);
		// System.out.println(result.toString());
		return result;
	}

}
