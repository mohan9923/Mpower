package servletspracticebymohan;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;


	@SuppressWarnings("serial")
	public class servlets extends GenericServlet {
		
	    	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			
			String n  = request.getParameter("name");
			String p= request.getParameter("password");	
			String cp = request.getParameter("confirm password");
			String pn = request.getParameter("phone number");
			String ec = request.getParameter("Emergency contact");
			String c = request.getParameter("country");
			servletsjdbc obj=new servletsjdbc();
			try {
				obj.insert(n, p, cp, pn, ec,c);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	

