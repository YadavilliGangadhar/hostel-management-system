package com.hostelmanagement.userservice.entity;

import jakarta.persistence.*;
        import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
//@Data                 // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor    // Generates no-args constructor
@AllArgsConstructor   // Generates all-args constructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String email;

    public enum Role {
        ROLE_ADMIN,
        ROLE_STUDENT,
        ROLE_WARDEN;

        public static Role fromString(String input) {
            switch (input.toUpperCase()) {
                case "ADMIN": return ROLE_ADMIN;
                case "STUDENT": return ROLE_STUDENT;
                case "WARDEN": return ROLE_WARDEN;
                default: throw new IllegalArgumentException("Invalid role: " + input);
            }
        }
    }
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
