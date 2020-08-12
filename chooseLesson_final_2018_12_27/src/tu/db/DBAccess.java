package tu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBAccess {
	private Connection conn = null;

	private Statement stmt = null;

	private ResultSet rs = null;

	private DataSource dataSource = null;

	private boolean debug = true;

	private String dbUrlStr = "jdbc:mysql://localhost:3306/sss?user=root&password=&useUnicode=true&characterEncoding=gbk&serverTimezone=GMT";

	private String driverName = "com.mysql.jdbc.Driver";

	public DBAccess() {
	}

	public DBAccess(boolean debug) {
		this.debug = debug;
	}

	public void setDbUrlParameter(String driverName, String hostName,
			String dbName, String port, String userName, String password,
			String characterEncoding) {
		if (driverName == null)
			driverName = "org.gjt.mm.mysql.Driver";
		else {
			this.driverName = driverName;
		}
		this.dbUrlStr = ("jdbc:mysql://" + hostName + ":" + port + "/" + dbName
				+ "?user=" + userName + "&" + "password=" + password
				+ "&useUnicode=true&characterEncoding=" + characterEncoding);
	}

	public Connection getConn() {
		if (this.conn == null) {
			getConnection();
		}
		return this.conn;
	}

	public void getConnection() {
		try {
			if (this.debug) {
				Class.forName(this.driverName);
				this.conn = DriverManager.getConnection(this.dbUrlStr);
				this.stmt = this.conn.createStatement();
			} else {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/nmsdb");

				this.conn = ds.getConnection();
				this.stmt = this.conn.createStatement();
			}
		} catch (NamingException ex1) {
			System.out.println("请检查数据库连接池配置是否正确！");
			ex1.printStackTrace();
		} catch (SQLException ex2) {
			System.out.println("请检查数据库是否启动！");
			ex2.printStackTrace();
		} catch (ClassNotFoundException ex3) {
			System.out.println("请检查数据库驱动程序是否正确！");
			ex3.printStackTrace();
		}
	}

	public void getConnection(DataSource dataSource) {
		try {
			this.conn = dataSource.getConnection();
			this.stmt = this.conn.createStatement();
		} catch (SQLException ex) {
			System.out.println("can't connect database" + ex.getMessage());
		}
	}

	public ResultSet query(String strSql) {
		System.out.println("sql:" + strSql);
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery(strSql);
			System.out.println("in DBAccess.query(),return");
			return rs;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	public boolean insert(String[] sqls) {
		boolean breturn = false;
		try {
			this.conn.setAutoCommit(false);
			for (int i = 0; i < sqls.length; i++) {
				if (sqls[i] != null) {
					this.stmt.addBatch(sqls[i]);
				}
			}
			this.stmt.executeBatch();
			this.conn.commit();
			this.conn.setAutoCommit(true);
			breturn = true;
		} catch (SQLException ex) {
		}
		return breturn;
	}

	public int executeSql(String strSql) {
		System.out.println("sql:" + strSql);
		int result = 0;
		try {
			this.stmt = this.conn.createStatement();
			result = this.stmt.executeUpdate(strSql);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return result;
	}

	public boolean executeSql(String[] sqls) {
		boolean breturn = false;
		try {
			this.conn.setAutoCommit(false);
			this.stmt = this.conn.createStatement();
			for (int i = 0; i < sqls.length; i++) {
				if (sqls[i] != null) {
					this.stmt.addBatch(sqls[i]);
				}
			}
			int[] aa = this.stmt.executeBatch();
			for (int i = 0; i < aa.length; i++) {
				this.conn.commit();
			}
			this.conn.setAutoCommit(true);
			breturn = true;
		} catch (SQLException ex) {
			System.out.println("insert date fail" + ex.getMessage());
		}
		return breturn;
	}

	public void closeConnection() {
		try {
			if (this.rs != null) {
				this.rs.close();
				this.rs = null;
			}
			if (this.stmt != null) {
				this.stmt.close();
				this.stmt = null;
			}
			if (this.conn != null) {
				this.conn.close();
				this.conn = null;
			}
			System.out.println("数据库连接关闭！");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getSysDate() {
		DBAccess dba = new DBAccess();
		String sql = "select sysdate() sysdate from dual ";
		try {
			dba.getConnection();
			ResultSet rs = dba.query(sql);
			String currentDate = null;
			if (rs.next()) {
				currentDate = rs.getString("sysdate");
			}
			String str1 = currentDate;
			return str1;
		} catch (SQLException ex) {
			String currentDate = null;
			return currentDate;
		} finally {
			dba.closeConnection();
		}
		 
	}

	 
}