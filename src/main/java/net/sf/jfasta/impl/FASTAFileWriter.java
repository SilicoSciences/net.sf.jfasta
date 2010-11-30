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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.kerner.utils.io.ObjectWriter;
import net.sf.kerner.utils.io.buffered.AbstractBufferedWriter;

/**
 * 
 * A {@code FASTAFileWriter} writes {@link net.sf.jfasta.FASTAElement
 * FASTAElement}s and {@link net.sf.jfasta.FASTAFile FASTAFile}s to
 * <ul>
 * <li>
 * a {@link java.io.File}</li>
 * <li>
 * a {@link java.io.Writer}</li>
 * <li>
 * an {@link java.io.OutputStream}</li>
 * </ul>
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
 * <p>
 * {@code FASTAFileWriter} is thread save.
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-30
 * 
 */
public class FASTAFileWriter extends AbstractBufferedWriter implements
		ObjectWriter<FASTAElement> {

	/**
	 * 
	 * Create a {@code FASTAFileWriter} that writes to a file.
	 * 
	 * @param file
	 *            file to write to
	 * @throws IOException
	 *             if file is not accessible
	 */
	public FASTAFileWriter(File file) throws IOException {
		super(file);
	}

	/**
	 * 
	 * Create a {@code FASTAFileWriter} that writes to a stream.
	 * 
	 * @param stream
	 *            output stream to write to
	 */
	public FASTAFileWriter(OutputStream stream) {
		super(stream);
	}

	/**
	 * 
	 * Create a {@code FASTAFileWriter} that writes to a writer.
	 * 
	 * @param writer
	 *            writer to write to
	 */
	public FASTAFileWriter(Writer writer) {
		super(writer);
	}

	/**
	 * 
	 * Write a {@link net.sf.jfasta.FASTAFile FASTAFile} at once.
	 * <p>
	 * <b> Note:</b> For big FASTA files, use {@link #write(FASTAElement)}
	 * instead and write FASTA file element by element.
	 * </p>
	 * 
	 * @param e
	 *            FASTA file to write
	 * @throws IOException
	 *             if writing fails
	 */
	public synchronized void write(FASTAFile e) throws IOException {
		super.writer.write(e.toString());
	}

	/**
	 * Write a {@link net.sf.jfasta.FASTAElement FASTAElement}.
	 * <p>
	 * <b>Note:</b> For big FASTA elements, prepare for equivalent memory usage.
	 * </p>
	 * 
	 */
	public synchronized void write(FASTAElement e) throws IOException {
		super.writer.write(e.toString());
	}
}
