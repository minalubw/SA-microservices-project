package saproject.avatar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saproject.avatar.Domain.Avatar;
import saproject.avatar.Service.AvatarService;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;
    @PostMapping("/add")
    public ResponseEntity<Avatar> addAvatar(@RequestBody Avatar avatar) {
       return new ResponseEntity<>(avatarService.addAvatar(avatar), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAvatar(@PathVariable int id) {
       return new ResponseEntity<>(avatarService.deleteAvatar(id), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Avatar> updateAvatar(@RequestBody Avatar avatar) {
        return new ResponseEntity<>(avatarService.updateAvatar(avatar), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Avatar> getAvatar(@PathVariable int id) {
       return new ResponseEntity<>(avatarService.getAvatar(id), HttpStatus.OK);
    }

}
