package net.sf.jfasta.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import net.sf.jfasta.FASTAElement;
import net.sf.kerner.commons.io.impl.AbstractIOIterator;

public class FASTAElementIterator extends AbstractIOIterator<FASTAElement> {

	public FASTAElementIterator(BufferedReader reader) throws IOException {
		super(reader);
	}

	public FASTAElementIterator(File file) throws IOException {
		super(file);
	}

	public FASTAElementIterator(InputStream stream) throws IOException {
		super(stream);
	}

	public FASTAElementIterator(Reader reader) throws IOException {
		super(reader);
	}
	
	protected FASTAElement doRead() throws IOException {
		final String header = new FASTAElementHeaderReader().read(super.reader);
		if (header == null)
			return null;
		final StringBuilder seq = getSequence();
		if (seq == null) {
			System.err.println("invalid fasta element [" + header + "]");
			return null;
		}
		return new FASTAElementImpl(header, seq);
	}

	private StringBuilder getSequence() throws IOException {
		return new FASTASequenceDefaultReader(super.reader).all();
	}

	public FASTAElement next(int bufferSize) throws IOException {
		// TODO ignoring bufferSize
		return next();
	}

}
