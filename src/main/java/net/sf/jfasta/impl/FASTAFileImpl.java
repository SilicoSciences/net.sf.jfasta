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

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.Utils;
import net.sf.kerner.commons.io.IOUtils;

public class FASTAFileImpl implements FASTAFile {
	
	private static final long serialVersionUID = 3363308756893284011L;

	volatile int lineLength = FASTAFile.DEFAULT_LINE_LENGTH;
	
	protected final Collection<FASTAElement> elements = new LinkedHashSet<FASTAElement>();
	
	public FASTAFileImpl() {
		
	}
	
	public FASTAFileImpl(Collection<? extends FASTAElement> elements) {
		this.elements.addAll(elements);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((elements == null) ? 0 : elements.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FASTAFileImpl))
			return false;
		FASTAFileImpl other = (FASTAFileImpl) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		Iterator<?> it = elements.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext()) {
				sb.append(IOUtils.NEW_LINE_STRING);
			}
		}
		return sb.toString();
	}
	
	public FASTAElement getElementByHeader(String header) {
		Utils.checkForNull(header);
		for (FASTAElement e : elements) {
			if (e.getHeader().equals(header)) {
				return e;
			}
		}
		throw new NoSuchElementException("no FASTA element with header \""
				+ header + "\"");
	}

	public FASTAElement getLargestElement() {
		if (elements.isEmpty())
			return null;
		FASTAElement result = elements.iterator().next();
		for (FASTAElement e : elements) {
			if (e.getSequenceLength() > result.getSequenceLength()) {
				result = e;
			}
		}
		return result;
	}

	public boolean hasElementByHeader(String header) {
		for (FASTAElement e : elements) {
			if (e.getHeader().equals(header)) {
				return true;
			}
		}
		return false;
	}

	public String toString(boolean includeMethaInfo) {
		StringBuilder sb = new StringBuilder();
		final Iterator<FASTAElement> it = elements.iterator();
		while (it.hasNext()) {
			sb.append(it.next().toString(includeMethaInfo));
			if (it.hasNext())
				sb.append(IOUtils.NEW_LINE_STRING);
		}
		return sb.toString();
	}

	public int getLineLength() {
		return lineLength;
	}

	public void setLineLength(int len) {
		this.lineLength = len;
	}

	/**
	 * 
	 */
	public boolean add(FASTAElement e) {
		synchronized (elements) {
			return elements.add(e);
		}
	}

	/**
	 * 
	 */
	public boolean addAll(Collection<? extends FASTAElement> c) {
		synchronized (elements) {
			return elements.addAll(c);
		}
	}

	/**
	 * 
	 */
	public void clear() {
		synchronized (elements) {
			elements.clear();
		}
	}

	/**
	 * 
	 */
	public boolean contains(Object o) {
		synchronized (elements) {
			return elements.contains(o);
		}
	}

	/**
	 * 
	 */
	public boolean containsAll(Collection<?> c) {
		synchronized (elements) {
			return elements.containsAll(c);
		}
	}

	/**
	 * 
	 */
	public boolean isEmpty() {
		synchronized (elements) {
			return elements.isEmpty();
		}
	}

	/**
	 * 
	 */
	public boolean remove(Object o) {
		synchronized (elements) {
			return elements.remove(o);
		}
	}

	/**
	 * 
	 */
	public boolean removeAll(Collection<?> c) {
		synchronized (elements) {
			return elements.removeAll(c);
		}
	}

	/**
	 * 
	 */
	public boolean retainAll(Collection<?> c) {
		synchronized (elements) {
			return elements.retainAll(c);
		}
	}

	/**
	 * 
	 */
	public int size() {
		synchronized (elements) {
			return elements.size();
		}
	}

	/**
	 * 
	 */
	public Object[] toArray() {
		synchronized (elements) {
			return elements.toArray();
		}
	}

	/**
	 * 
	 */
	public <T> T[] toArray(T[] a) {
		synchronized (elements) {
			return elements.toArray(a);
		}
	}

	public Iterator<FASTAElement> iterator() {
		return elements.iterator();
	}
}
