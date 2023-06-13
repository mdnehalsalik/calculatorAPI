package com.example.calculator.impservice;

import com.example.calculator.dto.AccountsRequestDTO;
//import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.Stack;

//import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public double add(double a, double b) {

        return a + b;
    }

    public double subtract(double a, double b) {

        return a - b;
    }

    public double multiply(double a, double b) {

        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }


    public double calculateSimpleInterest(AccountsRequestDTO requestDTO) {
        double principal = requestDTO.getPrincipal();
        double rate = requestDTO.getInterestRate();
        double time = requestDTO.getTimePeriod();

        // The rate is typically provided in percentage, so we divide it by 100
        double interest = (principal * rate * time) / 100;

        return interest;
    }


    @Override
    public double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                num.append(c);
                while (i + 1 < expression.length() && (Character.isDigit(expression.charAt(i + 1)) || expression.charAt(i + 1) == '.')) {
                    num.append(expression.charAt(i + 1));
                    i++;
                }
                numbers.push(Double.parseDouble(num.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateOperation(numbers, operators);
                }
                operators.pop(); // Pop the opening parenthesis
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    evaluateOperation(numbers, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            evaluateOperation(numbers, operators);
        }

        return numbers.pop();
    }

    private void evaluateOperation(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result = performOperation(num1, num2, operator);
        numbers.push(result);
    }

    private double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

}
