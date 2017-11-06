package com.devopsbuddy.test.integration;

import com.devopsbuddy.DevopsbuddyApplication;
import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import com.devopsbuddy.enums.PlanEnum;
import com.devopsbuddy.enums.RolesEnum;
import com.devopsbuddy.utils.UserUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sreenu on 1-11-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsbuddyApplication.class)
public class RepositoryIntegrationTest {

    /** The Application logger*/
    private static  final Logger LOG = LoggerFactory.getLogger(RepositoryIntegrationTest.class);

    @Rule
    public TestName testName = new TestName();

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private static final int BASIC_PALN_ID = 1;
    private static final int BASIC_ROLE_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(userRepository);
        Assert.assertNotNull(roleRepository);

    }

    @Test
    public void testCreateNewPlan() throws Exception {
        System.out.println("Start......testCreateNewPlan");
        Plan plan = createBassicPlan(PlanEnum.BASIC);
        planRepository.save(plan);
        Plan retrivedPlan = planRepository.findOne(PlanEnum.BASIC.getId());
        Assert.assertNotNull(retrivedPlan);
        System.out.println("End......testCreateNewPlan");
    }

    private Plan createBassicPlan(PlanEnum planEnum) {
        return new Plan(planEnum);
    }

    private Role createBasicRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }

    private User createUser(String username, String email) {
        Plan basicPlan = createBassicPlan(PlanEnum.BASIC);
        planRepository.save(basicPlan);


        User basicUser = UserUtils.createBasicUser(username, email);
        basicUser.setPlan(basicPlan);

        Role role = createBasicRole(RolesEnum.BASIC);
//        roleRepository.save(role);

        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole(basicUser, role);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);
        basicUser = userRepository.save(basicUser);
        return basicUser;
    }


    /*@Test
    public void createNewUser() throws Exception {
        System.out.println("Start......createNewUser");
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@sample.com";

        User basicUser = createUser(username, email);

        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();
        for (UserRole ur : newlyCreatedUserUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
        System.out.println("End......createNewUser");
    }

    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("start......testDeleteUser");
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@sample.com";

        User basicUser = createUser(username, email);
        userRepository.delete(basicUser.getId());
        System.out.println("End......testDeleteUser");
    }*/

    /*@Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);
        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }

    @Test
    public void testCreateNewRole() throws Exception {

        Role userRole  = createRole(RolesEnum.BASIC);
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);
    }





    @Test
    public void testGetUserByEmail() throws Exception {
        User user = createUser(testName);

        User newlyFoundUser = userRepository.findByEmail(user.getEmail());
        Assert.assertNotNull(newlyFoundUser);
        Assert.assertNotNull(newlyFoundUser.getId());
    }

    @Test
    public void testUpdateUserPassword() throws Exception {
        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        String newPassword = UUID.randomUUID().toString();

        userRepository.updateUserPassword(user.getId(), newPassword);

        user = userRepository.findOne(user.getId());
        Assert.assertEquals(newPassword, user.getPassword());

    }*/


}
