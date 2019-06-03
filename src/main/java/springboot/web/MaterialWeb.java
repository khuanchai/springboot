package springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Material;
import springboot.service.IMaterialService;

@RestController
@RequestMapping("/api/v1")
public class MaterialWeb {
	
	@Autowired
	private IMaterialService iMaterialService;

	@GetMapping("/materials")
	public List<Material> getMaterial() {
		return this.iMaterialService.getMaterial();
	}

}
