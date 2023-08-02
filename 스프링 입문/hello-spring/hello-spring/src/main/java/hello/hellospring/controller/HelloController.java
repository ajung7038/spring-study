package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){

        // Data에 "hello!!"를 넣어놨기 때문에 /hello로 접속했을 시 `안녕하세요. hello!!` 가 뜨게 된다.
        model.addAttribute("data", "hello!!");

        // hello.html 파일을 찾아 렌더링
        return "hello";
    }
}