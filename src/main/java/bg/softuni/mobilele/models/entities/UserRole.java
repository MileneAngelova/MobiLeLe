package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "users_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    RoleEnum userRole;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleEnum getUserRole() {
        return userRole;
    }

    public UserRole setUserRole(RoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userRole=" + userRole +
                '}';
    }
}
