package com.example.kamil.androidcalculator.solver;

/**
 * Created by Kamil on 2016-04-17.
 */
public class ExpressionNode {

    private int idParent;
    private String expression;
    private int level;
    private int idNode;

    public ExpressionNode( int idNode, int parentId, int level, String expression) {
        this.idParent = parentId;
        this.expression = expression;
        this.level = level;
        this.idNode = idNode;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }
}
