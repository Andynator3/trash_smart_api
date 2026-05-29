package com.trashsmart.trash_smart_api.user_profile.web.services;


import com.trashsmart.trash_smart_api.user_profile.dtos.UserTrashSmartDto;

import java.util.List;

public interface UserTrashSmartService  {

    UserTrashSmartDto createProfile(UserTrashSmartDto profileDto);
    UserTrashSmartDto getProfileByAppUserId(Long appUserId);
    List<UserTrashSmartDto> getAllProfiles();
    UserTrashSmartDto updateProfile(Long appUserId, UserTrashSmartDto profileDto);
    UserTrashSmartDto addRewardPoints(Long appUserId, int pointsToAdd);
    void deleteProfile(Long appUserId);



}