package com.workshop.workshopmongo.domain;

import com.workshop.workshopmongo.dto.AuthorDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document
public class Post implements Serializable {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto author;
}
