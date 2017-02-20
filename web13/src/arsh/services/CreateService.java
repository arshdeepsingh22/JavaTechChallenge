package arsh.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import arsh.Bean_Classes.Bean;
import arsh.Dao.CreateSubsDao;
import arsh.util.DBConnectionManager;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class CreateService {
String url2;

public CreateService(String url) {
	this.url2 = url;
	System.out.println(url2); 
}

public void ServiceCreate() throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, JSONException {
	OAuthConsumer consumer = new DefaultOAuthConsumer("customaryshopofpune-148506", "3GpTxRMqDzCDf3wN"); 
    
	  URL hitLink = new URL(url2);
	 
	  HttpURLConnection requestNew = (HttpURLConnection) hitLink.openConnection();
	requestNew.setRequestProperty("Accept", "application/json");
	System.out.println("hello");
		consumer.sign(requestNew);
	    System.out.println("Response code is " + requestNew.getResponseCode());	
		BufferedReader in = new BufferedReader( new InputStreamReader(requestNew.getInputStream()));
	    StringBuilder sb = new StringBuilder();
		String inputLine;
	    while ((inputLine = in.readLine()) != null) 
	    	{
	    	sb.append("\n" + inputLine);
	    //	System.out.println(inputLine);
	    	}
	    String[] myArray = sb.toString().split(",");
	    for(String a:myArray)
	    {
	    	System.out.println(a);
	    }
		System.out.println(sb);
	    
	    String str = sb.toString();
	    String jsonString = str;
	    JSONObject obj = new JSONObject(jsonString);
	    String pageName = obj.getJSONObject("marketplace").getString("partner");
//	    System.out.println(pageName);
//	    JSONArray arr = obj.getJSONArray("posts");
//	    for (int i = 0; i < arr.length(); i++)
//	    {
//	        String post_id = arr.getJSONObject(i).getString("post_id");
//	        ......
//	    }
	    
	    Bean bean = new Bean();
	  
	    bean = new ObjectMapper().readValue(jsonString,Bean.class);
      	
      CreateSubsDao createSubsDao = new CreateSubsDao();    
      createSubsDao.createSubs(bean);
      
      
//	  compBean.setUuid(obj.getJSONObject("payload").getJSONObject("company").getString("uuid"));
//	  compBean.setName(obj.getJSONObject("payload").getJSONObject("company").getString("name"));
//	  compBean.setEmail(obj.getJSONObject("payload").getJSONObject("company").getString("email"));
//	  compBean.setPhoneNumber(obj.getJSONObject("payload").getJSONObject("company").getString("phoneNumber"));
//	  compBean.setCountry(obj.getJSONObject("payload").getJSONObject("company").getString("country"));
//	  compBean.setWebsite(obj.getJSONObject("payload").getJSONObject("company").getString("website"));	   
//	  Bean bean = new Bean();
//	  bean.setCompany(compBean);
	  

//      String sql = "INSERT INTO company(uuid,name,email)" + "VALUES (?,?,?) ";
//	  try{
//		  Connection conn = (Connection) DBConnectionManager.getConnection();
//          PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("INSERT INTO 'company' (uuid,name,email) VALUES (?,?,?)");
//     		  pstmt.setString(1, bean.getApplicationUuid());
//             pstmt.setString(2, bean.getFlag());
//             System.out.println(bean.getFlag());
//   		  pstmt.setString(3, bean.getReturnUrl());
//   		  System.out.println("herehere");
//               pstmt.executeUpdate();
//	  
//	  }
//	  catch(SQLException e)
//        {
//
//        }
//      String sql = "INSERT INTO market_place(partner,baseUrl,uuid,openId,email) VALUES (?,?,?,?,?) ";
//  	
//      Connection conn = (Connection) DBConnectionManager.getConnection();
//	  PreparedStatement pstmt;
//	try {
//		pstmt = (PreparedStatement) conn.prepareStatement(sql);
//		pstmt.setString(1, bean.getMarketplace().getPartner());
//	      pstmt.setString(2, bean.getMarketplace().getBaseUrl());
//	      pstmt.setString(3, bean.getCreator().getUuid());
//	      pstmt.setString(4, bean.getCreator().getOpenId());
//	      pstmt.setString(5, bean.getCreator().getEmail());
//	      pstmt.executeUpdate();
//	      System.out.println("MarketPlaceDao");
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//		  
      
      
	  in.close();		  
	    
	    
}    
    




}

