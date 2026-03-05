package com.hillel.cw_21.annotation.validator;


import com.hillel.cw_21.annotation.validator.anot.Author;
import com.hillel.cw_21.annotation.validator.anot.Email;
import com.hillel.cw_21.annotation.validator.anot.Min;
import com.hillel.cw_21.annotation.validator.anot.NotNull;
import com.hillel.cw_21.annotation.validator.anot.Size;
import lombok.Data;

@Data
public class User {

    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 25, message = "Name must be between 5 and 25 characters")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @Min(18)
    private int age;

    @Author(firstName = "Oleksandr", lastName = "Oleksandr")
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

}

