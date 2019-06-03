package springboot.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.UnitBeanInOut;
import springboot.model.Unit;
import springboot.service.IUnitService;

@RestController
@RequestMapping("/api/v1")
public class UnitWeb {
	
	@Autowired
	private IUnitService iUnitService;
	
	@GetMapping("/units")
	public List<Unit> getUnit(){
		return this.iUnitService.getUnit();
	}
	
	@PostMapping("/units")
	public Unit getUnitName(@Valid @RequestBody UnitBeanInOut bean) {
		String unitName = bean.getUnitName();
		
		return this.iUnitService.getUnitName(unitName);
	}
	
	
	

}
