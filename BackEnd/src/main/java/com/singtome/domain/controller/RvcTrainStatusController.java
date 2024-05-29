package com.singtome.domain.controller;

import com.singtome.domain.repository.RvcTrainStatusRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "RVC 학습 관련 API입니다.")
@RestController
@RequiredArgsConstructor
public class RvcTrainStatusController {

    private final RvcTrainStatusRepository rvcTrainStatusRepository;

    @GetMapping("train/{user_id}")
    @Operation(summary = "현재 해당 사용자가 요청한 학습이 존재하는지(아직 실행중인지)", description = "학습중인게 있다면 true, 없다면 false")
    public boolean checkTraining(@PathVariable Long user_id){

        List<String> statusList = rvcTrainStatusRepository.showStatus(user_id);

        for (String status : statusList) {
            if (!"done".equals(status)) {
                return false;
            }
        }
        return true;
    }

}
