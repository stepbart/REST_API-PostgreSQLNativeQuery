package pl.suncode.recruitmentTask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.suncode.recruitmentTask.exceptions.ResultNotFoundException;
import pl.suncode.recruitmentTask.model.TestTable;
import pl.suncode.recruitmentTask.repository.TestTableRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TestTableService {

    private final TestTableRepository repository;

    public List<TestTable> getRecordsWithDuplicateValues(int columnNumber) throws ResultNotFoundException {
        List<TestTable> table = (List<TestTable>) repository.findAll();
        List<TestTable> listToShow = new ArrayList<>();
        if (columnNumber == 1 || columnNumber == 2 || columnNumber == 3){
            List<String> strings = new ArrayList<>();
            for (TestTable testTable : table){
                strings.add((String) testTable.getKolumna(columnNumber));
            }
            List<String> duplicates = getStringDuplicates(strings);
            for (TestTable testTable : table){
                if (duplicates.contains(testTable.getKolumna(columnNumber))){
                    listToShow.add(testTable);
                }
            }
        }
        else if (columnNumber == 4){
            List<Long> longs = new ArrayList<>();
            for (TestTable testTable : table){
                longs.add(testTable.getKolumna4());
            }
            List<Long> duplicates = getLongDuplicates(longs);
            for (TestTable testTable : table){
                if (duplicates.contains(testTable.getKolumna4())){
                    listToShow.add(testTable);
                }
            }
        }
        else {
            throw new ResultNotFoundException();
        }
        return listToShow;
    }

    public List<TestTable> getNonDuplicatedRecords(int columnNumber) throws ResultNotFoundException {
        List<TestTable> table = (List<TestTable>) repository.findAll();
        List<TestTable> listToShow = new ArrayList<>();
        if (columnNumber == 1 || columnNumber == 2 || columnNumber == 3){
            List<String> strings = new ArrayList<>();
            for (TestTable testTable : table){
                strings.add((String) testTable.getKolumna(columnNumber));
            }
            List<String> duplicates = getStringDuplicates(strings);
            for (TestTable testTable : table){
                if (!duplicates.contains(testTable.getKolumna(columnNumber))){
                    listToShow.add(testTable);
                }
            }
        }
        else if (columnNumber == 4){
            List<Long> longs = new ArrayList<>();
            for (TestTable testTable : table){
                longs.add(testTable.getKolumna4());
            }
            List<Long> duplicates = getLongDuplicates(longs);
            for (TestTable testTable : table){
                if (!duplicates.contains(testTable.getKolumna4())){
                    listToShow.add(testTable);
                }
            }
        }
        else {
            throw new ResultNotFoundException();
        }
        return listToShow;
    }

    public List<String> getStringDuplicates(List<String> stringList) {
        Set<String> set = new HashSet<>();
        Set<String> results = new HashSet<>();

        for (String value : stringList) {
            if (!set.add(value)) {
                results.add(value);
            }
        }
        return new ArrayList<>(results);
    }

    public List<Long> getLongDuplicates(List<Long> longList) {
        Set<Long> set = new HashSet<>();
        Set<Long> results = new HashSet<>();

        for (Long value : longList) {
            if (!set.add(value)) {
                results.add(value);
            }
        }
        return new ArrayList<>(results);
    }

    public List<TestTable> getDuplicatesUsingNativeNamedQuery(int columnNumber) throws ResultNotFoundException {
        List<TestTable> results;
        if (columnNumber == 1){
            results = repository.getDuplicateRecordsByColumn1();
        }
        else if (columnNumber == 2){
            results = repository.getDuplicateRecordsByColumn2();
        }
        else if (columnNumber == 3){
            results = repository.getDuplicateRecordsByColumn3();
        }
        else if (columnNumber == 4){
            results = repository.getDuplicateRecordsByColumn4();
        }
        else {
            throw new ResultNotFoundException();
        }
        return results;
    }

    public List<TestTable> getNonDuplicatedRecordsUsingNativeNamedQuery(int columnNumber) throws ResultNotFoundException {
        List<TestTable> results;
        if (columnNumber == 1){
            results = repository.getNonDuplicatedRecordsByColumn1();
        }
        else if (columnNumber == 2){
            results = repository.getNonDuplicatedRecordsByColumn2();
        }
        else if (columnNumber == 3){
            results = repository.getNonDuplicatedRecordsByColumn3();
        }
        else if (columnNumber == 4){
            results = repository.getNonDuplicatedRecordsByColumn4();
        }
        else {
            throw new ResultNotFoundException();
        }
        return results;
    }

    public List<List<TestTable>> getfinalList(int columnNumber) throws ResultNotFoundException {
        List<List<TestTable>> resultLists = new ArrayList<>();
        List<TestTable> listWithDuplicates = getDuplicatesUsingNativeNamedQuery(columnNumber);
        List<TestTable> listWithoutDuplicates = getNonDuplicatedRecordsUsingNativeNamedQuery(columnNumber);
        resultLists.add(listWithDuplicates);
        resultLists.add(listWithoutDuplicates);
        return resultLists;
    }

}
