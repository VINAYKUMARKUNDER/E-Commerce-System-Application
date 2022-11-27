package com.shopping.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shopping.model.CurrentAdminSession;


public interface CurrentAdminSessionRepository extends JpaRepository<CurrentAdminSession, Integer>{

	public CurrentAdminSession findByUuid(String uuid);

	@Query("from CurrentAdminSession c where c.UserId=?1")
	public Optional<CurrentAdminSession> findByUserId(Integer id);
	
}
