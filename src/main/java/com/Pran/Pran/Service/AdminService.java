package com.Pran.Pran.Service;

import com.Pran.Pran.Model.*;
import com.Pran.Pran.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final CourseRepo courseRepo;
    private final UserInfoRepo userInfoRepo;

    @Autowired
    private UserCourseRepo userCourseRepo;

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskCompleted taskCompleted;

    @Autowired
    public AdminService(CourseRepo courseRepo,UserInfoRepo userInfoRepo){
        this.courseRepo=courseRepo;
        this.userInfoRepo=userInfoRepo;
    }


    //-----courses-------//
    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    public void addCourseToDb(Course course) {
        courseRepo.addCourse(course);
    }

    public void deleteCourseFromDb(int id) {
        //userCourseRepo.delete(id);
        //tasksRepo.deleteCourse(id);
        courseRepo.deleteCourse(id);
    }

    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }

    //-----userInfo------//

    public List<UserInfo> getALlUserInfo() {
        return userInfoRepo.getAllUsers();
    }

    public void addTaskToDb(Task task) {
        tasksRepo.save(task);
    }

    public void deleteTaskFromDb(int id) {
        tasksRepo.delete(id);
    }

    public void addCompletedTaskToDb(String username, String link) {
        taskCompleted.addTask(username,link);
    }

    public List<TasksCompletedModel> getSubmittedTasks() {
        return taskCompleted.getAllSubmits();
    }

    public String getlinkByusername(String username) {
        return taskCompleted.findLinkByUsername(username);
    }

    public List<Task> getalltasks() {
        return tasksRepo.getalltasksrepo();
    }

    public List<CourseIdCat> getcourseidcat() {
        return courseRepo.getcourseIdCat();
    }
}