package saproject.avatar.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import saproject.avatar.ExceptionHandling.AvatarException;
import saproject.avatar.Repository.AvatarDAO;
import saproject.avatar.Domain.Avatar;
@Service
public class AvatarService implements IAvatarService {

    @Autowired
    private AvatarDAO avatarDAO;


    public Avatar addAvatar(Avatar avatar){
        return avatarDAO.save(avatar);
    }
    public String deleteAvatar(int id) throws AvatarException {
        Avatar avatar= avatarDAO.findById(id).orElse(null);
        if (avatar == null)
            throw new AvatarException("Avatar not found");
        else {
            avatarDAO.deleteById(id);
            return "Avatar deleted!";
        }
    }
    public Avatar updateAvatar(Avatar avatar)  {
        Avatar avatar1 = avatarDAO.findById(avatar.getId()).orElse(null);
        if (avatar1 == null)
            throw new AvatarException("Avatar not found");
        else {
            return avatarDAO.save(avatar);
        }
    }

    @Override
    public Avatar getAvatar(int id) throws AvatarException{
        if (avatarDAO.findById(id).isEmpty())
            throw new AvatarException("Avatar not found");
        else
            return avatarDAO.findById(id).get();
    }
}
