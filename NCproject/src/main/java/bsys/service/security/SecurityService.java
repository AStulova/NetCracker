package bsys.service.security;

public interface SecurityService {
    String findLoggedInEmail();
    void autoLogin(String email, String password);
}
