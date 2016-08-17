package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private SessionFactory sessionFactory;
	private Session session;

	public Session openSession() {
		return sessionFactory.getCurrentSession();
	}

	public Usuario getUser(String username) throws Exception {
		try {

			session = sessionFactory.openSession();
			Usuario user = (Usuario) session.createQuery("from USUARIOS where USERNAME=:username")
					.setParameter("username", username).uniqueResult();
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
