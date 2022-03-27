package pl.suncode.recruitmentTask.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.suncode.recruitmentTask.model.TestTable;
import java.util.List;

@Repository
public interface TestTableRepository extends CrudRepository<TestTable, Long> {

    @Query(value = "select * from tabela_testowa tt\n" +
            "where kolumna1 in (select kolumna1 from tabela_testowa\n" +
            "                   group by kolumna1\n" +
            "                   having count(*) >1);",
            nativeQuery = true)
    List<TestTable> getDuplicateRecordsByColumn1();

    @Query(value = "select * from tabela_testowa tt\n" +
            "where kolumna2 in (select kolumna2 from tabela_testowa\n" +
            "                   group by kolumna2\n" +
            "                   having count(*) >1);",
            nativeQuery = true)
    List<TestTable> getDuplicateRecordsByColumn2();

    @Query(value = "select * from tabela_testowa tt\n" +
            "where kolumna3 in (select kolumna3 from tabela_testowa\n" +
            "                   group by kolumna3\n" +
            "                   having count(*) >1);",
            nativeQuery = true)
    List<TestTable> getDuplicateRecordsByColumn3();

    @Query(value = "select * from tabela_testowa tt\n" +
            "where kolumna4 in (select kolumna4 from tabela_testowa\n" +
            "                   group by kolumna4\n" +
            "                   having count(*) >1);",
            nativeQuery = true)
    List<TestTable> getDuplicateRecordsByColumn4();

    @Query(value = "select tt.* from tabela_testowa tt\n" +
            "where kolumna1 in (select kolumna1 from tabela_testowa\n" +
            "                   group by kolumna1\n" +
            "                   having count(*) =1);",
    nativeQuery = true)
    List<TestTable> getNonDuplicatedRecordsByColumn1();

    @Query(value = "select tt.* from tabela_testowa tt\n" +
            "where kolumna2 in (select kolumna2 from tabela_testowa\n" +
            "                   group by kolumna2\n" +
            "                   having count(*) =1);",
            nativeQuery = true)
    List<TestTable> getNonDuplicatedRecordsByColumn2();

    @Query(value = "select tt.* from tabela_testowa tt\n" +
            "where kolumna3 in (select kolumna3 from tabela_testowa\n" +
            "                   group by kolumna3\n" +
            "                   having count(*) =1);",
            nativeQuery = true)
    List<TestTable> getNonDuplicatedRecordsByColumn3();

    @Query(value = "select tt.* from tabela_testowa tt\n" +
            "where kolumna4 in (select kolumna4 from tabela_testowa\n" +
            "                   group by kolumna4\n" +
            "                   having count(*) =1);",
            nativeQuery = true)
    List<TestTable> getNonDuplicatedRecordsByColumn4();
}

