package marek.poznan.pagethymeleaf.dao;

import java.util.List;

import marek.poznan.pagethymeleaf.entity.Page;

public interface PageDao {

	List<Page> findAll();

	void save(Page thePage);

	void deleteById(int theId);
	
	Page findById(int id);

}
