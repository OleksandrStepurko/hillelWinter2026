package com.hillel.cw_11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
public class LombokTest {
    @ToString.Exclude
    private int id;
    private String name;
    private String email;
}

@Slf4j
class LombokRun{


    public static void main(String[] args) {
        LombokTest obj = new LombokTest();

        obj.setId(1);
        obj.setName("Oleksandr");
        obj.setEmail("mail@mail.com");



        System.out.println(obj);
    }
}
