package net.sf.jfasta.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import de.bioutils.symbol.Alphabet;

import net.sf.jfasta.FASTAElement;
import net.sf.kerner.commons.io.impl.AbstractIOIterator;

public class FASTAElementIterator extends AbstractIOIterator<FASTAElement> {
	
	protected final Alphabet alphabet;

	public FASTAElementIterator(BufferedReader reader) throws IOException {
		super(reader);
		this.alphabet = null;
	}

	public FASTAElementIterator(File file) throws IOException {
		super(file);
		this.alphabet = null;
	}

	public FASTAElementIterator(InputStream stream) throws IOException {
		super(stream);
		this.alphabet = null;
	}

	public FASTAElementIterator(Reader reader) throws IOException {
		super(reader);
		this.alphabet = null;
	}
	
	public FASTAElementIterator(BufferedReader reader, Alphabet alphabet) throws IOException {
		super(reader);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(File file, Alphabet alphabet) throws IOException {
		super(file);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(InputStream stream, Alphabet alphabet) throws IOException {
		super(stream);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(Reader reader, Alphabet alphabet) throws IOException {
		super(reader);
		this.alphabet = alphabet;
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
		return new FASTASequenceReader(super.reader, alphabet).all();
	}

	public FASTAElement next(int bufferSize) throws IOException {
		// TODO ignoring bufferSize
		return next();
	}

}
