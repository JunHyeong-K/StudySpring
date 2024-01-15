package hello.Hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")//이건 주소 localhost:8080/hello
    public String hello(Model model){//template 엔진을 찾아서
        model.addAttribute("data", "hello!!");//이 데이터값을 찾은후에 키값으 넣어
        return "hello"; //이건 내부에서 연결할 html 파일
    }
    @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
        //requsetparam 이 들어왔을때 값을 넣어줘야 넘어간다.
            model.addAttribute("name", name);
            return "hello-template";
        }
    @GetMapping("hello-string")
    @ResponseBody //template 엔진을 안쓰고 그대로 데이터를 넣는 방식
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api") //api 객체를 넣는방식 json -> 키 : 밸류 로 이루어짐
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
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




