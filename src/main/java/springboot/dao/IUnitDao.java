package springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.model.Unit;

public interface IUnitDao extends JpaRepository<Unit, Long> {

	@Query(value = "SELECT u.* FROM tb_unit u WHERE u.unit_id = :unit_name", nativeQuery = true)
	public Unit findByName(@Param("unit_name") String unitName);

}
