package bsys.service.security;

import bsys.model.Client;
import bsys.service.client.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientService clientService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public String findLoggedInEmail() {
        Object client = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (client instanceof Client) {
            return ((Client)client).getEmail();
        }
        return null;
    }

    @Override
    public void autoLogin(String email, String password) {
        Client client = clientService.findClientByEmail(email);
        UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(client, password, client.getAuthorities());

        authenticationManager.authenticate(usernameToken);

        if (usernameToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernameToken);
            logger.debug(String.format("Auto login %s successfully!", email));
        }
    }
}
