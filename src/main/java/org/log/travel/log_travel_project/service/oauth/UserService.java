package org.log.travel.log_travel_project.service.oauth;

import lombok.RequiredArgsConstructor;
import org.log.travel.log_travel_project.repository.entity.UserRepository;
import org.log.travel.log_travel_project.repository.entity.Users;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
