package com.example.kamil.androidcalculator.solver;

import com.example.kamil.androidcalculator.solver.ExpressionTree;

public class Solver {

    private static ExpressionTree buildExpressionTree(String expression) throws IllegalArgumentException{
        ExpressionTree expressionTree = new ExpressionTree();

        return expressionTree;
    }

    public static Double solveEquation(String expression) throws Exception{
        ExpressionTree expressionTree = buildExpressionTree(expression);
        return expressionTree.traverseAndResolve();
    }
}
