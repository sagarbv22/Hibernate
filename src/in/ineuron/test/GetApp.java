package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class GetApp {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 3;
		try {

			session = HibernateUtil.getSession();
			if (session != null) {

				Employee employee = session.get(Employee.class, id);

				if (employee != null) {
					System.out.println(employee);
				} else
					System.out.println("Record not found!..");

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
