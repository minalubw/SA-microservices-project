package saproject.rewardservice.service;

import saproject.rewardservice.domain.Reward;

public interface IRewardService {
    Reward addReward(Reward reward);
    Reward viewReward(Integer id);
    Reward updateReward(Integer id, Reward reward);
    String deleteReward(Integer id);
}
