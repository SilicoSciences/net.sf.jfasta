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
 * @autor <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-04
 * @see FASTAFile
 * 
 */
public interface FASTAElement {

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s header string. Meaning string
	 * starting right after {@link FASTAFile#HEADER_IDENT} and continuing until
	 * first subsequent {@link net.sf.kerner.commons.io.IOUtils#NEW_LINE_STRING}
	 * 
	 * @return this {@code FASTAElement}'s header string
	 */
	String getHeader();

	/**
	 * 
	 * Retrieve this {@code FASTAElement}'s header string. Meaning string
	 * starting right after {@link FASTAFile#HEADER_IDENT} and continuing until
	 * first subsequent {@link net.sf.kerner.commons.io.IOUtils#NEW_LINE_STRING}
	 * 
	 * @return this {@code FASTAElement}'s header string, including meta
	 *         information
	 * 
	 */
	String getHeader(boolean includeMethaInfo);

	/**
	 * 
	 * Set this {@code FASTAElement}'s default line length. When invoking
	 * {@link #toString()} or {@link #toString(boolean)} after {@code length}
	 * characters written to one line, a
	 * {@link net.sf.kerner.commons.io.IOUtils#NEW_LINE_STRING} will be
	 * appended.
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

	String getSequence();

}
