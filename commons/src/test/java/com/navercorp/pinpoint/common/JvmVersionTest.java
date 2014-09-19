package com.nhn.pinpoint.common;

import static org.junit.Assert.*;
import static com.nhn.pinpoint.common.JvmVersion.*;

import org.junit.Test;

/**
 * @author hyungil.jeong
 */
public class JvmVersionTest {

	@Test
	public void testOnOrAfter() {
		// JDK 5
		assertTrue(JAVA_5.onOrAfter(JAVA_5));
		assertFalse(JAVA_5.onOrAfter(JAVA_6));
		assertFalse(JAVA_5.onOrAfter(JAVA_7));
		assertFalse(JAVA_5.onOrAfter(JAVA_8));
		assertFalse(JAVA_5.onOrAfter(UNSUPPORTED));
		// JDK 6
		assertTrue(JAVA_6.onOrAfter(JAVA_5));
		assertTrue(JAVA_6.onOrAfter(JAVA_6));
		assertFalse(JAVA_6.onOrAfter(JAVA_7));
		assertFalse(JAVA_6.onOrAfter(JAVA_8));
		assertFalse(JAVA_6.onOrAfter(UNSUPPORTED));
		// JDK 7
		assertTrue(JAVA_7.onOrAfter(JAVA_5));
		assertTrue(JAVA_7.onOrAfter(JAVA_6));
		assertTrue(JAVA_7.onOrAfter(JAVA_7));
		assertFalse(JAVA_7.onOrAfter(JAVA_8));
		assertFalse(JAVA_7.onOrAfter(UNSUPPORTED));
		// JDK 8
		assertTrue(JAVA_8.onOrAfter(JAVA_5));
		assertTrue(JAVA_8.onOrAfter(JAVA_6));
		assertTrue(JAVA_8.onOrAfter(JAVA_7));
		assertTrue(JAVA_8.onOrAfter(JAVA_8));
		assertFalse(JAVA_8.onOrAfter(UNSUPPORTED));
		// Unsupported
		assertFalse(UNSUPPORTED.onOrAfter(JAVA_5));
		assertFalse(UNSUPPORTED.onOrAfter(JAVA_6));
		assertFalse(UNSUPPORTED.onOrAfter(JAVA_7));
		assertFalse(UNSUPPORTED.onOrAfter(JAVA_8));
		assertFalse(UNSUPPORTED.onOrAfter(UNSUPPORTED));
	}
	
	@Test
	public void testGetFromDoubleVersion() {
		// JDK 5
		final JvmVersion java_5 = JvmVersion.getFromVersion(1.5);
		assertSame(java_5, JAVA_5);
		// JDK 6
		final JvmVersion java_6 = JvmVersion.getFromVersion(1.6);
		assertSame(java_6, JAVA_6);
		// JDK 7
		final JvmVersion java_7 = JvmVersion.getFromVersion(1.7);
		assertSame(java_7, JAVA_7);
		// JDK 8
		final JvmVersion java_8 = JvmVersion.getFromVersion(1.8);
		assertSame(java_8, JAVA_8);
		// Unsupported
		final JvmVersion java_unsupported = JvmVersion.getFromVersion(0.9);
		assertSame(java_unsupported, UNSUPPORTED);
	}
	
	@Test
	public void testGetFromStringVersion() {
		// JDK 5
		final JvmVersion java_5 = JvmVersion.getFromVersion("1.5");
		assertSame(java_5, JAVA_5);
		// JDK 6
		final JvmVersion java_6 = JvmVersion.getFromVersion("1.6");
		assertSame(java_6, JAVA_6);
		// JDK 7
		final JvmVersion java_7 = JvmVersion.getFromVersion("1.7");
		assertSame(java_7, JAVA_7);
		// JDK 8
		final JvmVersion java_8 = JvmVersion.getFromVersion("1.8");
		assertSame(java_8, JAVA_8);
		// Unsupported
		final JvmVersion java_unsupported = JvmVersion.getFromVersion("abc");
		assertSame(java_unsupported, UNSUPPORTED);
	}

	@Test
	public void testGetFromClassVersion() {
		// JDK 5
		final JvmVersion java_5 = JvmVersion.getFromClassVersion(49);
		assertSame(java_5, JAVA_5);
		// JDK 6
		final JvmVersion java_6 = JvmVersion.getFromClassVersion(50);
		assertSame(java_6, JAVA_6);
		// JDK 7
		final JvmVersion java_7 = JvmVersion.getFromClassVersion(51);
		assertSame(java_7, JAVA_7);
		// JDK 8
		final JvmVersion java_8 = JvmVersion.getFromClassVersion(52);
		assertSame(java_8, JAVA_8);
		// Unsupported
		final JvmVersion java_unsupported = JvmVersion.getFromClassVersion(-1);
		assertSame(java_unsupported, UNSUPPORTED);
	}
}