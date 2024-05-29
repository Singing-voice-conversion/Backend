package com.singtome.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RvcInferenceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inference_id;

    private Long user_id;

    private Long voice_id;

    private Long song_id;

    private String status;
}
