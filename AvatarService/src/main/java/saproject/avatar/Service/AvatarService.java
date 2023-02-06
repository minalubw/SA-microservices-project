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


    public void addAvatar(Avatar avatar){
        avatarDAO.save(avatar);
    }
    public void deleteAvatar(int id) throws AvatarException {
        Avatar avatar= avatarDAO.findById(id).orElse(null);
        if (avatar == null)
            throw new AvatarException("Avatar not found");
        else {
            avatarDAO.deleteById(id);
        }
    }
    public void updateAvatar(Avatar avatar) throws AvatarException {
        Avatar avatar1 = avatarDAO.findById(avatar.getId()).orElse(null);
        if (avatar1 == null)
            throw new AvatarException("Avatar not found");
        else {
            avatarDAO.save(avatar);
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
