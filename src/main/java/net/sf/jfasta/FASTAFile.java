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

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * A {@code FASTAFile} is a collection of {@link FASTAElement}s, that includes
 * some information for serialization and string representation.
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-10-16
 * @see FASTAElement
 * 
 */
public interface FASTAFile extends Serializable, Cloneable, Set<FASTAElement> {
	
	/**
	 * First character of header line that will identify {@code FASTAElement}'s
	 * header line.
	 */
	public final static char HEADER_IDENT = '>';

	/**
	 * Default number of characters to write to one line. After writing
	 * {@link #DEFAULT_LINE_LENGTH} characters, a
	 * {@link net.sf.kerner.commons.io.IOUtils#NEW_LINE_STRING} will be
	 * appended.
	 */
	public static final int DEFAULT_LINE_LENGTH = 80;

	/**
	 * 
	 * 
	 * Retrieve this {@code FASTAFile}'s line length.
	 * 
	 * @return this {@code FASTAFile}'s line length
	 */
	int getLineLength();

	/**
	 * 
	 * 
	 * Set this {@code FASTAFile}'s line length.
	 * 
	 * @param len
	 *            line length to use
	 */
	void setLineLength(int len);

	FASTAElement getElementByHeader(String header);

	FASTAElement getLargestElement();

	boolean hasElementByHeader(String header);

	String toString(boolean includeMethaInfo);

}
