package pl.suncode.recruitmentTask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.suncode.recruitmentTask.exceptions.ResultNotFoundException;
import pl.suncode.recruitmentTask.model.TestTable;
import pl.suncode.recruitmentTask.service.TestTableService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/suncode")
public class TestTableController {

    private final TestTableService service;

    @GetMapping("/records")
    public ResponseEntity<List<List<TestTable>>> getRecords(@RequestParam("columnNumber") int columnNumber) throws ResultNotFoundException {
        return new ResponseEntity<>(service.getfinalList(columnNumber), HttpStatus.OK);
    }
}
