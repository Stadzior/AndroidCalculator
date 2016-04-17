package com.example.kamil.androidcalculator.solver;

import java.util.TreeMap;

/**
 * Created by Kamil on 2016-04-17.
 */
public class ExpressionTree extends TreeMap<Integer,ExpressionNode> {

    private ExpressionNode currentNode;

    public Double traverseAndResolve()throws Exception{
        Double result = 0.0;
        currentNode = this.get(0);
        while (this.size()>0){
            ExpressionNode nextChild = this.findNextChild(currentNode.getIdNode());
            if(nextChild==null){
                if(currentNode.getIdParent()>0){
                    injectResultToParentNode(currentNode.getIdParent(), currentNode.getExpression(), solveExpression(currentNode.getExpression()));
                    this.remove(currentNode.getIdNode());
                    currentNode = this.get(currentNode.getIdParent());
                }
                else{
                    result = solveExpression(currentNode.getExpression());
                }
            }
            else{
                currentNode = nextChild;
            }
        }

        return result;
    }

    public String getFinalExpression()throws Exception{
        String result = "0.0";
        currentNode = this.get(0);
        while (this.size()>0){
            ExpressionNode nextChild = this.findNextChild(currentNode.getIdNode());
            if(nextChild==null){
                if(currentNode.getIdParent()>0){
                    injectResultToParentNode(currentNode.getIdParent(), currentNode.getExpression(), solveExpression(currentNode.getExpression()));
                    this.remove(currentNode.getIdNode());
                    currentNode = this.get(currentNode.getIdParent());
                }
                else{
                    result = currentNode.getExpression();
                }
            }
            else{
                currentNode = nextChild;
            }
        }

        return result;
    }

    private Double solveExpression(String expression) throws Exception{
        Double evaluatedExpression = 0.0;
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
                        String factor = expression.substring(expression.indexOf('('),expression.indexOf(')'));
                        if(expression.contains("^")){
                               evaluatedExpression = Math.pow(Double.parseDouble(expression.substring(0,expression.indexOf('^'))),Double.parseDouble(factor));
//                            factors = expression.split("^");
//                            evaluatedExpression = Math.pow(Double.parseDouble(factors[0]),Double.parseDouble(factors[1]));
//                            for (int i = 1; i < factors.length-1 ; i++) {
//                                Double factor = evaluatedExpression;
//                                Double exponent = Double.parseDouble(factors[i+1]);
//                                evaluatedExpression = Math.pow(factor, exponent);
//                            }
                        }else{
                            if(expression.contains("√")){
                                evaluatedExpression = Math.sqrt(Double.parseDouble(factor));
                            }else{
                                if(expression.contains("log")){
                                    evaluatedExpression = Math.log10(Double.parseDouble(factor));
                                }
                            }
                        }
                    }
                }
            }
        }
        return evaluatedExpression;
    }

    private void injectResultToParentNode(int idParent, CharSequence expression, Double result){
        String nodeExpression = this.get(idParent).getExpression();
        nodeExpression.replace(expression,result.toString());
    }

    private ExpressionNode findNextChild(int idParent){
        ExpressionNode nextChild = null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getIdParent() == idParent)
            {
                nextChild = this.get(i);
            }
        }
        return nextChild;
    }

    public ExpressionNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(ExpressionNode currentNode) {
        this.currentNode = currentNode;
    }
}
