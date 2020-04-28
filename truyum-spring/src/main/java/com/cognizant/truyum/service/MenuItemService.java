package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.Repository.MenuItemRepository;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;


@Service("menuItemService")
public class MenuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
	
	public void setMenuItemDao(MenuItemDao menuItemdao) {
		this.menuItemDao=menuItemdao;
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin(){
		LOGGER.info("start");
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer(){
		LOGGER.info("start");
		return menuItemRepository.findByActiveAndDateOfLaunchLessThan(true,new Date());
	}
	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("start");
		return menuItemRepository.getOne(menuItemId);
	}
	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("start");
		 menuItemRepository.save(menuItem);
	}
	
	
	
	
}
