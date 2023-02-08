package saproject.rewardservice.service;

import saproject.rewardservice.domain.Reward;

public interface IRewardService {
    Reward addReward(Reward reward);
    Reward viewReward(String id);
    Reward updateReward(String id, Reward reward);
    String deleteReward(String id);
}
