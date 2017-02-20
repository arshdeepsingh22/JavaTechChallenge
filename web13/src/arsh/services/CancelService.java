package arsh.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import arsh.Bean_Classes.Bean;
import arsh.Dao.CancelSubsDao;
import arsh.Dao.CreateSubsDao;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class CancelService {

	String url2;

	public CancelService(String url2) {
		super();
		this.url2 = url2;
	}

	public void ServiceCancel() throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, JSONException {
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
	    
		    
		    Bean bean = new Bean();
		  
		    bean = new ObjectMapper().readValue(jsonString,Bean.class);
	      	
	      CancelSubsDao cancelSubsDao = new CancelSubsDao();    
	      cancelSubsDao.cancelSubs(bean);
	      
	      
	      
		  in.close();		  
		    
	}    
	    
	    


	
	
}
