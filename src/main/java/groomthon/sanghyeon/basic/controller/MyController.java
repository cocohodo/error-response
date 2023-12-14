package groomthon.sanghyeon.basic.controller;

import groomthon.sanghyeon.basic.common.ApiResponse;
import groomthon.sanghyeon.basic.common.ErrorCode;
import groomthon.sanghyeon.basic.entity.Student;
import groomthon.sanghyeon.basic.exception.CustomException;
import groomthon.sanghyeon.basic.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class MyController extends BaseController{
    private final StudentService studentService;

    @GetMapping("/test")
    public ApiResponse<String> test() {
        return makeResponse("OK");
    }

    @GetMapping("/add")
    public ApiResponse<Student> add(@RequestParam("name") String name, @RequestParam("grade") int grade) {
        if(grade>5){
            throw new CustomException(ErrorCode.BAD_REQUEST,"grade는 5를 넘을 수 없습니다.",grade);
        }
        Student student = studentService.addStudent(name, grade);


        return makeResponse(student);
    }
    @GetMapping("/students")
    public ApiResponse<Student> getAll() {
        List<Student> students = studentService.getAll();
        System.out.println("students = " + students);
        return makeResponse(students);
    }
    @GetMapping("/student")
    public ApiResponse<Student> get (@RequestParam("grade") int grade) {
        List<Student> students = studentService.get(grade);
        return  makeResponse(students);
    }
}
