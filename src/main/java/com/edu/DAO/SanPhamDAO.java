package com.edu.DAO;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.model.LoaiSP;
import com.edu.model.SanPham;

@Repository
public class SanPhamDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveOrUpdate(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(sanPham);
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


	public SanPham getSanPhamById(int id) {
		final Session session = sessionFactory.openSession();
		final SanPham sanPham = (SanPham) session.get(SanPham.class, id);
		session.close();
		return sanPham;
	}

	public void delete(SanPham sanPham) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(sanPham);
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

	public List<SanPham> getAll() {
		final Session session = sessionFactory.openSession();
		final List list = session.createCriteria(SanPham.class).list();
		session.close();
		return list;
	}
	public List<SanPham> getSanPhamByLoai(String loaisp) {
		final Session session = sessionFactory.openSession();
		final String query = "FROM SanPham sp WHERE sp.loaisp.maLoai =:loaisp";
		final Query createQuery = session.createQuery(query);
		createQuery.setString("loaisp", loaisp);
		final List list = createQuery.list();
		session.close();
		return list;
	}
	public List<SanPham> search(String name) {
		final Session session = sessionFactory.openSession();
		final Criteria createCriteria = session.createCriteria(SanPham.class);
		createCriteria.add(Restrictions.eqOrIsNull("tenSP", name));
		final List list = createCriteria.list();
		session.close();
		return list;
	}
}
