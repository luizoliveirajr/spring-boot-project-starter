package com.luizmarcelo.springsecuritystarter.model.authority;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "authorities")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

}
