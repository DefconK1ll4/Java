package com.divby0exc.shakespearinsults.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class ShakespearModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "content")
    private String content;
}
