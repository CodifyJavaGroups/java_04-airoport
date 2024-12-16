package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Логин не может быть пустым")
    @Pattern(regexp = "^[a-z0-9]+$", message = "Логин не может содержать только маленькие символы и цифры")
    @Size(min = 8, max = 25, message = "Логин пользователя может быть от 8 до 25 символов")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, message = "Пароль должен содержать хотя бы 8 символов")
    @Pattern(regexp = ".*[A-Z].*", message = "Пароль должен содержать хотя бы одну заглавную букву")
    @Pattern(regexp = ".*[a-z].*", message = "Пароль должен содержать хотя бы одну строчную букву")
    @Pattern(regexp = ".*\\d.*", message = "Пароль должен содержать хотя бы одну цифру")
    @Pattern(regexp = ".*[!@#$%^&*(),.?\":{}|<>].*", message = "Пароль должен содержать хотя бы один специальный символ")
    @Column(name = "password")
    private String password;

    @Column(name = "date_create_user")
    private LocalDate dateCreateUser;

    @Column(name = "date_update_user")
    private LocalDate dateUpdateUser;

    @OneToMany(mappedBy = "user")
    private List<PassportEntity> passports;

    @ManyToMany
    @JoinTable(
            name = "m2m_users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles;

    @OneToOne(mappedBy = "employee")
    private EmployeeEntity employee;


    @PrePersist
    private void setNowToCreateDateUser(){
        dateCreateUser = LocalDate.now();
    }

    @PreUpdate
    private void setNowToUpdateDateUser(){
        dateUpdateUser = LocalDate.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
