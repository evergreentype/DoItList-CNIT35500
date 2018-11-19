package Functional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TasksControl implements Serializable
{
    private List<Task> Tasks = new ArrayList<>();

    // Returns the added task if successful
    public Task addTask(String name, String detail, Course course, LocalDateTime deadline, Integer timeEst)
    {
        // Try to set the values
        Task task = new Task();

        task.setName(name);
        task.setDetail(detail);
        task.setCourse(course);
        task.setDeadline(deadline);
        task.setDateAdded(LocalDateTime.now());
        task.setTimeEst(timeEst);
        task.setStatusFinished(false);

        // Try to add to the list
        Tasks.add(task);

        return task;
    }

    public Task updateTask(Task xTask, String name, String detail, Course course, LocalDateTime deadline, Integer timeEst)
    {
        // Try to set the values
        xTask.setName(name);
        xTask.setDetail(detail);
        xTask.setCourse(course);
        xTask.setDeadline(deadline);
        xTask.setTimeEst(timeEst);

        return xTask;
    }

    // Remove a task with a name
    // True if successful removal
    public boolean removeTask(Task xTask)
    {
        Task task = null;

        // Check if a course with the name already exists
        for (Task iTask : Tasks)
        {
            if (xTask.equals(iTask))
                task = iTask;
        }

        // Try to remove
        if (task == null)
            return false;
        else
            return Tasks.remove(task);
    }

    // Get an array of all tasks
    public Task[] getTasks()
    {
        return Tasks.toArray(new Task[0]);
    }

    public Task getTaskAt(Integer index) {return Tasks.get(index);}

    public int getTaskIndexFor(Task xTask)
    {
        return Tasks.indexOf(xTask);
    }
}
