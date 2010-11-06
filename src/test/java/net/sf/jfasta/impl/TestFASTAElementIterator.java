/**
 * 
 */
package net.sf.jfasta.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import net.sf.kerner.commons.io.IOUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-11-06
 * 
 */
public class TestFASTAElementIterator {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.BufferedReader)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorBufferedReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.File)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorFile() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.InputStream)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorInputStream() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.Reader)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.BufferedReader, char[])}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorBufferedReaderCharArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.File, char[])}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorFileCharArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.InputStream, char[])}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorInputStreamCharArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAElementIterator#FASTAElementIterator(java.io.Reader, char[])}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAElementIteratorReaderCharArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#doRead()}.
	 */
	@Test
	@Ignore
	public final void testDoRead() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next(int)}
	 * .
	 */
	@Test
	@Ignore
	public final void testNextInt() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testNext() throws IOException {
		final String in = ">header" + IOUtils.NEW_LINE_STRING + "ATGC"
				+ IOUtils.NEW_LINE_STRING + ">header2"
				+ IOUtils.NEW_LINE_STRING + "ATGC";

		final FASTAElementIterator it = new FASTAFileReaderImpl(
				new StringReader(in)).getIterator();

		while (it.hasNext()) {
			assertEquals("ATGC", it.next().getSequence());
		}
	}

}