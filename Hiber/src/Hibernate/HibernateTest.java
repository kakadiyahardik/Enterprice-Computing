package Hibernate;

//import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Demo.Employee;

public class HibernateTest {

	public static void main(String[] args) 
	{
		Employee em=new Employee();
		em.setEmployeeId(3);
		em.setEmployeeName("Hakker");
		
		SessionFactory sessionfac=new Configuration().configure().buildSessionFactory();
		Session session=sessionfac.openSession();
		session.beginTransaction();
		session.save(em);
		session.getTransaction().commit();
		session.close();
	}

}
