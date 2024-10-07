import java.util.*;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public boolean enroll() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public boolean drop() {
        if (enrolled > 0) {
            enrolled--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s (Enrolled: %d/%d)",
                courseCode, title, description, enrolled, capacity);
    }
}

class Student {
    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        if (course.enroll()) {
            registeredCourses.add(course);
            System.out.println("Successfully registered for " + course.getTitle());
        } else {
            System.out.println("Course " + course.getTitle() + " is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            if (course.drop()) {
                System.out.println("Successfully dropped " + course.getTitle());
            }
        } else {
            System.out.println("You are not registered for " + course.getTitle());
        }
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}

class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("-".repeat(15)));
        System.out.println("|"+" UNIVERSITY "+"|");
        System.out.println(("-".repeat(15)+"\n"));
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        system.addCourse(new Course("CS101", "Intro to Computer Science", "Learn the basics of programming.", 3));
        system.addCourse(new Course("ME101", "Mechanical engineering", "An introduction Mechanil things.", 2));
        system.addCourse(new Course("ENG101", "English Literature", "Study of classic literature.", 5));

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentId, studentName);
        system.addStudent(student);

        boolean running = true;

        while (running) {
            System.out.println("\n1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    system.displayCourses();
                    break;
                case 2:
                    system.displayCourses();
                    System.out.print("Enter course code to register: ");
                    String courseCodeToRegister = scanner.nextLine();
                    Course courseToRegister = system.findCourse(courseCodeToRegister);
                    if (courseToRegister != null) {
                        student.registerCourse(courseToRegister);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String courseCodeToDrop = scanner.nextLine();
                    Course courseToDrop = system.findCourse(courseCodeToDrop);
                    if (courseToDrop != null) {
                        student.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}
