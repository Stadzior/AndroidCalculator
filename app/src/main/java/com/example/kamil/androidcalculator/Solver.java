package com.example.kamil.androidcalculator;

import java.util.Stack;

/**
 * Created by Kamil on 2016-04-03.
 */
public class Solver {

    private static Stack<String> buildExpresionStack(String expression){
        Stack<String> expressionStack = new Stack<String>();
        return expressionStack;
    }
    private static Double resolveExpresionStack(Stack<String> expressionStack){
        Double result = 0.0;
        Double subResult = 0.0;
        Integer initialStackSize = expressionStack.size();
        for (int i = 0; i < initialStackSize; i++) {
            result = solveExpression(expressionStack.pop(),subResult.toString());
        }
        return result;
    }

    private static Double solveExpression(String expression,String subResult){
        Double evaluatedExpression = 0.0;
        if(expression.contains("+")){

        }else{
            if(expression.contains("-")){

            }else{
                if(expression.contains("/")){

                }else{
                    if(expression.contains("*")){

                    }else{
                        if(expression.contains("^")){

                        }else{
                            if(expression.contains("√")){

                            }else{
                                if(expression.contains("log")){

                                }
                            }
                        }
                    }
                }
            }
        }
        return evaluatedExpression;
    }

    public static Double solveEquation(String expression){
        Stack<String> expressionStack = buildExpresionStack(expression);
        Double result = resolveExpresionStack(expressionStack);
        return result;
    }

}
