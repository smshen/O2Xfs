/*
 * Copyright (c) 2014, Andreas Fagschlunger. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package at.o2xfs.win32;

/**
 * A 16-bit unsigned integer (range: 0 through 65535 decimal).
 * 
 * {@link http://msdn.microsoft.com/en-us/library/aa383751(v=vs.85).aspx}
 * 
 * @author Andreas Fagschlunger
 */
public class USHORT extends NumberType {

	public static final int MIN_VALUE = 0;

	public static final int MAX_VALUE = 65535;

	public USHORT() {
		super(2);
	}

	public USHORT(final int value) {
		this();
		allocate();
		put(value);
	}

	public void put(USHORT value) {
		put(BitConverter.getBytes(value));
	}

	public void put(final int value) throws IllegalArgumentException {
		if (value < MIN_VALUE) {
			throw new IllegalArgumentException("Illegal value: " + value
					+ ", value must be >= " + MIN_VALUE);
		} else if (value > MAX_VALUE) {
			throw new IllegalArgumentException("Illegal value: " + value
					+ ", value must be <= " + MAX_VALUE);
		}
		put(BitConverter.getBytes(getSize(), value));
	}

	public void put(long value) {
		put((int) value);
	}

	@Override
	public String toString() {
		return Integer.toString(intValue());
	}

}