//package purchase.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//import purchase.domain.*;
//import purchase.services.IPurchaseService;
//
//@RestController
//@RequestMapping("/order/reward")
//public class RewardPurchaseController {
//
//    @Autowired
//    ElementFeignClient elementFeignClient;
//
//    @Autowired
//    StudentFeignClient studentFeignClient;
//
//    @Autowired
//    RewardFeignClient rewardFeignClient;
//    @Autowired
//    private IPurchaseService purchaseService;
//
//    @PutMapping("/buy")
//   public Student buyReward(@RequestBody RewardOrder rewardOrder){
//        Student student = studentFeignClient.getStudent(rewardOrder.getStudentNumber());
//        Reward reward = rewardFeignClient.getReward(rewardOrder.getRewardId());
//
//
//    }
//
//    @PutMapping("/redeem")
//    public Student removeElement(@RequestBody ElementOrder elementOrder){
//        Student student = studentFeignClient.getStudent(elementOrder.getStudentNumber());
//        Student updated = purchaseService.removeElement(student, elementOrder.getElementId());
//        return studentFeignClient.updateStudent(updated);
//    }
//
//
//
//    @FeignClient("ElementService")
//    interface ElementFeignClient{
//        @RequestMapping("/element/{elementId}")
//        Element getElement(@PathVariable("elementId") String elementId);
//    }
//
//    @FeignClient("StudentService")
//    interface StudentFeignClient{
//        @RequestMapping("/student/{studentNumber}")
//        Student getStudent(@PathVariable("studentNumber") String studentNumber);
//
//        @PutMapping("/student/update")
//        public Student updateStudent(@RequestBody Student student);
//    }
//
//    @FeignClient("RewardService")
//    interface RewardFeignClient{
//        @RequestMapping("/reward/{id}")
//        Reward getReward(@PathVariable("id") Integer id);
//
//        @PutMapping("/student/update")
//        public Student updateStudent(@RequestBody Student student);
//    }
//}
