package saproject.rewardservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import saproject.rewardservice.domain.Reward;

public interface RewardRepository extends MongoRepository<Reward, String> {
}
