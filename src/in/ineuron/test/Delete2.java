package in.ineuron.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class Delete2 {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = 3;
		Employee employee = null;

		session = HibernateUtil.getSession();
		if (session != null)
			employee = session.get(Employee.class, id);

		if (employee != null) {
			try {
				transaction = session.beginTransaction();

				if (transaction != null) {
					session.delete(employee);
					flag = true;
				}

			} catch (HibernateException e) {
				e.printStackTrace();
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Record deleted successfully");
				}
				else {
					transaction.rollback();
					System.out.println("Record deletion failed");
				}
			}
		} else
			System.out.println("Record Not found for deletion");

	}

}
