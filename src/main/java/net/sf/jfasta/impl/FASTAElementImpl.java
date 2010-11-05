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

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.StringUtils;
import net.sf.kerner.commons.io.IOUtils;

public class FASTAElementImpl implements FASTAElement {

	/**
	 * This {@code  FASTAElementImpl} header string.
	 */
	protected final String header;
	
	/**
	 * This {@code FASTAElementImpl} line length.
	 */
	protected volatile int lineLength = FASTAFile.DEFAULT_LINE_LENGTH;
	
	/**
	 * This {@code FASTAElementImpl} meta infos.
	 */
	protected final Map<String, Serializable> map = new LinkedHashMap<String, Serializable>();
	
	protected final StringBuilder sequence;
	
	public FASTAElementImpl(String header, String sequence) {
		this.header = header;
		this.sequence = new StringBuilder(sequence);
	}
	
	public FASTAElementImpl(String header, char[] sequence) {
		this.header = header;
		this.sequence = new StringBuilder(String.copyValueOf(sequence));
	}
	
	public FASTAElementImpl(String header, StringBuilder sequence) {
		this.header = header;
		this.sequence = sequence;
	}
	
	public FASTAElementImpl(String header, String sequence, Map<String, Serializable> metainfo) {
		this.header = header;
		this.sequence = new StringBuilder(sequence);
		this.map.putAll(metainfo);
	}
	
	public FASTAElementImpl(String header, char[] sequence, Map<String, Serializable> metainfo) {
		this.header = header;
		this.sequence = new StringBuilder(String.copyValueOf(sequence));
		this.map.putAll(metainfo);
	}
	
	public FASTAElementImpl(String header, StringBuilder sequence, Map<String, Serializable> metainfo) {
		this.header = header;
		this.sequence = sequence;
		this.map.putAll(metainfo);
	}
	
	// Override //
	
	@Override
	public String toString() {
		return toString(true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FASTAElementImpl))
			return false;
		FASTAElementImpl other = (FASTAElementImpl) obj;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		return true;
	}

	public String toString(boolean includeMethaInfo) {
		StringBuilder sb = new StringBuilder();
		sb.append(FASTAFile.HEADER_IDENT);
		sb.append(getHeader(includeMethaInfo));
		sb.append(IOUtils.NEW_LINE_STRING);
		sb.append(StringUtils.formatStringToMultiLinesStrings(getSequence(),
				lineLength));
		return sb.toString();
	}
	
	public String getHeader() {
		return header;
	}
	
	public String getHeader(boolean includeMethaInfo) {
		if(!includeMethaInfo)
			return header;
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for(Entry<String, Serializable> e : getMethaInfo().entrySet()){
			sb.append("[");
			sb.append(e);
			sb.append("]");
			sb.append(" ");
		}
		return (header + sb.toString()).trim();
	}

	public int getLineLength() {
		return lineLength;
	}
	
	public void setLineLength(int length) {
		if(length < 1)
			throw new NumberFormatException();
		this.lineLength = length;
	}

	public void clearMethaInfo() {
		map.clear();
	}

	public Serializable getMethaInfo(String ident) {
		if(ident == null)
			throw new NullPointerException();
		return map.get(ident);
	}

	public Map<String, Serializable> getMethaInfo() {
		return new LinkedHashMap<String, Serializable>(map);
	}

	public void setMethaInfo(String ident, Serializable info) {
		if(ident == null || info == null)
			throw new NullPointerException();
		map.put(ident, info);		
	}

	public void setMethaInfo(Map<String, Serializable> map) {
		if(map == null)
			throw new NullPointerException();
		this.map.clear();
		this.map.putAll(map);
	}
	
	public int getSequenceLength() {
		return sequence.length();
	}

	public String getSequence() {
		return sequence.toString();
	}
	
	
}
