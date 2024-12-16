package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Имя должно содержать только буквы")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Имя не может быть пустым")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Имя должно содержать только буквы")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Идентификатор паспорта не может быть пустым")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Номер паспорта может содержать только буквы и цифры")
    @Column(name = "user_passport_id")
    private String userPassportId;

    @Future(message = "Дата истечения срока действия паспорта должна быть в будущем")
    @Column(name = "date_of_expiry")
    private LocalDate dateOfExpiry;

    @Past(message = "Дата рождения не может быть в будущем")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private PassengerEntity passenger;

}
