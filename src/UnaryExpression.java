public class UnaryExpression extends Expression {

    private Expression right;

    private OPERATOR op;

    public UnaryExpression(Expression right, OPERATOR op) {
        this.right = right;
        this.op = op;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public OPERATOR getOp() {
        return op;
    }

    public void setOp(OPERATOR op) {
        this.op = op;
    }

    @Override
    public void accept(IExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
