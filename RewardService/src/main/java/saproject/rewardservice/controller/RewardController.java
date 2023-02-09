package saproject.rewardservice.controller;

import brave.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saproject.rewardservice.domain.Reward;
import saproject.rewardservice.dto.RewardDto;
import saproject.rewardservice.service.IRewardService;
@RequestMapping("/reward")
@RestController
public class RewardController {
    @Autowired
    private IRewardService rewardService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{rewardId}")
    public ResponseEntity<Reward> viewReward(@PathVariable("rewardId") String rewardId){
        return ResponseEntity.ok().body(rewardService.viewReward(rewardId));
    }

    @PostMapping("/add")
    public ResponseEntity<Reward> addReward(@RequestBody Reward reward){
        return ResponseEntity.ok().body(rewardService.addReward(reward));
    }

    @PutMapping("/update/{rewardId}")
    public ResponseEntity<Reward> updateReward(@PathVariable("rewardId") String id, @RequestBody Reward reward){
        return ResponseEntity.ok().body(rewardService.updateReward(id, reward));
    }

    @DeleteMapping("/delete/{rewardId}")
    public ResponseEntity<String> removeReward(@PathVariable("rewardId") String id){
        return ResponseEntity.ok().body(rewardService.deleteReward(id));
    }
}
