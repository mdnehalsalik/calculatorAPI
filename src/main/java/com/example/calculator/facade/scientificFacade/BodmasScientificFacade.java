package com.example.calculator.facade.scientificFacade;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Component
public class BodmasScientificFacade {

    public double performBodmasOperation(List<String> expression) {
        // Remove all whitespaces from the expression
        expression = Collections.singletonList(expression.get(0).replaceAll("\\s+", ""));

        // Evaluate the expression using the BODMAS algorithm
        double result;
        result = evaluateExpression(expression.get(0));

        return result;
    }

    private double evaluateExpression(String expression) {
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
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
}
