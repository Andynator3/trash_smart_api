package com.trashsmart.trash_smart_api.user_profile.web;

import com.trashsmart.trash_smart_api.user_profile.dtos.UserTrashSmartDto;
import com.trashsmart.trash_smart_api.user_profile.web.services.UserTrashSmartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication")
public class UserTrashSmartController {

    private final UserTrashSmartService userTrashSmartService;

    @PostMapping
    public UserTrashSmartDto createProfile(@RequestBody UserTrashSmartDto profileDto) {
        return userTrashSmartService.createProfile(profileDto);
    }

    @GetMapping("/user/{appUserId}")
    public UserTrashSmartDto getProfileByAppUserId(@PathVariable Long appUserId) {
        return userTrashSmartService.getProfileByAppUserId(appUserId);
    }

    @GetMapping
    public ResponseEntity<List<UserTrashSmartDto> > getAllProfiles() {
        List<UserTrashSmartDto> profiles = userTrashSmartService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }
    @PutMapping("/user/{appUserId}")
    public UserTrashSmartDto updateProfile(@PathVariable Long appUserId, @RequestBody UserTrashSmartDto profileDto) {
        return userTrashSmartService.updateProfile(appUserId, profileDto);
    }

    @PatchMapping("/user/{appUserId}/points")
    public UserTrashSmartDto addRewardPoints(@PathVariable Long appUserId, @RequestParam int points) {
        return userTrashSmartService.addRewardPoints(appUserId, points);
    }

    @DeleteMapping("/user/{appUserId}")
    public void deleteProfile(@PathVariable Long appUserId) {
        userTrashSmartService.deleteProfile(appUserId);
    }


}
