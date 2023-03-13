package Entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    private int userId;
    @Basic
    @Column(name = "USERNAME")
    private String username;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @Basic
    @Column(name = "ADMIN")
    private Boolean admin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userId == users.userId && Objects.equals(username, users.username) && Objects.equals(password, users.password) && Objects.equals(admin, users.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, admin);
    }
}
