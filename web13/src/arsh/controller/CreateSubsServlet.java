package arsh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;

import arsh.model.TestJson;
import arsh.model.User;
import arsh.services.*;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@WebServlet(name = "CreateSubsServlet")
public class CreateSubsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String eventUrl = (String) request.getParameter("eventUrl");
     //   User eventUrl2 = (User) request.getParameter("user");
        ObjectMapper mapper = new ObjectMapper();
/*
        BufferedReader reader = request.getReader();
        User user1 = mapper.readValue(reader, User.class);
*/
        
        TestJson testJson = new TestJson();
        testJson.setEventUrl(eventUrl);
        User u = new User(123,"Arsh");
       testJson.setUser(u);

       
       CreateService createService = new CreateService(eventUrl);
       try {
		createService.ServiceCreate();
	} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
			| JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        String json = mapper.writeValueAsString(testJson);
        System.out.print(eventUrl);
        out.print("{\"accountIdentifier\":\"test\" , \"success\":\"true\"}");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        User u1 = new User(1, "ravi");
        String json = mapper.writeValueAsString(u1);
        out.print(json);
    }
}
