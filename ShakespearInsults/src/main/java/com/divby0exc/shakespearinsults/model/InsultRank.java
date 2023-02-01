package com.divby0exc.shakespearinsults.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
@Table(name = "rank")
public class InsultRank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "create_dt")
    private Date create_dt = Date.valueOf(LocalDate.now());
    @Column(name ="rank")
    private int rank;

}
