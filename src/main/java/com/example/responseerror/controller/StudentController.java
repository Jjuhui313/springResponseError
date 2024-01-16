package com.example.responseerror.controller;

import com.example.responseerror.dto.ApiResponse;
import com.example.responseerror.dto.InputRestriction;
import com.example.responseerror.entity.ErrorCode;
import com.example.responseerror.exception.CustumException;
import com.example.responseerror.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/student")
    public ApiResponse add(
            @RequestParam("name") String name,
            @RequestParam("grade") int grade
    ) {
//        try {
//            inner(name, grade);
//        } catch (Exception e) {
//            throw new CustumException(ErrorCode.SERVER_ERROR, "grade는 6이상을 입력 할 수 없습니다.", null);
//        }

        if(grade >= 6) {
            throw new CustumException(ErrorCode.SERVER_ERROR, "grade는 6 이상을 입력 할 수 없습니다.", new InputRestriction(6));
        }
        return makeResponse(studentService.addStudent(name, grade));
    }

    @GetMapping("/students")
    public ApiResponse getAllStudents() {
        return makeResponse(studentService.getAll());
    }

    @GetMapping("/students/{grade}")
    public ApiResponse getStudentsGrade(
            @PathVariable("grade") int grade
    ) {
        return makeResponse(studentService.getStudentGrade(grade));
    }

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }
    public <T> ApiResponse<T> makeResponse(List<T> results) {
        return new ApiResponse<>(results);
    }

    public ApiResponse inner(String name, int grade) {
        throw new CustumException(ErrorCode.SERVER_ERROR, "inner: grade는 6이상 입력할 수 없습니다.", new InputRestriction(6));
    }

}
