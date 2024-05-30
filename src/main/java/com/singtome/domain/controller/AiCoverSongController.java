package com.singtome.domain.controller;

import com.singtome.domain.entity.Likes;
import com.singtome.domain.repository.AiCoverSongRepository;
import com.singtome.domain.repository.LikeRepository;
import com.singtome.domain.repository.VoiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "AI 커버송 관련 API입니다.")
@RestController
@RequiredArgsConstructor
public class AiCoverSongController {

    @Autowired
    private AiCoverSongRepository aiCoverSongRepository;
    private final LikeRepository likeRepository;


    // 음원 리스트 전부 보여주기
    @GetMapping("convertedsong/list")
    @Operation(summary = "모든 음원 리스트 가져오기", description = "추론된 음원 리스트를 반환합니다")
    public List<Object[]> getConvertedSongList(){
        return aiCoverSongRepository.showList();
    }

    // 특정 유저가 만든 음원 리스트 보여주기
    @GetMapping("convertedsong/list/{user_id}")
    @Operation(summary = "해당 유저가 만든 음원 리스트 가져오기", description = "특정 유저가 추론시킨 음원 리스트를 반환합니다")
    public List<Object[]> getConvertedSongUserList(@PathVariable Long user_id, @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return aiCoverSongRepository.showOwnList(user_id, pageable);
    }

    /*
    // 유저가 좋아한 음원 리스트 보여주기
    @GetMapping("convertedsong/list/likes/{user_id}")
    public List<Object[]> getConvertedSongUserLikeList(@PathVariable Long user_id){
        return aiCoverSongRepository.showOwnLikeList(user_id);
    }

     */

    @PostMapping("convertedsong/likes/{user_id}/{converted_id}")
    @Operation(summary = "해당 음원에 대해 좋아요 요청", description = "해당 음원에 좋아요를 추가합니다")
    public String likeVoice(@PathVariable Long user_id, @PathVariable Long converted_id) {
        Likes likes = likeRepository.findByUser_idAndConverted_id(user_id, converted_id);

        if (likes == null) {
            Likes like = new Likes();
            like.setConverted_id(converted_id);
            like.setUser_id(user_id);

            likeRepository.save(like);

            aiCoverSongRepository.incrementLikeCount(converted_id);

            return "좋아요 가 등록 되었습니다";
        }
        else{
            Long liked_id = likes.getLike_id();
            likeRepository.deleteByLiked_id(liked_id);

            return "좋아요 가 취소되었습니다";
        }

    }

    @GetMapping("convertedsong/playCount")
    @Operation(summary = "음원 리스트를 재생된 횟수 순으로 반환합니다", description = "페이지네이션 적용")
    public List<Object[]> getLikedConvertedSongList(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);
        return aiCoverSongRepository.showplayCountList(pageable);
    }

    @GetMapping("convertedsong/top10")
    @Operation(summary = "좋아요 순으로 상위 10개의 음원 리스트를 반환합니다", description = "Top10")
    public List<Object[]> getTopConvertedSongList(){

        PageRequest pageRequest = PageRequest.of(0, 10);
        return aiCoverSongRepository.showTop10ByPlayCount(pageRequest);
    }

    @PostMapping("convertedsong/{converted_id}")
    @Operation(summary = "특정 ai커버송을 재생할때마다 재생횟수를 늘립니다", description = "음악 재생 버튼 누를 때 마다 요청")
    public void playConvertedSong(@PathVariable Long converted_id){
        aiCoverSongRepository.playSong(converted_id);
    }


}
