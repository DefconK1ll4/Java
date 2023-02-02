package com.divby0exc.shakespearinsults.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Table(name = "insult")
public class ShakespearModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "content")
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "insult")
    private List<InsultRank> rankList;
}
