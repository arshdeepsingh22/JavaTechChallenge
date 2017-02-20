package arsh.Dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import arsh.Bean_Classes.Bean;
import arsh.util.DBConnectionManager;

public class CancelSubsDao {
public void cancelSubs(Bean bean){
		
		Connection conn = (Connection) DBConnectionManager.getConnection();
	String sql = "DELETE FROM company WHERE marketplaceuuid = ? ";
	try{
		  
		  PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
   		  pstmt.setString(1, bean.getCreator().getUuid());
          pstmt.executeUpdate();
          System.out.println("CompanyDaoDeleted");
	}
	catch(SQLException e)
    {

    }
}

}
