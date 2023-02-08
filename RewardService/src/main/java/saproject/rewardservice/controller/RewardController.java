package saproject.rewardservice.controller;

import brave.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saproject.rewardservice.domain.Reward;
import saproject.rewardservice.dto.RewardDto;
import saproject.rewardservice.service.IRewardService;

@RestController
public class RewardController {
    @Autowired
    private IRewardService rewardService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/reward/{rewardId}")
    public ResponseEntity<Reward> viewReward(@PathVariable("rewardId") String rewardId){
        return ResponseEntity.ok().body(rewardService.viewReward(rewardId));
    }

    @PostMapping("/reward")
    public ResponseEntity<RewardDto> addReward(@RequestBody Reward reward){
        return ResponseEntity.ok().body(modelMapper.map(rewardService.addReward(reward), RewardDto.class));
    }

    @PutMapping("/reward/{id}")
    public ResponseEntity<RewardDto> updateReward(@PathVariable("id") String id, @RequestBody Reward reward){
        return ResponseEntity.ok().body(modelMapper.map(rewardService.updateReward(id, reward), RewardDto.class));
    }

    @DeleteMapping("/reward/{id}")
    public ResponseEntity<String> removeReward(@PathVariable("id") String id){
        return ResponseEntity.ok().body(rewardService.deleteReward(id));
    }
}
