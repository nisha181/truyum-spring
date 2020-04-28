package com.cognizant.truyum.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

	public List<MenuItem> findByActiveAndDateOfLaunchLessThan(boolean active,Date dateOfLaunch);
}
