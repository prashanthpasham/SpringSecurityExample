package com.prashanth.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.prashanth.model.TestUsers;
@Repository
public class SpringSecurityDaoImpl implements SpringDaoInterface,
UserDetailsService
{
	@Autowired
	private SessionFactory sessionFactory;
    
	public String authenticateUser(TestUsers users) {
		// TODO Auto-generated method stub
		return "";
	}

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

         try {
	        Session session=sessionFactory.openSession();
	       Query qry= session.createQuery("select testUser,testPwd from TestUsers where testUser='"+arg0+"'");
	      List<Object[]> ls = qry.list();
	     if(ls.isEmpty())
	    	 throw new UsernameNotFoundException("user doesn't exist!");
	     else
	     {
	    	 List<SimpleGrantedAuthority> authList = new ArrayList<SimpleGrantedAuthority>();
	    	 authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	    	 User user = new User(ls.get(0)[0].toString(), ls.get(0)[1].toString(), authList); 
	       return user;
	     }
         }catch(Exception e)
          {
	      e.printStackTrace();
           }
		return null;
	}
	
	/* private List<SimpleGrantedAuthority> getAuthorities(String role) {
	        List<SimpleGrantedAuthority> authList = new ArrayList<>();
	        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
	 
	        //you can also add different roles here
	        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
	        //so that he can view pages that are ROLE_ADMIN specific
	        if (role != null && role.trim().length() > 0) {
	            if (role.equals("admin")) {
	                authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	            }
	        }
	 
	        return authList;
	    }*/

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

}
