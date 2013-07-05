#paoding-analysis

##Paoding分词器基于Lucene4.x

原项目见 https://code.google.com/p/paoding/

#Paoding Analysis摘要

Paoding's Knives 中文分词具有极 高效率 和 高扩展性 。引入隐喻，采用完全的面向对象设计，构思先进。

高效率：在PIII 1G内存个人机器上，1秒 可准确分词 100万 汉字。

采用基于 不限制个数 的词典文件对文章进行有效切分，使能够将对词汇分类定义。

能够对未知的词汇进行合理解析

用心的贡献，极其能鼓励人

----------------------！

分词示例如下：


'''
TokenStream ts = analyzer.tokenStream("text", new StringReader(textWordFreq.getTxtText()));
//添加工具类  注意：以下这些与之前lucene2.x版本不同的地方
CharTermAttribute offAtt = (CharTermAttribute) ts.addAttribute(CharTermAttribute.class);
// 循环打印出分词的结果，及分词出现的位置
while (ts.incrementToken()) {
    System.out.print(offAtt.toString() + "\t");
}
'''