package ru.javamentor.SpringSecurity.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Size(min = 3, max = 45, message = "at least 3 characters")
    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Size(min = 3, max = 128, message = "at least 3 characters")
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "bio")
    private String bio;

    /*
    *
    * realise equals, hashcode and toString
    * and relations many-to-many (POJO Role)
    *
    * */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
