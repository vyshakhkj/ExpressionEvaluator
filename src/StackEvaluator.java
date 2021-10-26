import java.util.Stack;

public class StackEvaluator implements IExpressionVisitor {

    private Stack<Double> evalStack = new Stack<>();

    public double getValue() {
        return evalStack.pop();
    }

    public StackEvaluator() {
        evalStack.clear();
    }

    @Override
    public void visit(Number number) {
        evalStack.push(number.getNumber());
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        binaryExpression.getLeft().accept(this);
        binaryExpression.getRight().accept(this);
        if (binaryExpression.getOp().equals(OPERATOR.PLUS)) {
            evalStack.push(evalStack.pop() + evalStack.pop());
        } else if(binaryExpression.getOp().equals(OPERATOR.MUL)) {
            evalStack.push(evalStack.pop() * evalStack.pop());
        } else if(binaryExpression.getOp().equals(OPERATOR.DIV)) {
            double dVal = evalStack.pop();
            if(dVal == 0) {
                throw new ArithmeticException("Division by zero error");
            }
            evalStack.push(evalStack.pop() / evalStack.pop());
        } else if(binaryExpression.getOp().equals(OPERATOR.MINUS)) {
            evalStack.push(evalStack.pop() - evalStack.pop());
        }
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        unaryExpression.getRight().accept(this);
        if(unaryExpression.getOp().equals(OPERATOR.PLUS)) {
            evalStack.push(evalStack.pop());
        } else if(unaryExpression.getOp().equals(OPERATOR.MINUS)) {
            evalStack.push(- evalStack.pop());
        }
    }
}
