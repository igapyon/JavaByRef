package jp.igapyon.javabyref;

/**
 * ByRef for Java.
 * 
 * ByRef provides ref function into Java.
 * 
 * <p>
 * usage: method.
 * </p>
 * 
 * <pre>
 * public void myMethod(final ByRef&lt;TargetObj&gt; arg1) {
 *     TargetObj target = arg1.getVal();
 *     try {
 * 
 *         // Actual business code.
 *         target = new TargetObj();
 * 
 *     } finally {
 *         arg1.setVal(target);
 *     }
 * }
 * </pre>
 * 
 * <p>
 * usage: caller.
 * </p>
 * 
 * <pre>
 * TargetObj target = new TargetObj();
 * 
 * // fill value of ByRef.
 * final ByRef&lt;TargetObj&gt; arg1 = new ByRef&lt;TargetObj&gt;(target);
 * myMethod(arg1);
 * // apply result of ByRef.
 * target = arg1.getVal();
 * </pre>
 * 
 * @param <T>
 *            target class.
 */
public class ByRef<T> {
    private T val = null;

    public ByRef(T origVal) {
        this.val = origVal;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T newVal) {
        val = newVal;
    }
}
