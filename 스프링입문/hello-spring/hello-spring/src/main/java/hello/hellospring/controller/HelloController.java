package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){

        // Data에 "hello!!"를 넣어놨기 때문에 /hello로 접속했을 시 `안녕하세요. hello!!` 가 뜨게 된다.
        model.addAttribute("data", "hello!!");

        // hello.html 파일을 찾아 렌더링
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 방식
    @GetMapping("hello-string")
    // http에서 헤더부와 바디부, 그 중에서 바디부를 뜻한다. (바디부에 이 내용을 직접 넣어주겠다는 의미)
    // view 없이 문자 그대로 전송
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    // 객체를 JSON 형태로 직접 넘김
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        // 객체 생성
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 클래스 선언
    // 클래스 안 클래스 가능
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}