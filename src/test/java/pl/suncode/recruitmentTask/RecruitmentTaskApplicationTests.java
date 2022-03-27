package pl.suncode.recruitmentTask;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.suncode.recruitmentTask.exceptions.ResultNotFoundException;
import pl.suncode.recruitmentTask.model.TestTable;
import pl.suncode.recruitmentTask.repository.TestTableRepository;
import pl.suncode.recruitmentTask.service.TestTableService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class RecruitmentTaskApplicationTests {

	List<TestTable> table = new ArrayList<>();

	@MockBean
	TestTableRepository repository;

	@Autowired
	TestTableService service;

	@BeforeAll
	public void initializeTestDatabase(){
		TestTable testTable1 = new TestTable(1L,"wartość1","wartość2","wartość3",1L);
		TestTable testTable2 = new TestTable(2L,"warość21","wartość22","wartość23",5L);
		TestTable testTable3 = new TestTable(3L,"wartość31","wartość22","wartość32",6L);
		TestTable testTable4 = new TestTable(4L,"wartość54","wartość43","wartość45",4L);
		TestTable testTable5 = new TestTable(5L,"wartość43","wartość23","wartość34",4L);
		TestTable testTable6 = new TestTable(6L,"wartość43","wartość54","wartość43",2L);
		TestTable testTable7 = new TestTable(7L,"wartość54","wartość52","wartość53",8L);
		TestTable testTable8 = new TestTable(8L,"wartość21","wartość2211","wartość43",4L);
		TestTable testTable9 = new TestTable(9L,"wartość43","wartość33","wartość45",9L);
		TestTable testTable10 = new TestTable(10L,"wartość87","wartość62","wartość11",3L);
		table.add(testTable1);
		table.add(testTable2);
		table.add(testTable3);
		table.add(testTable4);
		table.add(testTable5);
		table.add(testTable6);
		table.add(testTable7);
		table.add(testTable8);
		table.add(testTable9);
		table.add(testTable10);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void gettingDuplicateValues(){
		//Given
		List<String> list = new ArrayList<>();
		List<Long> list2 = new ArrayList<>();

		String text1 = "wartość23";
		String text2 = "wartość23";
		String text3 = "wartość33";
		String text4 = "wartość33";
		String text5 = "wartość35";
		String text6 = "wartość36";
		list.add(text1);
		list.add(text2);
		list.add(text3);
		list.add(text4);
		list.add(text5);
		list.add(text6);

		long number1 = 13;
		long number2 = 13;
		long number3 = 44;
		long number4 = 12;
		long number5 = 888;
		long number6 = 44;
		long number7 = 513;
		long number8 = 3;
		long number9 = 15;
		long number10 = 44;
		list2.add(number1);
		list2.add(number2);
		list2.add(number3);
		list2.add(number4);
		list2.add(number5);
		list2.add(number6);
		list2.add(number7);
		list2.add(number8);
		list2.add(number9);
		list2.add(number10);

		//When
		List<String> stringDuplicates = service.getStringDuplicates(list);
		List<Long> longDuplicates = service.getLongDuplicates(list2);

		//Then
		Assertions.assertEquals(2,stringDuplicates.size());
		Assertions.assertEquals(2,longDuplicates.size());
		Assertions.assertTrue(stringDuplicates.contains("wartość23"));
		Assertions.assertTrue(longDuplicates.contains(44L));
	}

	@Test
	public void getRecordsWithAndWithoutDuplicates() throws ResultNotFoundException {
		//Given & When
		Mockito.when(repository.findAll()).thenReturn(table);

		List<TestTable> duplicateList1 = service.getRecordsWithDuplicateValues(1);
		List<TestTable> duplicateList2 = service.getRecordsWithDuplicateValues(2);
		List<TestTable> duplicateList3 = service.getRecordsWithDuplicateValues(3);
		List<TestTable> duplicateList4 = service.getRecordsWithDuplicateValues(4);
		List<TestTable> nonDuplicateList1 = service.getNonDuplicatedRecords(1);
		List<TestTable> nonDuplicateList2 = service.getNonDuplicatedRecords(2);
		List<TestTable> nonDuplicateList3 = service.getNonDuplicatedRecords(3);
		List<TestTable> nonDuplicateList4 = service.getNonDuplicatedRecords(4);

		//Then
		Assertions.assertEquals(5,duplicateList1.size());
		Assertions.assertEquals(2,duplicateList2.size());
		Assertions.assertEquals(4,duplicateList3.size());
		Assertions.assertEquals(3,duplicateList4.size());
		Assertions.assertEquals(5,nonDuplicateList1.size());
		Assertions.assertEquals(8,nonDuplicateList2.size());
		Assertions.assertEquals(6,nonDuplicateList3.size());
		Assertions.assertEquals(7,nonDuplicateList4.size());

	}
}
