package com.example.kamil.androidcalculator.solver;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeMap;

/**
 * Created by Kamil on 2016-04-17.
 */
public class ExpressionTree extends TreeMap<Integer,ExpressionNode> {

    private ExpressionNode currentNode;

    public Double traverseAndResolve(){
        Double result = 0.0;
        currentNode = this.get(0);
        while (this.size()>0){
            
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
                        if(expression.contains("^")){
                            factors = expression.split("^");
                            evaluatedExpression = Math.pow(Double.parseDouble(factors[0]),Double.parseDouble(factors[1]));
                            for (int i = 1; i < factors.length-1 ; i++) {
                                Double base = evaluatedExpression;
                                Double exponent = Double.parseDouble(factors[i+1]);
                                evaluatedExpression = Math.pow(base, exponent);
                            }
                        }else{
                            String base = expression.substring(expression.indexOf('('),expression.indexOf(')'));
                            if(expression.contains("√")){
                                evaluatedExpression = Math.sqrt(Double.parseDouble(base));
                            }else{
                                if(expression.contains("log")){
                                    evaluatedExpression = Math.log10(Double.parseDouble(base));
                                }
                            }
                        }
                    }
                }
            }
        }
        return evaluatedExpression;
    }

    public ExpressionNode findNextChild(int idParent){
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
