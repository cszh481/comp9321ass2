package dao.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import dao.BaseDao;

public class BaseDaoTest {

	@Test
	public void testGetConnection() {
//		fail("Not yet implemented");
		Connection connection = BaseDao.getConnection();
		assertTrue(connection != null);
	}

}
