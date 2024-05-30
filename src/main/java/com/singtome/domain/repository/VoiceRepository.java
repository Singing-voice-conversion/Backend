package com.singtome.domain.repository;

import com.singtome.domain.entity.Voice;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoiceRepository extends JpaRepository<Voice, Long> {

    @Query("SELECT v FROM Voice v WHERE v.user_id = :userId AND v.voice_id = :voiceId")
    Voice search(Long userId, Long voiceId);


    @Query("SELECT v.voice_id, v.name, v.like_count FROM Voice v WHERE v.user_id = :user_id")
    List<Object[]> showList(Long user_id, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Voice v SET v.like_count = v.like_count + 1 WHERE v.voice_id = :voiceId")
    void incrementLikeCount(Long voiceId);
}
