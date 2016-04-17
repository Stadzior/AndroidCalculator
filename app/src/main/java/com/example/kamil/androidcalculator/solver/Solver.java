package com.example.kamil.androidcalculator.solver;

import com.example.kamil.androidcalculator.solver.ExpressionTree;

public class Solver {

    private static ExpressionTree buildExpressionTree(String expression) throws IllegalArgumentException{
        expression = expression.replace("-(","-1*(");
        ExpressionTree expressionTree = new ExpressionTree();
        int idNode = 0;
        int idParent = -1;
        expressionTree.put(idNode,new ExpressionNode(idNode,idParent,expression));
        while(!expression.isEmpty()){

        }

        return expressionTree;
    }

    public static Double solveEquation(String expression) throws Exception{
        ExpressionTree expressionTree = buildExpressionTree(expression);
        return expressionTree.traverseAndResolve();
    }

    public static String getFinalEquation(String expression) throws Exception{
        ExpressionTree expressionTree = buildExpressionTree(expression);
        //return expressionTree.traverseAndResolve();
        return expressionTree.getFinalExpression();
    }
}
