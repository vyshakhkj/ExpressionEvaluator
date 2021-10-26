public interface IExpressionVisitor {
    void visit(Number number);

    void visit(BinaryExpression binaryExpression);

    void visit(UnaryExpression unaryExpression);
}
