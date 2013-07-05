package net.paoding.analysis.examples.gettingstarted;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ContentReader {

	public static String readText(Class clazz) throws IOException {
		InputStream in = clazz.getResourceAsStream("text.txt");
		Reader re = new InputStreamReader(in, "UTF-8");
		char[] chs = new char[1024];
		int count;
		String content = "";
		while ((count = re.read(chs)) != -1) {
			content = content + new String(chs, 0, count);
		}
		return content;
	}
}
