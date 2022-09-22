package ua.com.javarush.quest_spring.ivanov.entities;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;

    @NotBlank(message = "User name cannot be blank")
    @NotNull(message = "User name cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    private String password;
    private String email;
    private String role;
}
