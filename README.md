#Paoding分詞器，基於Lucene4.x

修正了Lucene 4.9版本中已經移除的方法(見http://goo.gl/qg4aKJ)
並重新編譯使其可以在4.9版正確載入執行。

注意！由於我編譯過的Paoding是以Java 7來編譯的，而Lucene 4.9只支援 Java 7u55以上版本，包含Java 8，若要使用於4.7以下版本則需要重新使用Java 6編譯Paoding成jar後方可使用。否則將會出現NoClassDefFoundError: org/apache/lucene/analysis/Token<init>的錯誤。

原作者： http://git.oschina.net/zhzhenqin/paoding-analysis 

#Paoding分词器基于Lucene4.x

原项目见 https://code.google.com/p/paoding/

#Paoding Analysis摘要

Paoding's Knives 中文分词具有极 高效率 和 高扩展性 。引入隐喻，采用完全的面向对象设计，构思先进。

高效率：在PIII 1G内存个人机器上，1秒 可准确分词 100万 汉字。

采用基于 不限制个数 的词典文件对文章进行有效切分，使能够将对词汇分类定义。

能够对未知的词汇进行合理解析

用心的贡献，极其能鼓励人

----------------------！

分词示例如下：


    TokenStream ts = analyzer.tokenStream("text", new StringReader(text));
    //添加工具类  注意：以下这些与之前lucene2.x版本不同的地方
    CharTermAttribute offAtt = (CharTermAttribute) ts.addAttribute(CharTermAttribute.class);
    // 循环打印出分词的结果，及分词出现的位置
    while (ts.incrementToken()) {
        System.out.print(offAtt.toString() + "\t");
    }


#编译说明

项目默认可以使用Maven直接编译.

如果使用Ant,可把依赖的lib放入 {pro_workspace}/target/dependency/ 下. 然后使用ant可以直接编译.
编译的结果存放在 {pro_workspace}/target/dist/{version}/ 下


可使用Maven的 copy-dependencies 命令直接copy依赖到{pro_workspace}/target/dependency/，然后使用ant编译


    mvn dependency：copy-dependencies


#Solr4.x使用说明

Solr 4.x以上可以直接配置Lucene的Analyzer.
配置如:


    <fieldType name="text_general" class="solr.TextField">
      <analyzer class="net.paoding.analysis.analyzer.PaodingAnalyzer" />
    </fieldType>

