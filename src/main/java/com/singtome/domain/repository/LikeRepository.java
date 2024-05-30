package com.singtome.domain.repository;

import com.singtome.domain.entity.Likes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Long> {
    @Query("SELECT l FROM Likes l WHERE l.user_id = :user_id AND l.converted_id = :converted_id")
    Likes findByUser_idAndConverted_id(Long user_id, Long converted_id);

    @Query("SELECT l FROM Likes l WHERE l.user_id = :user_id AND l.voice_id = :voice_id")
    Likes findByUser_idAndVoice_id(Long user_id, Long voice_id);


    @Transactional
    @Modifying
    @Query("DELETE FROM Likes l WHERE l.like_id = :like_id")
    void deleteByLiked_id(Long like_id);
}
