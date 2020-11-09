package org.hustle.jdk15.sealed;

/**
 * @author tham
 */
sealed interface IExpr permits ConstantExpr {
    public int eval();
}

final class ConstantExpr implements IExpr {
    private int val;
    ConstantExpr(int val) {
        this.val = val;
    }

    @Override
    public int eval() {
        return val;
    }
}
