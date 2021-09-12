package com.pcwk.ehr.menuscore;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuScoreServiceImpl implements MenuScoreService {
	
	@Autowired
	MenuScoreDao menuScoreDao;
	
	public MenuScoreServiceImpl(MenuScoreDao menuScoreDao) {
		this.menuScoreDao = menuScoreDao;
	}
	
	@Override
	public void menuScoreInsert(MenuScoreVO score) throws Exception {
		menuScoreDao.menuScoreInsert(score);
	
	}

	@Override
	public void menuScoreDelete(MenuScoreVO score) throws Exception {
		menuScoreDao.menuScoreDelete(score);
	}

	@Override
	public void menuScoreUpdate(MenuScoreVO score) throws Exception {
		menuScoreDao.menuScoreUpdate(score);
	}

	@Override
	public int menuScoreAvg(MenuScoreVO score) throws Exception {
		return menuScoreDao.menuScoreAvg(score);
	}

	@Override
	public int menuScoreCount(MenuScoreVO score) throws Exception {
		return menuScoreDao.menuScoreCount(score);
	}

}
