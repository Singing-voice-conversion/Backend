package com.singtome.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class aiCoverSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long converted_id;
    private Long song_id;
    private Long voice_id;
    private String path;
    private int play_count;
    private int like_count;
    private Long user_id;
    private boolean is_public;

}
