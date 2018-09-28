package com.aptiv.commonservices.service.impl;

import org.osgi.service.component.annotations.Component;

import com.aptiv.commonservices.dao.AreaCellDao;
import com.aptiv.commonservices.dao.impl.AreaCellDaoImpl;
import com.aptiv.commonservices.service.AreaCellServicePOC;
import com.aptiv.commonservices.service.model.AreaModel;

@Component(immediate = true, property = {
		// TODO enter required service properties
}, service = AreaCellServicePOC.class)
public class AreaCellServiceImplPOC implements AreaCellServicePOC {

	private AreaCellDao dao = new AreaCellDaoImpl();

	@Override
	public AreaModel getArea(int myVariable) {
		System.out.println("Reached line 15 getArea-Service IMPL");
		try {
			AreaModel model = dao.getArea(myVariable);
			model.setStringVariable("UpdatedModel");
			return model;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
