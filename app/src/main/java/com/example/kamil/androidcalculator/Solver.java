package com.example.kamil.androidcalculator;

import java.util.Stack;

public class Solver {

    private static Stack<String> buildExpressionStack(String expression) throws IllegalArgumentException{
        Stack<String> expressionStack = new Stack<String>();    //expression = log(-2+4(
        expressionStack.push("3+subResult");
        expressionStack.push("1+2");
        return expressionStack;
    }
    private static Double resolveExpressionStack(Stack<String> expressionStack)throws Exception{
        Double result = 0.0;
        Integer initialStackSize = expressionStack.size();
        for (int i = 0; i < initialStackSize; i++) {
            System.out.println(result.toString());
            result = solveExpression(expressionStack.pop(), result.toString());
        }
        return result;
    }

    private static Double solveExpression(String expression,String subResult) throws Exception{
        Double evaluatedExpression = 0.0;
        expression = expression.replace("subResult",subResult);
        System.out.println(expression);
        String[] factors;
        if(expression.contains("+")){
            factors = expression.split("\\+");
            for(String factor : factors){
                evaluatedExpression+= Double.parseDouble(factor);
            }
        }else{
            if(expression.contains("-")){
                factors = expression.split("\\-");
                for(String factor : factors){
                    evaluatedExpression-= Double.parseDouble(factor);
                }
            }else{
                if(expression.contains("/")){
                    factors = expression.split("/");
                    for(String factor : factors){
                        evaluatedExpression/= Double.parseDouble(factor);
                    }
                }else{
                    if(expression.contains("*")){
                        factors = expression.split("\\*");
                        for(String factor : factors){
                            evaluatedExpression*= Double.parseDouble(factor);
                        }
                    }else{
                        if(expression.contains("^")){
                            factors = expression.split("^");
                            evaluatedExpression = Math.pow(Double.parseDouble(factors[0]),Double.parseDouble(factors[1]));
                            for (int i = 1; i < factors.length-1 ; i++) {
                                Double base = evaluatedExpression;
                                Double exponent = Double.parseDouble(factors[i+1]);
                                evaluatedExpression = Math.pow(base, exponent);
                            }
                        }else{
                            if(expression.contains("√")){
                                evaluatedExpression = Math.sqrt(Double.parseDouble(subResult));
                            }else{
                                if(expression.contains("log")){
                                    evaluatedExpression = Math.log10(Double.parseDouble(subResult));
                                }
                            }
                        }
                    }
                }
            }
        }
        return evaluatedExpression;
    }

    public static Double solveEquation(String expression) throws Exception{
        Stack<String> expressionStack = buildExpressionStack(expression);
        return resolveExpressionStack(expressionStack);
    }
}
