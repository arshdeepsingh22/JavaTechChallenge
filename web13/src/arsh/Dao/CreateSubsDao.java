package arsh.Dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import arsh.Bean_Classes.*;
import arsh.util.DBConnectionManager;

public class CreateSubsDao {
	
	
	public void createSubs(Bean bean){
		
		Connection conn = (Connection) DBConnectionManager.getConnection();
	String sql = "INSERT INTO market_place(partner,baseUrl,uuid,openId,email) VALUES (?,?,?,?,?) ";
	String sql2 = "INSERT INTO company(uuid,name,email,phone,website,country,marketplaceuuid) VALUES (?,?,?,?,?,?,?) ";
	String sql3 = "INSERT INTO account(accountIdentifier,status,companyUuid,applicationUuid) VALUES (?,?,?,?) ";
	String sql4 = "INSERT INTO user(uuid,firstname,lastname,email,accountIdentifier) VALUES (?,?,?,?,?) ";
	String sql5 = "INSERT INTO order(editionCode,pricingDuration,unit,quantity,userUuid) VALUES (?,?,?,?,?) ";
	try{
		  
		  PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
   		  pstmt.setString(1, bean.getMarketplace().getPartner());
   		  
          pstmt.setString(2, bean.getMarketplace().getBaseUrl());
          pstmt.setString(3, bean.getCreator().getUuid());
          pstmt.setString(4, bean.getCreator().getOpenId());
          pstmt.setString(5, bean.getCreator().getEmail());
          pstmt.executeUpdate();
          System.out.println("MarketPlaceDao");
          PreparedStatement pstmt2 = (PreparedStatement) conn.prepareStatement(sql2);
   		  pstmt2.setString(1, bean.getPayload().getCompany().getUuid());
          pstmt2.setString(2, bean.getPayload().getCompany().getName());
          pstmt2.setString(3, bean.getPayload().getCompany().getEmail());
          pstmt2.setString(4, bean.getPayload().getCompany().getPhoneNumber());
          pstmt2.setString(5, bean.getPayload().getCompany().getWebsite());
          pstmt2.setString(6, bean.getPayload().getCompany().getCountry());
          pstmt2.setString(7, bean.getCreator().getUuid());
 		  System.out.println("CompanyDao");
          pstmt2.executeUpdate();
          if( bean.getPayload().getAccount() != null)
          {
          PreparedStatement pstmt3 = (PreparedStatement) conn.prepareStatement(sql3);
   		  pstmt3.setString(1, bean.getPayload().getAccount().getAccountIdentifier());
          pstmt3.setString(2, bean.getPayload().getAccount().getStatus());
          pstmt3.setString(3, bean.getPayload().getCompany().getUuid());
          pstmt3.setString(4, bean.getApplicationUuid());
          System.out.println("AccountDao");
          pstmt3.executeUpdate();
          }
          if(bean.getPayload().getUser() != null)
          {
          PreparedStatement pstmt4 = (PreparedStatement) conn.prepareStatement(sql4);
   		  pstmt4.setString(1, bean.getPayload().getUser().getUuid());
          pstmt4.setString(2,bean.getPayload().getUser().getFirstName());
          pstmt4.setString(3, bean.getPayload().getUser().getLastName());
          pstmt4.setString(4, bean.getPayload().getUser().getEmail());
          pstmt4.setString(5, bean.getPayload().getAccount().getAccountIdentifier());
          System.out.println("UserDao");
          pstmt4.executeUpdate();
          }
//          PreparedStatement pstmt5 = (PreparedStatement) conn.prepareStatement(sql5);
//   		  pstmt5.setString(1, bean.getPayload().getOrder().getEditionCode());
//          pstmt5.setString(2,bean.getPayload().getOrder().getPricingDuration());
//          pstmt5.setString(3, bean.getPayload().getOrder().getItems());
//          pstmt5.setString(4, bean.getPayload().getUser().getEmail());
//          pstmt5.setString(5, bean.getPayload().getAccount().getAccountIdentifier());
//          System.out.println("OrderDao");
//          pstmt5.executeUpdate();
         
	  
	  }
	  catch(SQLException e)
      {

      }
	}
	
	
}
