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

import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.io.IOUtils;
import net.sf.kerner.commons.io.buffered.BufferedStringReader;

class FASTAElementHeaderReader {

	public String read(File file) throws IOException {
		return read(IOUtils.getInputStreamFromFile(file));
	}

	public String read(Reader reader) throws IOException {
		String s = new BufferedStringReader(reader).nextLine();
		if (s == null)
			return null;
		s = s.trim();
		if (s.startsWith(Character.toString(FASTAFile.HEADER_IDENT)))
			return s.substring(1);
		System.err.println("failed to get header from " + s);
		return null;
	}

	/**
	 * 
	 * 
	 * Helper method to work on "same" BufferedReader.
	 * 
	 * @param reader
	 * @return header string or {@code null} if no
	 *         {@link FASTAFile.HEADER_IDENT} could be found
	 * @throws IOException
	 *             if anything goes wrong
	 */
	public String read(BufferedReader reader) throws IOException {
		String s = reader.readLine();
		if (s == null)
			return null;
		s = s.trim();
		if (s.startsWith(Character.toString(FASTAFile.HEADER_IDENT)))
			return s.substring(1);
		System.err.println("failed to get header from " + s);
		return null;
	}

	public String read(InputStream stream) throws IOException {
		return read(IOUtils.inputStreamToReader(stream));
	}

}
