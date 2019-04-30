package com.gamer.clientapp.config;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gamer.clientapp.domain.Role;
import com.gamer.clientapp.domain.User;
import com.gamer.clientapp.util.EndPointConstraint;

@Component
public class ClientAuthenticationProvider implements AuthenticationProvider, AuthenticationSuccessHandler {

	@Autowired
	RestTemplate template;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
	
		String uri = EndPointConstraint.USERREGISTRATION_URL + "/" + username;

		ResponseEntity<User> response = template.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<User>() {
				});

		User user = response.getBody();
		if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals("hima")) {
			throw new BadCredentialsException("Wrong password.");
		}
		ResponseEntity<Role> roleresponse = template.exchange(uri + "/userrole", HttpMethod.GET, null,
				new ParameterizedTypeReference<Role>() {
				});

		String roles = roleresponse.getBody().getRole();
		List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		System.out.println(authorities);
		// Collection<? extends GrantedAuthority> authorities = roles;
		System.out.println(new UsernamePasswordAuthenticationToken(user, password, authorities));
		return new UsernamePasswordAuthenticationToken(user, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean hasTeamManagerRole = false;
		boolean hasContestOwnerRole = false;
		boolean hasScoreBoaredManagerrRole = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_TEAM_MANAGER")) {
				hasTeamManagerRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_CONTEST_OWNER")) {
				hasContestOwnerRole = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_SCOREBOARD_MANAGER")) {
				hasScoreBoaredManagerrRole = true;
				break;
			}

		}

		
		  if (hasTeamManagerRole) { 
			  redirectStrategy.sendRedirect(request, response, "/team");
			 
			  }
		  else if (hasContestOwnerRole) { 
			  redirectStrategy.sendRedirect(request, response,"/contest/create"); 
			  }
		  else if (hasScoreBoaredManagerrRole) {
				  redirectStrategy.sendRedirect(request, response, "/"); 
				} else { throw new IllegalStateException(); }
		 
		
	}
}
