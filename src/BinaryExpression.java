public class BinaryExpression extends Expression {

    private Expression left;

    private Expression right;

    private OPERATOR op;

    public BinaryExpression(Expression left, Expression right, OPERATOR op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
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
