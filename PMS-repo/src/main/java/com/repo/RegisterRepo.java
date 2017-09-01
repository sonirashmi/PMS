package com.repo;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.UserLogin;

@Repository
public class RegisterRepo {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public String registerUserRepo(UserLogin usr) {
		hibernateTemplate.save(usr);
	return "Saved";
	}
	
	//===============================================================
	public boolean isUserAlreayExits(UserLogin usr) {
		List list=hibernateTemplate.find("from UserLogin where mailId=?",usr.getMailId());
		if(list.isEmpty())
			return true;
		else 
			return false;
	}
}
