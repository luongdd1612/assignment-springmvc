package com.edu.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.edu.model.LoaiSP;

@Repository
public class LoaiSPDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdate(LoaiSP loaiSP) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(loaiSP);
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

	public void delete(LoaiSP loaiSP) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(loaiSP);
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

	public LoaiSP getLoaiSP(String maLoai) {
		final Session session = sessionFactory.openSession();
		final LoaiSP loaiSP = (LoaiSP) session.get(LoaiSP.class, maLoai);
		session.close();
		return loaiSP;
	}

	public List<LoaiSP> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(LoaiSP.class).list();
		session.close();
		return list;
	}

}
