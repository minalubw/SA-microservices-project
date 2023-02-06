package saproject.avatar.Service;

import saproject.avatar.Domain.Avatar;
import saproject.avatar.ExceptionHandling.AvatarException;

public interface IAvatarService {
     Avatar getAvatar(int id)throws AvatarException;
     void addAvatar(Avatar avatar)throws AvatarException;
     void deleteAvatar(int id)throws AvatarException;
     void updateAvatar(Avatar avatar)throws AvatarException;


}
