package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;




public class UsuarioDaoImpl implements UsuarioDao {


	private SessionFactory sessionFactory = null;
	private Session session = null;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}


	public Usuario getUser(String username) throws Exception  {
		try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Usuario user = (Usuario) session.createQuery("from USUARIOS where USERNAME=:username").setParameter("username", username).uniqueResult();
            return user;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            session.flush();
            session.close();
        }
}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
