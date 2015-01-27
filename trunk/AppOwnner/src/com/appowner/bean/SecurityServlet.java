package com.appowner.bean;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.appowner.dao.Cls_UserDaoImpl;
import com.appowner.model.User;
import com.appowner.service.In_UserService;
import com.appowner.util.Util;
 
 

@WebServlet("*.sec")
public class SecurityServlet extends HttpServlet   {

	private static final long serialVersionUID = 8071426090770097330L;
	 
	Cls_UserDaoImpl userService=new Cls_UserDaoImpl() ;
	 

	public SecurityServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("*** Called SecurityServlet");
		HttpSession httpSession = request.getSession();
		String faceCode = request.getParameter("code");
		String state = request.getParameter("state");
		String accessToken = getFacebookAccessToken(faceCode);
		 
			String email = getUserMailAddressFromJsonResponse(accessToken, httpSession);
		 
		String sessionID = httpSession.getId();
		if (state.equals(sessionID)){
			try {
				//do some specific user data operation like saving to DB or login user
				//request.login(email, "somedefaultpassword");
				User user=new User();
				
				 HttpSession session = request.getSession(true);
				System.out.println(request.getParameter("email")+"email"+session.getAttribute("str_EmailId"));
				String userName=(String) session.getAttribute("str_EmailId");
				 
				user=LoginPageCode.getUser(userName);
				 
				 
				if(user!=null)
				{
					 
					response.sendRedirect(request.getContextPath() +"/fbuserlogin.xhtml");
					 
				 
				}
				else
				{ 
                 
		             
					response.sendRedirect(request.getContextPath() +"/confirmfbaccount.xhtml");
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath() +"/facebookError.html");
				return;
			}
			 
			
		} else {
			System.err.println("CSRF protection validation");
		}
	}

	private String getFacebookAccessToken(String faceCode){
		String token = null;
		if (faceCode != null && ! "".equals(faceCode)) {
			String appId = "1525993687671325";
			  
			String redirectUrl = "http://localhost:5454/AppOwnner/index.sec";
			String faceAppSecret = "7c395ac6d696bed2bf4ef1c42dcf415c";
			String newUrl = "https://graph.facebook.com/oauth/access_token?client_id="
					+ appId + "&redirect_uri=" + redirectUrl + "&client_secret=" 
					+ faceAppSecret + "&code=" + faceCode;
			HttpClient httpclient = new DefaultHttpClient();
			try {
				
				HttpGet httpget = new HttpGet(newUrl);
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				String responseBody = httpclient.execute(httpget, responseHandler);
				token = StringUtils.removeEnd
						(StringUtils.removeStart(responseBody, "access_token="), "&expires=5180795");
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				httpclient.getConnectionManager().shutdown();
			}
		}
		return token;
	}

	private String getUserMailAddressFromJsonResponse(String accessToken, HttpSession httpSession)  {
		String str_EmailId = null;
		HttpClient httpclient = new DefaultHttpClient();
		try {
			if (accessToken != null && ! "".equals(accessToken)) {
				String newUrl = "https://graph.facebook.com/me?access_token=" + accessToken;
				
				httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet(newUrl);
				System.out.println("Get info from face --> executing request: " + httpget.getURI());
				ResponseHandler<String> responseHandler = new BasicResponseHandler();
				String responseBody = httpclient.execute(httpget, responseHandler);
				JSONObject json = (JSONObject)JSONSerializer.toJSON(responseBody);
				String facebookId = json.getString("id");
				String str_FirstName = json.getString("first_name");
				String str_LastName = json.getString("last_name");
				String gender=json.getString("gender");
				 
				//String password=json.getString("password");
				str_EmailId= json.getString("email");
				httpSession.setAttribute("str_FirstName", str_FirstName);
				httpSession.setAttribute("str_LastName", str_LastName);
				httpSession.setAttribute("fbId", facebookId);
				httpSession.setAttribute("str_EmailId", str_EmailId);
				httpSession.setAttribute("username", str_EmailId);
				
				
				httpSession.setAttribute("gender", gender);
				String img="https://graph.facebook.com/" +facebookId +"/picture";
				httpSession.setAttribute("str_ImageName1", img);
				System.out.println(img+"image");
				//put user data in session
				httpSession.setAttribute("FACEBOOK_USER", str_FirstName+" "
						+str_LastName);
				
			} else {
				System.err.println("Token za facebook je null");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return str_EmailId;
	}

 
}
