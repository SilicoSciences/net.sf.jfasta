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

import net.sf.jfasta.FASTAElement;
import net.sf.kerner.commons.io.impl.AbstractIOIterator;

public class FASTAElementIterator extends AbstractIOIterator<FASTAElement> {
	
	protected final char[] alphabet;

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
	
	public FASTAElementIterator(BufferedReader reader, char[] alphabet) throws IOException {
		super(reader);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(File file, char[] alphabet) throws IOException {
		super(file);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(InputStream stream, char[] alphabet) throws IOException {
		super(stream);
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(Reader reader, char[] alphabet) throws IOException {
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
