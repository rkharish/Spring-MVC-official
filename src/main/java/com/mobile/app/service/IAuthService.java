package com.mobile.app.service;

import java.util.List;

import com.mobile.app.controller.model.ui.UserProfile;

public interface IAuthService {
	public String updateProfile(UserProfile userProfile);
	public UserProfile addProfile(UserProfile userProfile);
	public String authUser(String username, String password);
	public byte[] findUserImageByUserName(String username);
	public UserProfile findUserProfileByPid(String uid);
	public String deleteUserProfileById(String uid);
	public List<UserProfile> findUserProfiles();
}
