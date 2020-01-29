package marek.poznan.pagethymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import marek.poznan.pagethymeleaf.dao.PageDao;
import marek.poznan.pagethymeleaf.entity.Page;

@Service
public class PageServiceImpl implements PageService{
	
	@Autowired
	private PageDao dao;

	@Override
	@Transactional
	public List<Page> findAll() {

		List<Page> page = dao.findAll();
		return page;
	}

	@Override
	@Transactional
	public void save(Page thePage) {
		dao.save(thePage);
	}
	
	

}
