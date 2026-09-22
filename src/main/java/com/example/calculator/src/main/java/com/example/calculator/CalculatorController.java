package com.example.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/")
    public String home() {
        return """
                <h1>Simple Calculator</h1>
                <form action="/calculate">
                Number 1: <input name="a" type="number"><br><br>
                Number 2: <input name="b" type="number"><br><br>
                <button name="op" value="add">ADD</button>
                <button name="op" value="sub">SUBTRACT</button>
                <button name="op" value="mul">MULTIPLY</button>
                <button name="op" value="div">DIVIDE</button>
                </form>
                """;
    }

    @GetMapping("/calculate")
    public String calculate(
            @RequestParam int a,
            @RequestParam int b,
            @RequestParam String op) {

        int result = 0;

        if (op.equals("add")) {
            result = a + b;
        } else if (op.equals("sub")) {
            result = a - b;
        } else if (op.equals("mul")) {
            result = a * b;
        } else if (op.equals("div")) {
            result = a / b;
        }

        return "<h1>Result = " + result +
               "</h1><br><a href='/'>Back</a>";
    }
}
