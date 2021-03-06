package marek.poznan.pagethymeleaf.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import marek.poznan.pagethymeleaf.dao.PageDao;
import marek.poznan.pagethymeleaf.entity.Page;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	private PageDao dao;

	@Override
	@Transactional
	public List<Page> findAll() {		
		return dao.findAll();
	}

	@Override
	@Transactional
	public void save(Page thePage) {
		dao.save(thePage);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		dao.deleteById(theId);
	}

	@Override
	@Transactional
	public Page findById(int theId) {		
		return dao.findById(theId);
	}

}
