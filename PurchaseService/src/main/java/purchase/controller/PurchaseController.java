package purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import purchase.domain.*;
import purchase.exception.PurchaseException;
import purchase.services.IPurchaseService;

@RestController
@RequestMapping("/order")
public class PurchaseController {

    @Autowired
    ElementFeignClient elementFeignClient;
    @Autowired
    StudentFeignClient studentFeignClient;
    @Autowired
   RewardFeignClient rewardFeignClient;
    @Autowired
    private IPurchaseService purchaseService;

    @PutMapping("/element/buy")
    public Student buyElement(@RequestBody ElementOrder elementOrder){
        Student student = studentFeignClient.getStudent(elementOrder.getStudentNumber());
        Element element = elementFeignClient.getElement(elementOrder.getElementId());
        Student updated = purchaseService.buyElement(student, element);
        return studentFeignClient.updateStudent(updated);
    }

    @PutMapping("/element/remove")
    public Student removeElement(@RequestBody ElementOrder elementOrder){
        Student student = studentFeignClient.getStudent(elementOrder.getStudentNumber());
        Student updated = purchaseService.removeElement(student, elementOrder.getElementId());
        return studentFeignClient.updateStudent(updated);
    }

    @PutMapping("/reward/buy")
    public Student buyReward(@RequestBody RewardOrder rewardOrder){
        Student student = studentFeignClient.getStudent(rewardOrder.getStudentNumber());
        Reward reward = rewardFeignClient.getReward(rewardOrder.getRewardId());
        Student updated = null;
        try {
            updated = purchaseService.buyReward(student, reward);
        }catch (PurchaseException e){
            System.out.println(e.getMessage());
        }
        return studentFeignClient.updateStudent(updated);
    }
    @PutMapping("/reward/redeem")
    public Student redeemReward(@RequestBody RedeemRewardOrder redeemOrder){
        Student student = studentFeignClient.getStudent(redeemOrder.getStudentNumber());
        Element element = elementFeignClient.getElement(redeemOrder.getElementId());
        Student updated = purchaseService.redeemReward(student, element, redeemOrder.getRewardId());
        return studentFeignClient.updateStudent(updated);

    }

    @PutMapping("/teacher/givereward")
    public Student giverReward(@RequestBody RewardOrder rewardOrder){
        Student student = studentFeignClient.getStudent(rewardOrder.getStudentNumber());
        Reward reward = rewardFeignClient.getReward(rewardOrder.getRewardId());
        Student updated = purchaseService.giveReward(student, reward);
        return studentFeignClient.updateStudent(updated);
    }

    @FeignClient("ElementService")
    interface ElementFeignClient{
        @RequestMapping("/element/{elementId}")
        Element getElement(@PathVariable("elementId") String elementId);
    }

    @FeignClient("StudentService")
    interface StudentFeignClient{
        @RequestMapping("/student/{studentNumber}")
        Student getStudent(@PathVariable("studentNumber") String studentNumber);

        @PutMapping("/student/update")
        Student updateStudent(@RequestBody Student student);
    }

    @FeignClient("RewardService")
    interface RewardFeignClient{
        @RequestMapping("/reward/{rewardId}")
        Reward getReward(@PathVariable("rewardId") String rewardId);

    }

}
