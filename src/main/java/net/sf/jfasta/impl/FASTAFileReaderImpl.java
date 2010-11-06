/**********************************************************************
Copyright (c) 2009-2010 Alexander Kerner. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 ***********************************************************************/

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

/**
 * 
 * Implementation for {@link net.sf.jfasta.FASTAFileReader FASTAFileReader}.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-06
 * 
 */
public class FASTAFileReaderImpl extends AbstractBufferedReader implements
		FASTAFileReader {

	/**
	 * A default alphabet for DNA.
	 * <p>
	 * { 'A', 'a', 'T', 't','G', 'g', 'C', 'c', 'N', 'n' }
	 * </p>
	 */
	public final static char[] DNA_ALPHABET_IGNORE_CASE = { 'A', 'a', 'T', 't',
			'G', 'g', 'C', 'c', 'N', 'n' };

	/**
	 * A default alphabet for DNA.
	 * <p>
	 * { 'A', 'a', 'T', 't','G', 'g', 'C', 'c'}
	 * </p>
	 */
	public final static char[] DNA_ALPHABET_IGNORE_CASE_STRICT = { 'A', 'a',
			'T', 't', 'G', 'g', 'C', 'c' };

	/**
	 * A default alphabet for DNA.
	 * <p>
	 * { 'A', 'T', 'G', 'C', 'N' }
	 * </p>
	 */
	public final static char[] DNA_ALPHABET = { 'A', 'T', 'G', 'C', 'N' };

	/**
	 * A default alphabet for DNA.
	 * <p>
	 * { 'A', 'T', 'G', 'C' }
	 * </p>
	 */
	public final static char[] DNA_ALPHABET_STRICT = { 'A', 'T', 'G', 'C' };

	/**
	 * Alphabet that is used for sequence validity checking. If null, sequence
	 * is not validated.
	 */
	protected final char[] alphabet;

	/**
	 * 
	 * Build a new {@code FASTAFileReaderImpl}. this {@code FASTAFileReaderImpl}
	 * will not perform any sequence validation.
	 * 
	 * @param reader
	 *            reader from which stream is read
	 */
	public FASTAFileReaderImpl(BufferedReader reader) {
		super(reader);
		this.alphabet = null;
	}

	/**
	 * 
	 * Build a new {@code FASTAFileReaderImpl}. this {@code FASTAFileReaderImpl}
	 * will not perform any sequence validation.
	 * 
	 * @param file
	 *            file from which stream is read
	 */
	public FASTAFileReaderImpl(File file) throws IOException {
		super(file);
		this.alphabet = null;
	}

	/**
	 * 
	 * Build a new {@code FASTAFileReaderImpl}. this {@code FASTAFileReaderImpl}
	 * will not perform any sequence validation.
	 * 
	 * @param file
	 *            stream from which is read
	 */
	public FASTAFileReaderImpl(InputStream stream) {
		super(stream);
		this.alphabet = null;
	}

	/**
	 * 
	 * Build a new {@code FASTAFileReaderImpl}. this {@code FASTAFileReaderImpl}
	 * will not perform any sequence validation.
	 * 
	 * @param reader
	 *            reader from which stream is read
	 */
	public FASTAFileReaderImpl(Reader reader) {
		super(reader);
		this.alphabet = null;
	}

	public FASTAFileReaderImpl(Reader reader, char[] alphabet) {
		super(reader);
		this.alphabet = alphabet;
	}

	public FASTAFileReaderImpl(BufferedReader reader, char[] alphabet) {
		super(reader);
		this.alphabet = alphabet;
	}

	public FASTAFileReaderImpl(File file, char[] alphabet) throws IOException {
		super(file);
		this.alphabet = alphabet;
	}

	public FASTAFileReaderImpl(InputStream stream, char[] alphabet) {
		super(stream);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator getIterator() throws IOException {
		return new FASTAElementIterator(super.reader, alphabet);
	}

	public FASTAFile read() throws IOException {
		final Collection<FASTAElement> result = new LinkedHashSet<FASTAElement>();
		FASTAElementIterator it = getIterator();
		while (it.hasNext()) {
			result.add(it.next());
			// System.err.println("result now " + result);
		}
		it.close();
		return new FASTAFileImpl(result);
	}

}
