/**
 * 
 */
package net.sf.jfasta.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFileReader;
import net.sf.kerner.utils.io.IOUtils;

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
	
	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testNext02() throws IOException {
		final String in = ">header [a=b c=d]" + IOUtils.NEW_LINE_STRING + "seq";

		final FASTAElementIterator it = new FASTAFileReaderImpl(
				new StringReader(in)).getIterator();

		
		
		final FASTAElement el = it.next();
		assertEquals("header", el.getHeader(false));
	}
	
	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testNext03() throws IOException {
		final String in = ">header [a=b c=d]" + IOUtils.NEW_LINE_STRING + "seq";

		final FASTAElementIterator it = new FASTAFileReaderImpl(
				new StringReader(in)).getIterator();

		
		
		final FASTAElement el = it.next();
//		System.err.println(el.getHeader(true));
		assertEquals("header [a=b c=d]", el.getHeader(true));
	}

	// START SNIPPET: example_1

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testExample01() throws IOException {

		// Read a multi FASTA file element by element.

		final File file = new File("src/test/resources/fasta02.fasta");

		final FASTAFileReader reader = new FASTAFileReaderImpl(file);

		final FASTAElementIterator it = reader.getIterator();

		while (it.hasNext()) {
			FASTAElement el = it.next();
			assertTrue(el.getHeader().contains("Homo sapiens spastin (SPAST)"));
		}
	}

	// END SNIPPET: example_1

	// START SNIPPET: example_2

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementIterator#next()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testExample02() throws IOException {

		// Read a multi FASTA file element by element. Throw an exception, if
		// FASTA sequence contains characters that are invalid for a DNA
		// sequence.

		final File file = new File("src/test/resources/fasta02.fasta");

		final FASTAFileReader reader = new FASTAFileReaderImpl(file,
				FASTAFileReaderImpl.DNA_ALPHABET_IGNORE_CASE);

		final FASTAElementIterator it = reader.getIterator();

		while (it.hasNext()) {
			FASTAElement el = it.next();
			assertTrue(el.getHeader().contains("Homo sapiens spastin (SPAST)"));
		}
	}
	// END SNIPPET: example_2
}
