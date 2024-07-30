public class MVCPatternExample {

    // Step 2: Define Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // Step 3: Define View Class
    static class StudentView {
        public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + studentName);
            System.out.println("ID: " + studentId);
            System.out.println("Grade: " + studentGrade);
        }
    }

    // Step 4: Define Controller Class
    static class StudentController {
        private Student student;
        private StudentView view;

        public StudentController(Student student, StudentView view) {
            this.student = student;
            this.view = view;
        }

        public void setStudentName(String name) {
            student.setName(name);
        }

        public String getStudentName() {
            return student.getName();
        }

        public void setStudentId(int id) {
            student.setId(id);
        }

        public int getStudentId() {
            return student.getId();
        }

        public void setStudentGrade(String grade) {
            student.setGrade(grade);
        }

        public String getStudentGrade() {
            return student.getGrade();
        }

        public void updateView() {
            view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
        }
    }

    // Step 5: Test the MVC Implementation
    public static void main(String[] args) {
        // Create a student model
        Student student = new Student("John Doe", 1, "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
