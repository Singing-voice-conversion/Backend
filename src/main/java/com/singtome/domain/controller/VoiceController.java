package com.singtome.domain.controller;

import com.singtome.domain.entity.Likes;
import com.singtome.domain.entity.Voice;
import com.singtome.domain.repository.LikeRepository;
import com.singtome.domain.repository.VoiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Voice 관련 API입니다.")
@RestController
@RequiredArgsConstructor
public class VoiceController {

    @Autowired
    private VoiceRepository voiceRepository;
    private final LikeRepository likeRepository;

    // VoiceRequest 클래스: 요청으로부터 user_id와 voice_id를 받기 위한 DTO 클래스
    @Getter
    @Data
    static class VoiceRequest {
        private Long user_id;
        private Long voice_id;

    }

    @GetMapping("voice/list/{user_id}")
    @Operation(summary = "해당 유저가 만든 목소리 가져오기", description = "특정 유저가 학습시킨 목소리를 리스트로 가져옵니다")
    public List<Object[]> getVoiceList(@PathVariable("user_id") Long user_id, @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return voiceRepository.showList(user_id, pageable);
    }


    // 좋아요 토글 요청
    @PostMapping("voice/likes/{user_id}/{voice_id}")
    @Operation(summary = "특정 목소리에 좋아요를 추가합니다", description = "학습된 목소리 리스트 중, 좋아요 요청하기")
    public String likeVoice(@PathVariable Long user_id, @PathVariable Long voice_id) {

        Likes likes = likeRepository.findByUser_idAndVoice_id(user_id, voice_id);

        if (likes == null) {
            Likes like = new Likes();
            like.setConverted_id(voice_id);
            like.setUser_id(user_id);

            likeRepository.save(like);

            voiceRepository.incrementLikeCount(voice_id);

            return "좋아요 가 등록 되었습니다";
        }
        else{
            Long liked_id = likes.getLike_id();
            likeRepository.deleteByLiked_id(liked_id);

            return "좋아요 가 취소되었습니다";
        }

    }

}
