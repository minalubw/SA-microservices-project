package saproject.avatar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import saproject.avatar.Domain.Avatar;
import saproject.avatar.Service.AvatarService;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;
    @PostMapping("/add")
    public String addAvatar(@RequestBody Avatar avatar) {
        try{
            System.out.println(avatar.toString());
            avatarService.addAvatar(avatar);
            return "Avatar added";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAvatar(@PathVariable int id) {
        try{
            avatarService.deleteAvatar(id);
            return "Avatar deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @PutMapping("/update")
    public String updateAvatar(@RequestBody Avatar avatar) {
        try{
            avatarService.updateAvatar(avatar);
            return "Avatar updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/get/{id}")
    public String getAvatar(@PathVariable int id) {
        try{
            return avatarService.getAvatar(id).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
