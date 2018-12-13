/**
 * This file was generated by the Jeddict
 */
package futuretechschool.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Andreas N
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String name;

    @Basic
    private LocalDate birthdate;

    @ManyToOne
    private Education education;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Course> courses;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Education getEducation() {
        return this.education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<Course> getCourses() {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return this.courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        getCourses().add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        getCourses().remove(course);
        course.getStudents().remove(this);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getId() == ((Student) obj).getId();
    }

    public String toStringSimple() {
        return "Student" + " | id: " + id + " | name: " + name + " | birthdate: " + birthdate + " | education: " + education + " | courses: " + "\n" + courses;
    }

    public String toString() {
        return String.format("%6s|%-3s|%-20s", "Student", this.getId(), this.getName()).toUpperCase();
    }
}
