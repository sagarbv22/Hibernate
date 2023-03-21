package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateApp1 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer row = 0;

		try {

			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Employee employee = new Employee();
				employee.setEid(4); //programmer should remember the PK & if obj not found- OptimisticLockException
				employee.setEname("Rahul Dravid");
				employee.setEcompany("iNeuron");
				employee.setEcity("Blr");

				session.update(employee);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated successfully");
			} else {
				transaction.rollback();
				System.out.println("Object updation failed!..");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
