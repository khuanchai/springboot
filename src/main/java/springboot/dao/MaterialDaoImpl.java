package springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.model.Material;
import springboot.model.Unit;

@Repository
public class MaterialDaoImpl implements IMaterialDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Material> findAll() {
		Session session = this.entityManager.unwrap(Session.class);
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT M.*,T.type_material_tname AS typeMaterialTname");
		sql.append(" FROM tb_material M LEFT JOIN tb_type_material T ");
		sql.append(" ON M.type_material_id = T.type_material_id ");
		sql.append(" WHERE M.material_action = 1 ");
		Query query = session.createSQLQuery(sql.toString())
				.addScalar("typeMaterialTname",StringType.INSTANCE)
				.addEntity(Material.class);
				
		
		return query.getResultList();
	}

}
