package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class PersistApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();

				employee.setEid(3);
				employee.setEname("Dravid");
				employee.setEcompany("India");
				employee.setEcity("BLR");
				session.persist(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved successfully");
			} else {
				transaction.rollback();
				System.out.println("Object insertion failed");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}

	}

}
