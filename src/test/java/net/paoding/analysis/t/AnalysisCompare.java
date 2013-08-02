/**
 *
 */
package net.paoding.analysis.t;

import java.io.StringReader;

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

    protected Analyzer analyzer = null;

    private StringBuilder analyzerStr = new StringBuilder();
    /**
     *
     */
    public AnalysisCompare() {

    }

    public void dissectA() {
        long time = System.currentTimeMillis();
        try {
            TokenStream ts = analyzer.tokenStream("text", new StringReader(analyzerStr.toString()));
            //添加工具类  注意：以下这些与之前lucene2.x版本不同的地方
//			Token termAtt  = (Token)ts.addAttribute(
//					Token.class);
            CharTermAttribute offAtt  = (CharTermAttribute)ts.addAttribute(CharTermAttribute.class);
            // 循环打印出分词的结果，及分词出现的位置
            while(ts.incrementToken()){
                System.out.print(offAtt.toString() + " ");
            }
            System.out.println();
            System.out.println("Time: " + (System.currentTimeMillis() - time));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public void setAnalyzer(Analyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void setAnalyzerStr(StringBuilder analyzerStr) {
        this.analyzerStr = analyzerStr;
    }

    public StringBuilder getAnalyzerStr() {
        return analyzerStr;
    }

    public void addStr(String str){
        analyzerStr.append(str);
    }

    public void setUp(){
        setAnalyzer(new net.paoding.analysis.analyzer.PaodingAnalyzer());
		addStr("非关系数据库 财经郎眼");
		addStr("汉文化和服装 汉文化");
//		addStr("醍醐灌顶恍然大悟柳暗花明");
//		addStr("三顾频烦天下计,两朝开济老臣心");
//		addStr("你千万要保重 三千万个案例");
		addStr("真爱中国餐馆 竹间葫芦鸡 御品轩蛋糕店 芦鸡");
//		addStr("帅气度量衡山楂树林里有只乌鸦嘴一样的人 武汉绝味鸭脖");
    }



    public static void main(String[] args) {
        AnalysisCompare analysisCompare = new AnalysisCompare();
        analysisCompare.setUp();
        analysisCompare.dissectA();
    }

}
