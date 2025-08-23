package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลรายการนักเรียน")
    void testReadData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertNotNull(list);
        assertNotNull(list.getStudents());
        assertEquals(10, list.getStudents().size());
        assertEquals("First", list.getStudents().get(0).getName());
        assertEquals("6710400001", list.getStudents().get(0).getId());
        assertEquals("Second", list.getStudents().get(1).getName());
        assertEquals("6710400002", list.getStudents().get(1).getId());
        assertEquals("Tenth", list.getStudents().get(9).getName());
        assertEquals("67104000010", list.getStudents().get(9).getId());
    }
}
