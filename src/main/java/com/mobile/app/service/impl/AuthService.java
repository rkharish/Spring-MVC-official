package com.mobile.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mobile.app.controller.model.ui.UserProfile;
import com.mobile.app.dao.IAuthDao;
import com.mobile.app.dao.entity.UserProfileEntity;
import com.mobile.app.service.IAuthService;

@Service("AuthService")
@Scope("singleton")
public class AuthService implements IAuthService {

	@Autowired
	@Qualifier("AuthDao")
	private IAuthDao iAuthDao;
	
	@Override
	public String updateProfile(UserProfile userProfile) {
		//conversion from UserProfile to UserProfileEntity type
		UserProfileEntity entity=new UserProfileEntity();
		BeanUtils.copyProperties(userProfile, entity);
		return iAuthDao.updateProfile(entity);
	}

	@Override
	public UserProfile addProfile(UserProfile userProfile) {
		//conversion from UserProfile to UserProfileEntity type
		UserProfileEntity entity=new UserProfileEntity();
		BeanUtils.copyProperties(userProfile, entity);
		UserProfileEntity profileEntity=iAuthDao.addProfile(entity);
		BeanUtils.copyProperties(profileEntity, userProfile);
		return userProfile;
	}

	@Override
	public String authUser(String username, String password) {
		return iAuthDao.authUser(username, password);
	}

	@Override
	public byte[] findUserImageByUserName(String username) {
		return iAuthDao.findUserImageByUserName(username);
	}

	@Override
	public UserProfile findUserProfileByPid(String uid) {
		UserProfile userProfile=new UserProfile();
		UserProfileEntity profileEntity=iAuthDao.findUserProfileByPid(uid);
		BeanUtils.copyProperties(profileEntity, userProfile);
		return userProfile;
	}

	@Override
	public String deleteUserProfileById(String uid) {
		return iAuthDao.deleteUserProfileById(uid);
	}

	@Override
	public List<UserProfile> findUserProfiles()   {
		 List<UserProfile> profiles=new ArrayList<>();
		List<UserProfileEntity> userProfileEntity=iAuthDao.findUserProfiles();
		for(UserProfileEntity entity:userProfileEntity){
			UserProfile userProfile=new UserProfile();
			BeanUtils.copyProperties(entity, userProfile);
			profiles.add(userProfile);
		}
		return profiles;
	}

}
