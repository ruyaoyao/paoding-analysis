/**
 * 
 */
package net.paoding.analysis.ext;

import java.util.Collection;

import net.paoding.analysis.dictionary.Word;

/**
 * @author ZhenQin
 *
 */
public abstract interface PaodingAnalyzerListener {

	public abstract void readDic(String dicPath);
	
	
	public abstract void readDicFinished(String dicPath, Collection<Word> conllec);
	
	
	public abstract void refreshDic(String dicPath, Collection<Word> conllec);
	
	public abstract void readCompileDic(String dicPath);
	
	public abstract void readCompileDicFinished(String dicPath, Collection<Word> conllec);

}
