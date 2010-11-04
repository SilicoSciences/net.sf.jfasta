/**
 * 
 *
 */
package net.sf.jfasta.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import net.sf.jfasta.FASTAElement;
import net.sf.jfasta.FASTAFile;
import net.sf.kerner.commons.io.IOUtils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2010-10-04
 * 
 */
public class TestFASTAFileReaderImpl {

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
	 * {@link net.sf.jfasta.impl.FASTAFileReaderImpl#FASTAFileReaderImpl(java.io.BufferedReader)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAFileReaderImplBufferedReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAFileReaderImpl#FASTAFileReaderImpl(java.io.File)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAFileReaderImplFile() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAFileReaderImpl#FASTAFileReaderImpl(java.io.InputStream)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAFileReaderImplInputStream() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAFileReaderImpl#FASTAFileReaderImpl(java.io.Reader)}
	 * .
	 */
	@Test
	@Ignore
	public final void testFASTAFileReaderImplReader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link net.sf.jfasta.impl.FASTAFileReaderImpl#getIterator()}.
	 */
	@Test
	@Ignore
	public final void testGetIterator() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAFileReaderImpl#read()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGet() throws IOException {
		final String in = ">header" + IOUtils.NEW_LINE_STRING + "ATGC";
		final FASTAFile fasta = new FASTAFileReaderImpl(new StringReader(in))
				.read();

		assertEquals(1, fasta.size());
		final List<FASTAElement> elements = new ArrayList<FASTAElement>(fasta);
		assertEquals("header", elements.get(0).getHeader());
		assertEquals("ATGC", elements.get(0).getSequence());

	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAFileReaderImpl#read()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGet01() throws IOException {
		final String in = ">header" + IOUtils.NEW_LINE_STRING + "ATGC"
				+ IOUtils.NEW_LINE_STRING + ">header2"
				+ IOUtils.NEW_LINE_STRING + "AA";
		final FASTAFile fasta = new FASTAFileReaderImpl(new StringReader(in))
				.read();

		assertEquals(2, fasta.size());
		final List<FASTAElement> elements = new ArrayList<FASTAElement>(fasta);
		assertEquals("header", elements.get(0).getHeader());
		assertEquals("ATGC", elements.get(0).getSequence());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAFileReaderImpl#read()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGet02() throws IOException {
		final String in = ">header" + IOUtils.NEW_LINE_STRING + "ATGC"
				+ IOUtils.NEW_LINE_STRING + ">header2"
				+ IOUtils.NEW_LINE_STRING + "ATGC";

		final FASTAElementIterator it = new FASTAFileReaderImpl(new StringReader(in)).getIterator();
		
		while(it.hasNext()){
			assertEquals("ATGC", it.next().getSequence());
		}

	}
}
