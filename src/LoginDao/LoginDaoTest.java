package LoginDao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nkba.dao.LoginDao;

public class LoginDaoTest {

	@Test
	public void test() {
		assertTrue(LoginDao.validate("roshankamathfeb6@gmail.com","password"));
	}

}
