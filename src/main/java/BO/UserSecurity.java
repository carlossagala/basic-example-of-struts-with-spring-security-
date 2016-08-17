package BO;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import DAO.UsuarioDao;
import DAO.UsuarioDaoImpl;
import models.Rol;
import models.Usuario;

public class UserSecurity implements UserDetailsService {

	private UsuarioDao dao;
	
	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Usuario user = null;
	        try {
	            user = dao.getUser(username);
	            if (user == null) {
	                throw new UsernameNotFoundException("user not found");
	            }
	        } catch (Exception e) {
	            throw new EntityNotFoundException(e.getCause().getMessage());
	        }
	        String uname = user.getUsername();
	        String password = user.getPassword();
	        boolean enabled = Boolean.TRUE;
	        boolean accountNonExpired = Boolean.TRUE;
	        boolean credentialsNonExpired = Boolean.TRUE;
	        boolean accountNonLocked = Boolean.TRUE;
	        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       
	            Rol role = user.getRol();
	            authorities.add(new SimpleGrantedAuthority(role.getRol()));
	        return new org.springframework.security.core.userdetails.User(
	                uname, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    }
		
	}


