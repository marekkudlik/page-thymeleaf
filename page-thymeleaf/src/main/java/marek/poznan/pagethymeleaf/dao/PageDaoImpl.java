package marek.poznan.pagethymeleaf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import marek.poznan.pagethymeleaf.entity.Page;

@Repository
public class PageDaoImpl implements PageDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Page> findAll() {
		Session theSession = entityManager.unwrap(Session.class);
		Query theQuery = theSession.createQuery("from Page", Page.class);
		List<Page> thePage = theQuery.getResultList();		
		
		return thePage;
	}

	@Override
	public void save(Page thePage) {
		Session theSession = entityManager.unwrap(Session.class);
		theSession.saveOrUpdate(thePage);
		
		
	}
	
}
