/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 * Tests ArrayUtils insert methods.
 */
public class ArrayUtilsInsertTest {

    @Test
    public void testInsertBooleans() throws Exception {
        final boolean[] array = { true, false, true };
        final boolean[] values = { false, true, false };
        final boolean[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new boolean[0], ArrayUtils.insert(0, new boolean[0], null));
        assertNull(ArrayUtils.insert(42, (boolean[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new boolean[] { false, true, false, true }, ArrayUtils.insert(0, array, false));
        assertArrayEquals(new boolean[] { true, false, false, true }, ArrayUtils.insert(1, array, false));
        assertArrayEquals(new boolean[] { true, false, true, false }, ArrayUtils.insert(array.length, array, false));
        assertArrayEquals(new boolean[] { false, true, false, true, false, true }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new boolean[] { true, false, true, false, false, true }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new boolean[] { true, false, true, false, true, false }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertBytes() throws Exception {
        final byte[] array = { 1, 2, 3 };
        final byte[] values = { 4, 5, 6 };
        final byte[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new byte[0], ArrayUtils.insert(0, new byte[0], null));
        assertNull(ArrayUtils.insert(42, (byte[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new byte[] { 0, 1, 2, 3 }, ArrayUtils.insert(0, array, (byte) 0));
        assertArrayEquals(new byte[] { 1, 0, 2, 3 }, ArrayUtils.insert(1, array, (byte) 0));
        assertArrayEquals(new byte[] { 1, 2, 3, 0 }, ArrayUtils.insert(array.length, array, (byte) 0));
        assertArrayEquals(new byte[] { 4, 5, 6, 1, 2, 3 }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new byte[] { 1, 4, 5, 6, 2, 3 }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 6 }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertChars() throws Exception {
        final char[] array = { 'a', 'b', 'c' };
        final char[] values = { 'd', 'e', 'f' };
        final char[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new char[0], ArrayUtils.insert(0, new char[0], null));
        assertNull(ArrayUtils.insert(42, (char[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new char[] { 'z', 'a', 'b', 'c' }, ArrayUtils.insert(0, array, 'z'));
        assertArrayEquals(new char[] { 'a', 'z', 'b', 'c' }, ArrayUtils.insert(1, array, 'z'));
        assertArrayEquals(new char[] { 'a', 'b', 'c', 'z' }, ArrayUtils.insert(array.length, array, 'z'));
        assertArrayEquals(new char[] { 'd', 'e', 'f', 'a', 'b', 'c' }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new char[] { 'a', 'd', 'e', 'f', 'b', 'c' }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new char[] { 'a', 'b', 'c', 'd', 'e', 'f' }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertDoubles() throws Exception {
        final double[] array = { 1, 2, 3 };
        final double[] values = { 4, 5, 6 };
        final double delta = 0.000001;
        final double[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(result, delta, array);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(ArrayUtils.insert(0, new double[0], null), delta, new double[0]);
        assertNull(ArrayUtils.insert(42, (double[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(ArrayUtils.insert(0, array, 0), delta, new double[] { 0, 1, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(1, array, 0), delta, new double[] { 1, 0, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(array.length, array, 0), delta, new double[] { 1, 2, 3, 0 });
        assertArrayEquals(ArrayUtils.insert(0, array, values), delta, new double[] { 4, 5, 6, 1, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(1, array, values), delta, new double[] { 1, 4, 5, 6, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(array.length, array, values), delta, new double[] { 1, 2, 3, 4, 5, 6 });
    }

    @Test
    public void testInsertFloats() throws Exception {
        final float[] array = { 1, 2, 3 };
        final float[] values = { 4, 5, 6 };
        final float delta = 0.000001f;
        final float[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(result, delta, array);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(ArrayUtils.insert(0, new float[0], null), delta, new float[0]);
        assertNull(ArrayUtils.insert(42, (float[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(ArrayUtils.insert(0, array, 0), delta, new float[] { 0, 1, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(1, array, 0), delta, new float[] { 1, 0, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(array.length, array, 0), delta, new float[] { 1, 2, 3, 0 });
        assertArrayEquals(ArrayUtils.insert(0, array, values), delta, new float[] { 4, 5, 6, 1, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(1, array, values), delta, new float[] { 1, 4, 5, 6, 2, 3 });
        assertArrayEquals(ArrayUtils.insert(array.length, array, values), delta, new float[] { 1, 2, 3, 4, 5, 6 });
    }

    @Test
    public void testInsertInts() throws Exception {
        final int[] array = { 1, 2, 3 };
        final int[] values = { 4, 5, 6 };
        final int[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new int[0], ArrayUtils.insert(0, new int[0], null));
        assertNull(ArrayUtils.insert(42, (int[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new int[] { 0, 1, 2, 3 }, ArrayUtils.insert(0, array, 0));
        assertArrayEquals(new int[] { 1, 0, 2, 3 }, ArrayUtils.insert(1, array, 0));
        assertArrayEquals(new int[] { 1, 2, 3, 0 }, ArrayUtils.insert(array.length, array, 0));
        assertArrayEquals(new int[] { 4, 5, 6, 1, 2, 3 }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new int[] { 1, 4, 5, 6, 2, 3 }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertLongs() throws Exception {
        final long[] array = { 1, 2, 3 };
        final long[] values = { 4, 5, 6 };
        final long[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new long[0], ArrayUtils.insert(0, new long[0], null));
        assertNull(ArrayUtils.insert(42, (long[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new long[] { 0, 1, 2, 3 }, ArrayUtils.insert(0, array, 0));
        assertArrayEquals(new long[] { 1, 0, 2, 3 }, ArrayUtils.insert(1, array, 0));
        assertArrayEquals(new long[] { 1, 2, 3, 0 }, ArrayUtils.insert(array.length, array, 0));
        assertArrayEquals(new long[] { 4, 5, 6, 1, 2, 3 }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new long[] { 1, 4, 5, 6, 2, 3 }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new long[] { 1, 2, 3, 4, 5, 6 }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertShorts() throws Exception {
        final short[] array = { 1, 2, 3 };
        final short[] values = { 4, 5, 6 };
        final short[] result = ArrayUtils.insert(42, array, null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new short[0], ArrayUtils.insert(0, new short[0], null));
        assertNull(ArrayUtils.insert(42, (short[]) null, null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new short[] { 0, 1, 2, 3 }, ArrayUtils.insert(0, array, (short) 0));
        assertArrayEquals(new short[] { 1, 0, 2, 3 }, ArrayUtils.insert(1, array, (short) 0));
        assertArrayEquals(new short[] { 1, 2, 3, 0 }, ArrayUtils.insert(array.length, array, (short) 0));
        assertArrayEquals(new short[] { 4, 5, 6, 1, 2, 3 }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new short[] { 1, 4, 5, 6, 2, 3 }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new short[] { 1, 2, 3, 4, 5, 6 }, ArrayUtils.insert(array.length, array, values));
    }

    @Test
    public void testInsertGenericArray() throws Exception {
        final String[] array = { "a", "b", "c" };
        final String[] values = { "d", "e", "f" };
        final String[] result = ArrayUtils.insert(42, array, (String[]) null);
        assertArrayEquals(array, result);
        assertFalse(array == result);
        assertNull(ArrayUtils.insert(42, null, array));
        assertArrayEquals(new String[0], ArrayUtils.insert(0, new String[0], (String[]) null));
        assertNull(ArrayUtils.insert(42, null, (String[]) null));
        try {
            ArrayUtils.insert(-1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        try {
            ArrayUtils.insert(array.length + 1, array, array);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {
        // expected
        }
        assertArrayEquals(new String[] { "z", "a", "b", "c" }, ArrayUtils.insert(0, array, "z"));
        assertArrayEquals(new String[] { "a", "z", "b", "c" }, ArrayUtils.insert(1, array, "z"));
        assertArrayEquals(new String[] { "a", "b", "c", "z" }, ArrayUtils.insert(array.length, array, "z"));
        assertArrayEquals(new String[] { "d", "e", "f", "a", "b", "c" }, ArrayUtils.insert(0, array, values));
        assertArrayEquals(new String[] { "a", "d", "e", "f", "b", "c" }, ArrayUtils.insert(1, array, values));
        assertArrayEquals(new String[] { "a", "b", "c", "d", "e", "f" }, ArrayUtils.insert(array.length, array, values));
    }
}
