package marek.poznan.pagethymeleaf.service;

import java.util.List;

import marek.poznan.pagethymeleaf.entity.Page;

public interface PageService {

	public List<Page> findAll();

	public void save(Page thePage);

	public void deleteById(int theId);
}
