package net.sf.jfasta;

import java.io.IOException;

import net.sf.kerner.commons.io.buffered.IOIterable;

public interface FASTAFileReader extends IOIterable<FASTAElement> {
	
	void close();
	
	FASTAFile read() throws IOException;

}
