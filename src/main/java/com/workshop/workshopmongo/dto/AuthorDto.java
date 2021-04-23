package com.workshop.workshopmongo.dto;

import com.workshop.workshopmongo.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto implements Serializable {
    private String id;
    private String name;

    public AuthorDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
