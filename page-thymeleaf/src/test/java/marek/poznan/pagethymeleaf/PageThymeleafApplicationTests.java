package marek.poznan.pagethymeleaf;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import marek.poznan.pagethymeleaf.dao.PageDaoImpl;
import marek.poznan.pagethymeleaf.entity.Page;
import marek.poznan.pagethymeleaf.service.PageServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class PageThymeleafApplicationTests {

	@Mock
	private PageDaoImpl daoMock;

	@InjectMocks
	private PageServiceImpl service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {
		Page thePage = new Page("Jan", "Jones", "good", "jones@gmail.com");

		service.save(thePage);
		verify(daoMock).save(thePage);

	}

	@Test
	public void testDelete() {
		service.deleteById(1);
		verify(daoMock).deleteById(1);

	}

	@Test
	public void testFindAll() {
		Page page = new Page("John", "Doe", "superb", "john@gmail.com");
		Page page1 = new Page("Adam", "Smith", "fantastic", "adam@gmail.com");
		List<Page> students = new ArrayList<Page>(Arrays.asList(page, page1));

		when(daoMock.findAll()).thenReturn(students);
		List<Page> result = service.findAll();
		verify(daoMock).findAll();
		assertEquals(students, result);
		assertEquals(2, result.size());
		assertEquals("John", result.get(0).getFirstName());
		assertEquals("john@gmail.com", result.get(0).getEmail());
		assertEquals("Smith", result.get(1).getLastName());
		assertEquals("fantastic", result.get(1).getOpinion());

	}

	@Test
	public void findByIdTest() {
		Page page = new Page(3, "John", "Doe", "superb", "john@gmail.com");

		when(daoMock.findById(3)).thenReturn(page);

		Page returned = service.findById(3);
		verify(daoMock, times(1)).findById(3);
		verifyNoMoreInteractions(daoMock);
		assertEquals(page, returned);

	}

}
