package Functional;

import android.graphics.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoursesControl implements Serializable
{
    private List<Course> Courses = new ArrayList<>();

    // Checks before adding a course
    // Returns the added course if successful
    public Course addCourse(String xName, Integer xAssociatedColor)
    {
        Course course = new Course();

        // Try to set the name
        if (!setNameCheck(course, xName))
            return null;

        course.setAssociatedColor(xAssociatedColor);

        // Try to add to the list
        Courses.add(course);

        return course;
    }

    // Remove a course with a name
    // True if successful removal
    public boolean removeCourse(String xName)
    {
        Course course = null;

        // Check if a course with the name already exists
        for (Course iCourse : Courses)
        {
            if (xName.equals(iCourse.getName()))
                course = iCourse;
        }

        // Try to remove
        if (course == null)
            return false;
        else
            return Courses.remove(course);
    }

    // Get an array of all courses
    public Course[] getCourses()
    {
        return Courses.toArray(new Course[0]);
    }

    // True if successful set
    public boolean setNameCheck(Course xCourse, String xName)
    {
        // Check if a course with the name already exists
        for (Course iCourse : Courses)
        {
            if (xName.equals(iCourse.getName()))
                return false;
        }

        // Check if name satisfies other Set requirements
        return xCourse.setName(xName);
    }

    public Course getCourseAt(Integer index)
    {
        return Courses.get(index);
    }

    public Course getCourseWithName(String name)
    {
        for (Course iCourse : Courses)
            if (iCourse.getName().equals(name))
                return iCourse;

        return null;
    }
}