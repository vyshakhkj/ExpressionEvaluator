public class ReversePolishEvaluator implements IExpressionVisitor {

    @Override
    public void visit(Number number) {
        System.out.print(number.getNumber() + " ");
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        if(binaryExpression.getOp().equals(OPERATOR.PLUS)) {
            System.out.print(" + ");
        } else if(binaryExpression.getOp().equals(OPERATOR.MINUS)) {
            System.out.print(" - ");
        } else if(binaryExpression.getOp().equals(OPERATOR.MUL)) {
            System.out.print(" * ");
        } else if(binaryExpression.getOp().equals(OPERATOR.DIV)) {
            System.out.print(" / ");
        }
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getRight().accept(this);
        if(unaryExpression.getOp().equals(OPERATOR.PLUS)) {
            System.out.print(" + ");
        } else if(unaryExpression.getOp().equals(OPERATOR.MINUS)) {
            System.out.print(" - ");
        }
    }
}
