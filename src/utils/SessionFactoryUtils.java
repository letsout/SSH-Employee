package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SessionFactoryUtils {
	@Test
	public void test() {
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory sessionFactory=cfg.buildSessionFactory();
	}
}
