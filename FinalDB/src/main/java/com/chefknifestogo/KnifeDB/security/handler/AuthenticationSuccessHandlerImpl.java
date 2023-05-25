package com.chefknifestogo.KnifeDB.security.handler;

import com.chefknifestogo.KnifeDB.bean.User;
import com.chefknifestogo.KnifeDB.security.SecurityUtils;
import org.springframework.core.serializer.DefaultSerializer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		/*const jwtToken=jwt.sign*/
/*		Object principle= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id;
		if(principle instanceof User){
			id=((User) principle).getId();
		}
		else{
			id=(Integer)principle;
		}*/
		SecurityUtils.sendResponse(response, HttpServletResponse.SC_OK, "Login successfully.", null); //store the user ID in the message
	}
	
}
