package com.edu.DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.User;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void delete(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		} catch (Exception ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public User getUser(String userName) {
		final Session session = sessionFactory.openSession();
		final User user = (User) session.get(User.class, userName);
		session.close();
		return user;
	}

	public List<User> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(User.class).list();
		session.close();
		return list;
	}

	public List<User> getUser(String userName, String password) {
		final Session session = sessionFactory.openSession();
		final String query = "select * from user where userName= :user_name and password= :pass";
		final SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setString("user_name", userName);
		sqlQuery.setString("pass", password);
		final List list = sqlQuery.list();
		session.close();
		return list;
	}
}
