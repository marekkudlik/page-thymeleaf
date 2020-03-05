package marek.poznan.pagethymeleaf.service;

import java.util.List;

import marek.poznan.pagethymeleaf.entity.Page;

public interface PageService {

	List<Page> findAll();

	void save(Page thePage);

	void deleteById(int theId);

	Page findById(int theId);
}
