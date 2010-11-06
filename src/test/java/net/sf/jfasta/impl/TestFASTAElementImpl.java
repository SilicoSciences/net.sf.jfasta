/**
 * 
 */
package net.sf.jfasta.impl;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

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
public class TestFASTAElementImpl {
	
	private FASTAElementImpl el;

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
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#hashCode()}.
	 */
	@Ignore
	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testFASTAElementImplStringString() {
		el = new FASTAElementImpl("header", "seq");
		assertEquals("header", el.getHeader());
		assertEquals("seq", el.getSequence());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, char[])}.
	 */
	@Test
	public final void testFASTAElementImplStringCharArray() {
		el = new FASTAElementImpl("header", new char[]{'s','e','q'});
		assertEquals("header", el.getHeader());
		assertEquals("seq", el.getSequence());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, java.lang.StringBuilder)}.
	 */
	@Test
	public final void testFASTAElementImplStringStringBuilder() {
		el = new FASTAElementImpl("header", new StringBuilder("seq"));
		assertEquals("header", el.getHeader());
		assertEquals("seq", el.getSequence());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, java.lang.String, java.util.Map)}.
	 */
	@Test
	public final void testFASTAElementImplStringStringMapOfStringSerializable() {
		final Map<String,Serializable> meta = new LinkedHashMap<String, Serializable>();
		meta.put("meta", "value");
		el = new FASTAElementImpl("header", "seq", meta);
		assertEquals("header [meta=value]" , el.getHeader(true));
		assertEquals("seq", el.getSequence());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, char[], java.util.Map)}.
	 */
	@Test
	@Ignore
	public final void testFASTAElementImplStringCharArrayMapOfStringSerializable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#FASTAElementImpl(java.lang.String, java.lang.StringBuilder, java.util.Map)}.
	 */
	@Test
	@Ignore
	public final void testFASTAElementImplStringStringBuilderMapOfStringSerializable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#toString()}.
	 */
	@Test
	public final void testToString() {
		final Map<String,Serializable> meta = new LinkedHashMap<String, Serializable>();
		meta.put("meta", "value");
		el = new FASTAElementImpl("header", "seq", meta);
		assertEquals(">header [meta=value]" + IOUtils.NEW_LINE_STRING + el.getSequence(), el.toString());
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		el = new FASTAElementImpl("header", "seq");
		FASTAElementImpl el2 = new FASTAElementImpl("header", "seq");
		assertEquals(el, el2);
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#toString(boolean)}.
	 */
	@Test
	public final void testToStringBoolean() {
		final Map<String,Serializable> meta = new LinkedHashMap<String, Serializable>();
		meta.put("meta", "value");
		el = new FASTAElementImpl("header", "seq", meta);
		assertEquals(">header" + IOUtils.NEW_LINE_STRING + el.getSequence(), el.toString(false));
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getHeader()}.
	 */
	@Test
	@Ignore
	public final void testGetHeader() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getHeader(boolean)}.
	 */
	@Test
	@Ignore
	public final void testGetHeaderBoolean() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getLineLength()}.
	 */
	@Test
	public final void testGetLineLength() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#setLineLength(int)}.
	 */
	@Test
	public final void testSetLineLength() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#clearMethaInfo()}.
	 */
	@Test
	public final void testClearMethaInfo() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getMethaInfo(java.lang.String)}.
	 */
	@Test
	public final void testGetMethaInfoString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getMethaInfo()}.
	 */
	@Test
	public final void testGetMethaInfo() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#setMethaInfo(java.lang.String, java.io.Serializable)}.
	 */
	@Test
	public final void testSetMethaInfoStringSerializable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#setMethaInfo(java.util.Map)}.
	 */
	@Test
	public final void testSetMethaInfoMapOfStringSerializable() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getSequenceLength()}.
	 */
	@Test
	public final void testGetSequenceLength() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link net.sf.jfasta.impl.FASTAElementImpl#getSequence()}.
	 */
	@Test
	@Ignore
	public final void testGetSequence() {
		fail("Not yet implemented"); // TODO
	}

}
