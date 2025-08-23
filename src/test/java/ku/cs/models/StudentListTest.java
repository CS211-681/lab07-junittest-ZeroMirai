package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList students;

    @BeforeEach
    void setup() {
        students = new StudentList();
        students.addNewStudent("0001", "Sakura bakushin O", 0);
        students.addNewStudent("0002", "Majiro Mcqueen", 10);
        students.addNewStudent("0003", "Majiro Kane", 40);
    }


    @Test
    @DisplayName("ทดสอบว่า ข้อมูลถูก Add ไปจริงไหม และใส่ข้อมูลไปถูกไหม")
    void testAddNewStudent() {
        students.addNewStudent("0004", "Daiwa Scarlet", 10);
        Student s = students.findStudentById("0004");
        assertEquals(4, students.getStudents().size());
        assertEquals("0004", s.getId());
        assertEquals("Daiwa Scarlet", s.getName());
        assertEquals(10, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการหา student ด้วย ID")
    void testFindStudentById() {
        Student searchedStudent = students.findStudentById("0003");
        assertEquals("0003" ,searchedStudent.getId());
    }

    @Test
    @DisplayName("ทดสอบการ filter ด้วยชื่อ")
    void testFilterByName() {
        StudentList filteredStudent = students.filterByName("Majiro");

        for (Student student : filteredStudent.getStudents()){
            assertTrue(student.isNameContains("Majiro"));
        }
        for (Student student : filteredStudent.getStudents()){
            assertFalse(student.isNameContains("Sakura"));
        }
    }

    @Test
    @DisplayName("ทดสอบเพิ่มคะแนนไป 40")
    void testGiveScoreToId() {
        students.giveScoreToId("0001", 40);
        Student s = students.findStudentById("0001");
        assertEquals(40, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน แล้วดู grade")
    void testViewGradeOfId() {
        students.giveScoreToId("0001", 85);
        assertEquals("A", students.viewGradeOfId("0001"));

    }
}