package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentTest {
    private Student s;
//    @BeforeAll
//    static void initial(){
//        s = new Student("6xxxxxxxxx", "StudentTest");
//    }

    @BeforeEach
    void setup(){
        s = new Student("6xxxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อเป็น StudentTestChangeName")
    void testChangeName() {
        s.changeName("StudentTestChangeName");
        assertEquals("StudentTestChangeName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเช็คชื่อว่าตรงกันไหม")
    void testIsId() {
        assertTrue(s.isId("6xxxxxxxxx"));
        assertFalse(s.isId("0xxxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการเช็คว่าชื่อ student มีคำว่า student ไหม")
    void testIsNameContains() {
        assertTrue(s.isNameContains("Student"));
    }
}