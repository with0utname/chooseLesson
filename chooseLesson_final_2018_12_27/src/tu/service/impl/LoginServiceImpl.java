package tu.service.impl;

import tu.dao.LoginDao;
import tu.dao.impl.LoginDaoImpl;
import tu.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public boolean check(String userName,String password ,String role) {
		// TODO Auto-generated method stub
		LoginDao loginDao = new LoginDaoImpl();
		System.out.println("itsok");
		return loginDao.check(userName, password, role);
	}

}
