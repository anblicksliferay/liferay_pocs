package com.aptiv.commonservices.service;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aptiv.commonservices.dao.AreaCellDao;
import com.aptiv.commonservices.service.impl.AreaCellServiceImplPOC;
import com.aptiv.commonservices.service.model.AreaModel;

public class AreaCellServiceTest {

	@Mock
	private AreaCellDao daoMock;

	@InjectMocks
	private AreaCellServicePOC service = new AreaCellServiceImplPOC();
	
//	@Captor
//	private ArgumentCaptor<Area> customerArgument;

	public AreaCellServiceTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Ignore
	@Test
	public void testGetArea_returnsNewArea() {
		when(daoMock.getArea(5)).thenReturn(new AreaModel(5, "MyArea"));
		assertSame(service.getArea(5).getStringVariable(), "MyArea");

//		assertThat(service.getArea(5), is(notNullValue()));
	}

//	@Before
//	public void initialize() {
//	}

//	@Test
//	public void getAreaTest() {
//		AreaCellService areaCellService = new AreaCellServiceImpl();
//		// System.out.println("int variable is: " +
//		// areaCellService.getArea(5).getIntVariable());
//		// System.out.println("int variable is: " +
//		// areaCellService.getArea(5).getStringVariable());
//		assertTrue(areaCellService.getArea(5).getIntVariable() == 5);
//		assertTrue(areaCellService.getArea(5).getStringVariable().equals("Testing message. "));
//	}
	
	

}
