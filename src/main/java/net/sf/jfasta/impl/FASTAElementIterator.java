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
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.jfasta.FASTAElement;
import net.sf.kerner.utils.io.buffered.AbstractIOIterator;

public class FASTAElementIterator extends AbstractIOIterator<FASTAElement> {

	protected final char[] alphabet;

	public FASTAElementIterator(BufferedReader reader) throws IOException {
		super(reader);
		super.read();
		this.alphabet = null;
	}

	public FASTAElementIterator(File file) throws IOException {
		super(file);
		super.read();
		this.alphabet = null;
	}

	public FASTAElementIterator(InputStream stream) throws IOException {
		super(stream);
		super.read();
		this.alphabet = null;
	}

	public FASTAElementIterator(Reader reader) throws IOException {
		super(reader);
		super.read();
		this.alphabet = null;
	}

	public FASTAElementIterator(BufferedReader reader, char[] alphabet)
			throws IOException {
		super(reader);
		super.read();
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(File file, char[] alphabet) throws IOException {
		super(file);
		super.read();
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(InputStream stream, char[] alphabet)
			throws IOException {
		super(stream);
		super.read();
		this.alphabet = alphabet;
	}

	public FASTAElementIterator(Reader reader, char[] alphabet)
			throws IOException {
		super(reader);
		super.read();
		this.alphabet = alphabet;
	}

	protected FASTAElement doRead() throws IOException {
		String header = new FASTAElementHeaderReader().read(super.reader);
		if (header == null)
			return null;

		final Map<String, Serializable> map = new LinkedHashMap<String, Serializable>();
		
		if (header.contains("[")) {
			final int start = header.indexOf('[');
			final int stop = header.indexOf(']');
			final String meta = header.substring(start+1, stop);
//			System.err.println(meta);
			final String[] arr = meta.split(" ");
			for (String a : arr) {
				final String[] brr = a.split("=");
				map.put(brr[0], brr[1]);
			}
			header = header.substring(0, start-1);
		}
		
		final StringBuilder seq = getSequence();
		if (seq == null) {
			System.err.println("invalid fasta element [" + header + "]");
			return null;
		}
		seq.trimToSize();
		
		return new FASTAElementImpl(header, seq, map);
	}

	private StringBuilder getSequence() throws IOException {
		return new FASTASequenceReader(super.reader, alphabet).all();
	}
}
