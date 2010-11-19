package net.sf.jfasta;

import net.sf.kerner.utils.io.IOUtils;

public class Utils {
	
	private Utils(){
		
	}
	
	public static String formatStringToMultiLinesStrings(String string,
			int length) {
		string = string.replace(IOUtils.NEW_LINE_STRING, " ");
		StringBuilder sb = new StringBuilder();
		while (string.length() > length) {
			int endIndex = length;
			sb.append(string.subSequence(0, endIndex).toString());
			sb.append(IOUtils.NEW_LINE_STRING);
			string = string.substring(endIndex);
		}
		if (string != null && !string.equals(IOUtils.NEW_LINE_STRING))
			sb.append(string);
		return sb.toString();
	}

}
