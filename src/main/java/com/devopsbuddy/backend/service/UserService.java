package com.devopsbuddy.backend.service;

import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import com.devopsbuddy.enums.PlanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by sreenu on 2-11-2017.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

    @Transactional
    public User createUser(User user, PlanEnum planEnum, Set<UserRole> userRoles){
        Plan plan = new Plan(planEnum);
        if(!planRepository.exists(planEnum.getId())){
            plan = planRepository.save(plan);
        }
        user.setPlan(plan);
        for (UserRole userRole:userRoles
             ) {
            roleRepository.save(userRole.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        return userRepository.save(user);
    }
}
