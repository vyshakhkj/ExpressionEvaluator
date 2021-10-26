public class Evaluate {

    public static void main(String[] args) {
        Expression expression = new BinaryExpression(new Number(2),
                new BinaryExpression(
                        new Number(3),
                        new Number(4),
                        OPERATOR.MUL),
                OPERATOR.PLUS);
        System.out.print("Reverse polish notation is : ");
        expression.accept(new ReversePolishEvaluator());
        System.out.println();

        Expression second = new BinaryExpression(new Number(2),
                new BinaryExpression(
                        new Number(3),
                        new Number(4),
                        OPERATOR.MUL
                ), OPERATOR.PLUS);
        StackEvaluator stackEvaluator = new StackEvaluator();
        second.accept(stackEvaluator);
        System.out.println("Result is : " + stackEvaluator.getValue());
    }

}
