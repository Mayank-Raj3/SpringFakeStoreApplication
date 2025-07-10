package org.example.basicspringbootapplication.DTO;

import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    private long id;
    private String name;
}