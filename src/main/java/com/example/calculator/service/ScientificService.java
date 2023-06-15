//package com.example.calculator.service;
//
//import org.springframework.stereotype.Service;
//import java.util.*;
//
//@Service
//public class ScientificService {
//    public double evaluateExpression(String expression) {
//        char[] tokens = expression.toCharArray();
//
//        Stack<Double> values = new Stack<Double>();
//        Stack<Character> ops = new Stack<Character>();
//
//        for (int i = 0; i < tokens.length; i++) {
//
//            if (tokens[i] == ' ')
//                continue;
//
//            if (tokens[i] >= '0' && tokens[i] <= '9') {
//                StringBuffer sbuf = new StringBuffer();
//
//                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
//                    sbuf.append(tokens[i++]);
//                values.push(Double.parseDouble(sbuf.toString()));
//                i--; // decrement as the outer loop will increment it
//            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
//
//                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
//                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//
//                ops.push(tokens[i]);
//            }
//        }
//
//        while (!ops.empty())
//            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
//
//        return values.pop();
//    }
//
//    private static boolean hasPrecedence(char op1, char op2) {
//        if (op2 == '(' || op2 == ')')
//            return false;
//        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
//            return false;
//        else
//            return true;
//    }
//
//    private static double applyOp(char op, double b, double a) {
//        switch (op) {
//            case '+':
//                return a + b;
//            case '-':
//                return a - b;
//            case '*':
//                return a * b;
//            case '/':
//                if (b == 0)
//                    throw new UnsupportedOperationException("Cannot divide by zero");
//                return a / b;
//        }
//        return 0;
//    }
//}
//
//

package com.example.calculator.service;

import com.example.calculator.dto.ScientificRequestDTO;
import com.example.calculator.factory.ScientificFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScientificService {

    private final ScientificFactory scientificFactory;

    @Autowired
    public ScientificService(ScientificFactory scientificFactory) {

        this.scientificFactory = scientificFactory;
    }

    public double performOperation(ScientificRequestDTO requestDTO) {
        return scientificFactory.executeOperation(requestDTO);
    }
}
