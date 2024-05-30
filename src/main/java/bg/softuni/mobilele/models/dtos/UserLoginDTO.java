package bg.softuni.mobilele.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserLoginDTO {
    @Email(message = "Wrong email format ")
    private String email;

    @Size(min = 2, max = 20)
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
