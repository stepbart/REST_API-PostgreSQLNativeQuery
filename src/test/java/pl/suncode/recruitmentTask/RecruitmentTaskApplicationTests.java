package pl.suncode.recruitmentTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.suncode.recruitmentTask.model.TestTable;
import pl.suncode.recruitmentTask.repository.TestTableRepository;
import pl.suncode.recruitmentTask.service.TestTableService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class RecruitmentTaskApplicationTests {

	@Autowired
	TestTableRepository repository;

	@Autowired
	TestTableService service;

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
	public void getRecordsWithAndWithoutDuplicates(){
//		//Given & When
//		List<TestTable> duplicateList1 = service.getRecordsWithDuplicateValues(1);
//		List<TestTable> duplicateList2 = service.getRecordsWithDuplicateValues(2);
//		List<TestTable> duplicateList3 = service.getRecordsWithDuplicateValues(3);
//		List<TestTable> duplicateList4 = service.getRecordsWithDuplicateValues(4);
//
//		List<TestTable> nonDuplicateList1 = service.getNonDuplicatedRecords(1);
//		List<TestTable> nonDuplicateList2 = service.getNonDuplicatedRecords(2);
//		List<TestTable> nonDuplicateList3 = service.getNonDuplicatedRecords(3);
//		List<TestTable> nonDuplicateList4 = service.getNonDuplicatedRecords(4);
//
//		//Then
//		Assertions.assertEquals(5,duplicateList1.size());
//		Assertions.assertEquals(2,duplicateList2.size());
//		Assertions.assertEquals(4,duplicateList3.size());
//		Assertions.assertEquals(3,duplicateList4.size());
//		Assertions.assertEquals(5,nonDuplicateList1.size());
//		Assertions.assertEquals(8,nonDuplicateList2.size());
//		Assertions.assertEquals(6,nonDuplicateList3.size());
//		Assertions.assertEquals(7,nonDuplicateList4.size());

	}
}
