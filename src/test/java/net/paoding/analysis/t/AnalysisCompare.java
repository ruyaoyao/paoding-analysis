/**
 *
 */
package net.paoding.analysis.t;

import java.io.IOException;
import java.io.StringReader;

import net.paoding.analysis.analyzer.PaodingAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 *
 *
 * @author ZhenQin
 *
 */
public class AnalysisCompare {

    /**
     *
     */
    public AnalysisCompare() {

    }


    public static void parse(Analyzer analyzer, String text) throws IOException {
        TokenStream ts = analyzer.tokenStream("text", new StringReader(text));
        ts.reset();
        // 添加工具类 注意：以下这些与之前lucene2.x版本不同的地方
        CharTermAttribute offAtt = ts.addAttribute(CharTermAttribute.class);
        // 循环打印出分词的结果，及分词出现的位置
        while (ts.incrementToken()) {
            System.out.print(offAtt.toString() + "\t");
        }
        System.out.println();
        ts.close();
    }


    public static void main(String[] args) throws IOException {
        Analyzer paodingAnalyzer = new PaodingAnalyzer();

        String text = "你吃饭了吗";
        parse(paodingAnalyzer, text);
        parse(paodingAnalyzer, text);
        parse(paodingAnalyzer, text);
        parse(paodingAnalyzer, text);
        parse(paodingAnalyzer, text);
    }

}
