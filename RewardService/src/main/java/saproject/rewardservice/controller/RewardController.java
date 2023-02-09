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

    @PutMapping("/update/{id}")
    public ResponseEntity<Reward> updateReward(@PathVariable("id") String id, @RequestBody Reward reward){
        return ResponseEntity.ok().body(rewardService.updateReward(id, reward));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeReward(@PathVariable("id") String id){
        return ResponseEntity.ok().body(rewardService.deleteReward(id));
    }
}
