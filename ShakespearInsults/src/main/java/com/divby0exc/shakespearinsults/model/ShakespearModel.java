package com.divby0exc.shakespearinsults.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    @MapKeyColumn(name = "content")
    private List<InsultRank> rankList;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(getContent(), getRankList());

        return jsonObj.toString();
    }
}
