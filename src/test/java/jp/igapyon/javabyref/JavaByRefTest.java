package jp.igapyon.javabyref;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class JavaByRefTest {
    public void myMethod(ByRef<JavaByRefSampleObjForTest> arg1) {
        JavaByRefSampleObjForTest target = arg1.getVal();
        try {
            // 実際の処理コード.
            target = new JavaByRefSampleObjForTest();

        } finally {
            // ByRef値の埋め戻し.
            arg1.setVal(target);
        }
    }

    @Test
    public void sampleOfCallingMethodWithByRef() {
        JavaByRefSampleObjForTest target = new JavaByRefSampleObjForTest();

        // ByRef フィールドの値セット
        final ByRef<JavaByRefSampleObjForTest> arg1 = new ByRef<JavaByRefSampleObjForTest>(target);
        myMethod(arg1);
        // ByRef値の埋め戻し.
        target = arg1.getVal();

        assertTrue(true);
    }
}
