package com.cognizant.truyum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.service.MenuItemService;

public class App {
	@Autowired
	static MenuItemService menuItemService;
	private static ApplicationContext context;
    public static void main( String[] args ){
    	context = new ClassPathXmlApplicationContext("spring-config.xml");
    	menuItemService = context.getBean(MenuItemService.class);
        System.out.println(menuItemService.getMenuItemListAdmin());
    }
}
