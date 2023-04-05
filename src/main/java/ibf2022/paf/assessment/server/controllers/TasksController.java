package ibf2022.paf.assessment.server.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.MediaType;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    @Autowired
    private TodoService todoService; 

    @PostMapping(path="/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView submitForm(@RequestBody MultiValueMap<String, String> form, Model model){
        String username = form.getFirst("username"); 

        int taskCount = 0;
        for (int i = 0; form.containsKey("description-" + i); i++) {
            String description = form.getFirst("description-" + i);
            Integer priority = Integer.parseInt(form.getFirst("priority-" + i));

            String dueDateString = form.getFirst("dueDate-" + i);
            Date dueDate;
            try {
                dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateString);
            } catch (ParseException e) {
                return new ModelAndView("error", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            Task task = new Task();
            task.setDescription(description);
            task.setPriority(priority);
            task.setDueDate(dueDate);

            User user = new User();
            user.setUsername(username);

            try {
                todoService.upsertTask(user, task);
                taskCount++;
            } catch (Exception e) {
                return new ModelAndView("error", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        model.addAttribute("taskCount", taskCount);
        model.addAttribute("username", username);
        return new ModelAndView("result", model.asMap(), HttpStatus.OK);
    }
}
