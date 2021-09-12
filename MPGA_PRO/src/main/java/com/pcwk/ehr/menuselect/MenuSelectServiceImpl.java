package com.pcwk.ehr.menuselect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class MenuSelectServiceImpl implements MenuSelectService {
	
	@Autowired
	MenuSelectDao menuSelectDao;
	
	public MenuSelectServiceImpl(MenuSelectDao menuSelectDao) {
		this.menuSelectDao = menuSelectDao;
	}
	
	@Override
	public void menuSelectInsert(MenuSelectVO select) throws Exception {
		menuSelectDao.menuSelectInsert(select);
	}

	@Override
	public void menuSelectDelete(MenuSelectVO select) throws Exception {
		menuSelectDao.menuSelectDelete(select);
	}

	@Override
	public List<MenuSelectVO> menuSelectRead(MenuSelectVO select) throws Exception {		
		return menuSelectDao.menuSelectRead(select);
	}

}
