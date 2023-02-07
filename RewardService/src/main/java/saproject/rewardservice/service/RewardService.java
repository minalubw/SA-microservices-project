package saproject.rewardservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.rewardservice.domain.Reward;
import saproject.rewardservice.exception.RewardNotFoundException;
import saproject.rewardservice.repository.RewardRepository;

import java.util.Optional;

@Service
public class RewardService implements IRewardService{
    @Autowired
    private RewardRepository rewardRepository;

    @Override
    public Reward addReward(Reward reward) {
        return rewardRepository.save(rewardRepository.save(reward));
    }

    @Override
    public Reward viewReward(Integer id) {
        Optional<Reward> reward =  rewardRepository.findById(id);
        if(reward.isPresent()){
            return reward.get();
        }
        else
            throw new RewardNotFoundException("Reward with + " + id + " not found!");
    }

    @Override
    public Reward updateReward(Integer id, Reward reward) {
        Optional<Reward> rewardToBeUpdated = rewardRepository.findById(id);
        if(rewardToBeUpdated.isPresent()){
            rewardToBeUpdated.get().setName(reward.getName());
            rewardToBeUpdated.get().setType(reward.getType());
            rewardToBeUpdated.get().setQuantity(reward.getQuantity());
            return rewardRepository.save(rewardToBeUpdated.get());
        }
        else
            throw new RewardNotFoundException("Reward with + " + id + " not found!");
    }

    @Override
    public String deleteReward(Integer id) {
        Optional<Reward> rewardToBeDeleted = rewardRepository.findById(id);
        if(rewardToBeDeleted.isPresent()){
            rewardRepository.delete(rewardToBeDeleted.get());
            return "Reward Deleted!";
        }
        else
            throw new RewardNotFoundException("Reward with + " + id + " not found!");
    }
}
