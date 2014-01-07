package net.paoding.analysis.t;

import net.paoding.analysis.analyzer.PaodingTokenizer;
import net.paoding.analysis.analyzer.impl.MaxWordLengthTokenCollector;
import net.paoding.analysis.knife.Paoding;
import org.junit.Test;

import java.io.StringReader;

/**
 * <pre>
 *
 * Created by IntelliJ IDEA.
 * User: ZhenQin
 * Date: 14-1-7
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 *
 * </pre>
 *
 * @author ZhenQin
 */
public class SplitTest {

    public SplitTest() {
        //org.apache.lucene.index.FieldInvertState
    }


    @Test
    public void testSplitChinese() throws Exception {
        String txt = "汉文化和服装 汉文化";
        PaodingTokenizer tokenizer = new PaodingTokenizer(
                new StringReader(txt),
                new Paoding(),
                new MaxWordLengthTokenCollector());

        System.out.println(tokenizer);

    }
}
