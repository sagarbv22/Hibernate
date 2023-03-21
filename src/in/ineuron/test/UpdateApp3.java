package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class UpdateApp3 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer row = 0;
		Employee employee = null;
		Integer id = 3;
		try {

			session = HibernateUtil.getSession();

			if (session != null) {
				transaction = session.beginTransaction();
				employee = session.get(Employee.class, id);
			}

			if (transaction != null) {

				if (employee != null) {
					employee.setEcompany("Bengaluru");
					flag = true;//updating the record without update()-> Sysnchronization exist b/w row and object
				}
				else
					System.out.println("Object Not Found!..");
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
