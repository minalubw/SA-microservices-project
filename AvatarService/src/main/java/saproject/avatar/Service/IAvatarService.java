package saproject.avatar.Service;

import saproject.avatar.Domain.Avatar;
import saproject.avatar.ExceptionHandling.AvatarException;

public interface IAvatarService {
     Avatar getAvatar(int id)throws AvatarException;
     Avatar addAvatar(Avatar avatar)throws AvatarException;
     String deleteAvatar(int id)throws AvatarException;
     Avatar updateAvatar(Avatar avatar)throws AvatarException;


}
