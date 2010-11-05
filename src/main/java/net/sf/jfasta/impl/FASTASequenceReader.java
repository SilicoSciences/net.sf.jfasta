package net.sf.jfasta.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import de.bioutils.symbol.Alphabet;
import de.bioutils.symbol.IllegalSymbolException;
import de.bioutils.symbol.Symbol;

import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.io.IOUtils;
import net.sf.kerner.commons.io.buffered.AbstractBufferedReader;
import net.sf.kerner.commons.io.buffered.BufferedStringReader;

class FASTASequenceReader extends AbstractBufferedReader {

	protected final BufferedStringReader reader2 = new BufferedStringReader(
			super.reader);

	protected final Alphabet alphabet;
	
	public FASTASequenceReader(BufferedReader reader) throws IOException {
		super(reader);
		this.alphabet = null;
	}

	public FASTASequenceReader(File file) throws IOException {
		super(file);
		this.alphabet = null;
	}

	public FASTASequenceReader(InputStream stream) throws IOException {
		super(stream);
		this.alphabet = null;
	}

	public FASTASequenceReader(Reader reader) throws IOException {
		super(reader);
		this.alphabet = null;
	}
	
	public FASTASequenceReader(BufferedReader reader, Alphabet alphabet) throws IOException {
		super(reader);
		this.alphabet = alphabet;
	}

	public FASTASequenceReader(File file, Alphabet alphabet) throws IOException {
		super(file);
		this.alphabet = alphabet;
	}

	public FASTASequenceReader(InputStream stream, Alphabet alphabet) throws IOException {
		super(stream);
		this.alphabet = alphabet;
	}

	public FASTASequenceReader(Reader reader, Alphabet alphabet) throws IOException {
		super(reader);
		this.alphabet = alphabet;
	}

	public synchronized StringBuilder nextChars() throws IOException {
		return nextChars(IOUtils.DEFAULT_BUFFER);
	}

	/**
	 * A FASTA sequence must not start with {@link FASTAFile#HEADER_IDENT};
	 * {@code null} will be returned in this case.
	 */
	public synchronized StringBuilder nextChars(int buffer) throws IOException {
		final StringBuilder result = new StringBuilder(buffer);
		for (int i = 0; i < buffer; i++) {

			super.reader.mark(1);
			final int ci = reader2.nextChar();

			if (ci < 0) {
				// nothing left to read
				break;
			}
			final char c = (char) ci;

			// trim sequence
			if (Character.isWhitespace(c))
				continue;
			
			if(alphabet != null){
				// check validity
				for(Symbol s : alphabet){
					if(s.toChar() == c || s.toCharLowerCase() == c){
						// matches
					}
					else {
						throw new IllegalSymbolException("Illegal character [" + c + "]");
					}
				}
			}

			// seq end reached
			if (c == FASTAFile.HEADER_IDENT) {
				super.reader.reset();
				break;
			}

			else
				result.append(c);
		}
		if (result.length() < 1)
			return null;
		return result;
	}

	/**
	 * Read in sequence until sequence is complete, using internal buffer size
	 * of {@code buffersize}.
	 */
	public StringBuilder all(int bufferSize) throws IOException {
		final StringBuilder result = new StringBuilder(bufferSize);
		StringBuilder buffer = null;
		while ((buffer = nextChars(bufferSize)) != null)
			result.append(buffer);
		if (result.length() == 0)
			return null;
		return result;
	}

	/**
	 * Read in sequence until sequence is complete, using default buffer size.
	 */
	public StringBuilder all() throws IOException {
		return all(IOUtils.DEFAULT_BUFFER);
	}

}
