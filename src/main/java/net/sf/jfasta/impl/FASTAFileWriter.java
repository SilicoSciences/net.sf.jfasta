package net.sf.jfasta.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.io.ObjectWriter;
import net.sf.kerner.commons.io.buffered.AbstractBufferedWriter;

public class FASTAFileWriter extends AbstractBufferedWriter implements ObjectWriter<FASTAFile> {

	public FASTAFileWriter(File file) throws IOException {
		super(file);
	}

	public FASTAFileWriter(OutputStream stream) {
		super(stream);
	}

	public FASTAFileWriter(Writer writer) {
		super(writer);
	}

	public void write(FASTAFile e) throws IOException {
		super.writer.write(e.toString());
	}
	
	public void write(FASTAElement e) throws IOException {
		super.writer.write(e.toString());
	}
}
