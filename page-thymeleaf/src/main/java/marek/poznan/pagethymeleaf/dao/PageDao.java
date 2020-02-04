package marek.poznan.pagethymeleaf.dao;

import java.util.List;

import marek.poznan.pagethymeleaf.entity.Page;

public interface PageDao {


	public List<Page> findAll();

	public void save(Page thePage);

	public void deleteById(int theId);

}
