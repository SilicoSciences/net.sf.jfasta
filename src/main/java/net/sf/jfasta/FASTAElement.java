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

package net.sf.jfasta;

/**
 * A {@code FASTAElement} represents one entry in a (multi) fasta file.
 * 
 * <p>
 * Example:
 * 
 * <pre>
 * >gi|40806168|ref|NM_014946.3| Homo sapiens spastin (SPAST), transcript variant 1, mRNA
 * GGCCCGAGCCACCGACTGCAGGAGGAGAAGGGGTTGTGCTCCTGGCCGAGGAAGGAGAAAGGGGCGGGGC
 * CGGC[...]
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-04
 * @see net.sf.jfasta.FASTAFile FASTAFile
 * 
 */
public interface FASTAElement {

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s header string. Meaning string
	 * starting right after {@link net.sf.jfasta.FASTAFile#HEADER_IDENT
	 * HEADER_IDENT} and continuing until first subsequent
	 * {@link net.sf.kerner.utils.io.IOUtils#NEW_LINE_STRING NEW_LINE_STRING}
	 * 
	 * @return this {@code FASTAElement}'s header string
	 */
	String getHeader();

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s header string. Meaning string
	 * starting right after {@link  net.sf.jfasta.FASTAFile#HEADER_IDENT
	 * HEADER_IDENT} and continuing until first subsequent
	 * {@link net.sf.kerner.utils.io.IOUtils#NEW_LINE_STRING NEW_LINE_STRING}
	 * 
	 * @return this {@code FASTAElement}'s header string, including meta
	 *         information
	 * 
	 */
	String getHeader(boolean includeMethaInfo);

	/**
	 * 
	 * Set this {@code FASTAElement}'s default line length. When invoking
	 * toString() or {@link #toString(boolean)} after {@code length}
	 * characters written to one line, a
	 * {@link net.sf.kerner.utils.io.IOUtils#NEW_LINE_STRING NEW_LINE_STRING}
	 * will be appended.
	 * 
	 * @param length
	 *            the new default line length
	 */
	void setLineLength(int length);

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s default line length.
	 * 
	 * @return this {@code FASTAElement}'s default line length
	 */
	int getLineLength();

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s sequence length.
	 * 
	 * @return this {@code FASTAElement}'s sequence length
	 */
	int getSequenceLength();

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s string representation. Include meta
	 * informations in header line.
	 * 
	 * @param includeMethaInfo
	 *            include meta informations in header line if true, omit them if
	 *            false
	 * @return this {@code FASTAElement}'s string representation including meta
	 *         informations in header line
	 */
	String toString(boolean includeMethaInfo);

	/**
	 * Get this {@code FASTAElement}s sequence.
	 * 
	 * @return {@code String} view of this {@code FASTAElement}s sequence
	 */
	String getSequence();

}
