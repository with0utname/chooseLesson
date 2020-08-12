package tu.dao;

public interface LoginDao {
	public boolean check(String username,String password,String role);
}
