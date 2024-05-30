package com.singtome.domain.repository;

import com.singtome.domain.entity.aiCoverSong;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AiCoverSongRepository extends JpaRepository<aiCoverSong, Long> {

    @Query("SELECT c.converted_id, c.song_id, c.voice_id, c.path FROM aiCoverSong c WHERE c.is_public = true")
    List<Object[]> showList();

    @Query("SELECT c.converted_id, c.song_id, c.voice_id, c.path FROM aiCoverSong c WHERE c.user_id = :userId")
    List<Object[]> showOwnList(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT c.converted_id, c.song_id, c.voice_id, c.path FROM aiCoverSong c WHERE c.is_public = true ORDER BY c.play_count DESC")
    List<Object[]> showplayCountList(Pageable pageable);

    @Query("SELECT c.converted_id, c.song_id, c.voice_id, c.path FROM aiCoverSong c WHERE c.is_public = true ORDER BY c.play_count DESC")
    List<Object[]> showTop10ByPlayCount(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE aiCoverSong v SET v.like_count = v.like_count + 1 WHERE v.converted_id = :converted_id")
    void incrementLikeCount(Long converted_id);

    @Modifying
    @Transactional
    @Query("UPDATE aiCoverSong v SET v.play_count = v.play_count + 1 WHERE v.converted_id = :converted_id")
    void playSong(Long converted_id);
}
