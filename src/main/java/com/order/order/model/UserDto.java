package com.order.order.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
        private Long id;
        private String name;
        private String email;

        //Getter Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




