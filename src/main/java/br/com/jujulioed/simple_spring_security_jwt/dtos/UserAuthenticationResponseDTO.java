package br.com.jujulioed.simple_spring_security_jwt.dtos;

public class UserAuthenticationResponseDTO {
    private String token;

    public UserAuthenticationResponseDTO() {}

    public UserAuthenticationResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
