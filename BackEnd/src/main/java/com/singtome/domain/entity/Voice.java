package com.singtome.domain.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voice_id;
    private Long user_id;
    private String name;
    private String path;
    private int like_count;

}
