package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private UserService userService;
    private ModelData modelData;

    public void changeUserData(String name, long id, int level) {
        User user=userService.createOrUpdateUser(name, id, level);
        modelData.setActiveUser(user);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers() {
        List<User> users = userService.getUsersBetweenLevels(1, 100);
        return userService.filterOnlyActiveUsers(users);
    }

    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
        modelData.setActiveUser(user);
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public MainModel() {
        this.userService = new UserServiceImpl();
        this.modelData = new ModelData();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = getAllUsers();
        modelData.setDisplayDeletedUserList(false);
//        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setUsers(users);
    }

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        this.modelData.setUsers(userService.getAllDeletedUsers());
    }
}
