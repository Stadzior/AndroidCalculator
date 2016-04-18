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

    public Double solveExpression(String expression) throws Exception{
        Double evaluatedExpression = 0.0;
        String[] factors;
        if(expression.contains("+")){
            factors = expression.split("\\+");
            evaluatedExpression= Double.parseDouble(factors[0]);
            evaluatedExpression+= Double.parseDouble(factors[1]);
        }else{
            if(expression.contains("-")){
                factors = expression.split("\\-");
                evaluatedExpression= Double.parseDouble(factors[0]);
                evaluatedExpression-= Double.parseDouble(factors[1]);
            }else{
                if(expression.contains("/")){
                    factors = expression.split("/");
                    evaluatedExpression= Double.parseDouble(factors[0]);
                    evaluatedExpression/= Double.parseDouble(factors[1]);
                }else{
                    if(expression.contains("*")){
                        factors = expression.split("\\*");
                        evaluatedExpression= Double.parseDouble(factors[0]);
                        evaluatedExpression*= Double.parseDouble(factors[1]);
                    }else{
                        if(expression.contains("^")){
                            factors = expression.split("\\^");
                            //throw new Exception(factors[0] + "  " + factors[1]);
                            evaluatedExpression = Math.pow(Double.parseDouble(factors[0]), Double.parseDouble(factors[1]));
                        }else{
                            if(expression.contains("√")){
                                String factor = expression.replace("√(", "");
                                evaluatedExpression = Math.sqrt(Double.parseDouble(factor));
                            }else{
                                if(expression.contains("log")){
                                    String factor = expression.replace("log(", "");
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
