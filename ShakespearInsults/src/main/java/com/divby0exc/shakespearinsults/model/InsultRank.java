package com.divby0exc.shakespearinsults.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class InsultRank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date create_dt;
    private int rank;

}
