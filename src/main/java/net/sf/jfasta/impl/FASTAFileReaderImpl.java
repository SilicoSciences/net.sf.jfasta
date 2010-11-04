package net.sf.jfasta.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedHashSet;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.jfasta.FASTAFileReader;
import net.sf.kerner.commons.io.buffered.AbstractBufferedReader;

public class FASTAFileReaderImpl extends AbstractBufferedReader implements FASTAFileReader{

	public FASTAFileReaderImpl(BufferedReader reader) {
		super(reader);
	}

	public FASTAFileReaderImpl(File file) throws IOException {
		super(file);
	}

	public FASTAFileReaderImpl(InputStream stream) {
		super(stream);
	}

	public FASTAFileReaderImpl(Reader reader) {
		super(reader);
	}

	public FASTAElementIterator getIterator() throws IOException {
		return new FASTAElementIterator(super.reader);
	}

	public FASTAFile read() throws IOException {
		final Collection<FASTAElement> result = new LinkedHashSet<FASTAElement>();
		FASTAElementIterator it = getIterator();
		while(it.hasNext()){
			result.add(it.next());
//			System.err.println("result now " + result);
		}
		it.close();
		return new FASTAFileImpl(result);
	}

		
}
