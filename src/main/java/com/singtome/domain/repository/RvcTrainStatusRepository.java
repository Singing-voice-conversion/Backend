package com.singtome.domain.repository;

import com.singtome.domain.entity.RvcTrainStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RvcTrainStatusRepository extends JpaRepository<RvcTrainStatus, Long> {

    @Query("SELECT r.status FROM RvcTrainStatus r WHERE r.user_id = :user_id")
    List <String> showStatus(Long user_id);
}
