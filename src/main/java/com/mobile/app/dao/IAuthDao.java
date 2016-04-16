package com.mobile.app.dao;

import java.util.List;

import com.mobile.app.dao.entity.UserProfileEntity;

public interface IAuthDao {
	public String updateProfile(UserProfileEntity userProfile);
	public UserProfileEntity addProfile(UserProfileEntity userProfile);
	public String authUser(String username, String password);
	public byte[] findUserImageByUserName(String username);
	public UserProfileEntity findUserProfileByPid(String uid);
	public String deleteUserProfileById(String uid);
	public List<UserProfileEntity> findUserProfiles();
	public UserProfileEntity findRoleByUsername(String username);
}
