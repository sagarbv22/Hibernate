package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class LoadApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Employee employee = null;
		Integer id = 3;
		try {

			session = HibernateUtil.getSession();

			if (session != null)
				employee = session.load(Employee.class, id);

			System.out.println("\neid         - " + employee.getEid());
			System.in.read();
			System.out.println("ename       - " + employee.getEname());
			System.out.println("ecompany    - " + employee.getEcompany());
			System.out.println("ecity       - " + employee.getEcity());

		} catch (ObjectNotFoundException e) {
			System.out.println("Object not found for this ID:: " + id);
		}

		catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
