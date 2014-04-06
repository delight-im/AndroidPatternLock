/**
 * Copyright 2014 www.delight.im <info@delight.im>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.PrintWriter;

/** List of all combinations for the Android pattern lock */
public class AndroidPatternLock extends Tree<Byte> {

	public static final byte LENGTH_MIN = 4;
	public static final byte LENGTH_MAX = 9;
	public static final byte NUMBER_MIN = 1;
	public static final byte NUMBER_MAX = 9;
	
	public AndroidPatternLock(Byte b, AndroidPatternLock t) {
		super(b, t);
	}
	
	private boolean isMovePossible(byte to) {
		return !hasAncestor(to) && (getNumberGroup(value) != getNumberGroup(to) || hasAncestor(getMiddle(value, to)));
	}
	
	private Byte getMiddle(byte from, byte to) {
		if (from != to && getNumberGroup(from) == getNumberGroup(to)) {
			return (byte) ((from+to) / 2);
		}
		else {
			return null;
		}
	}
	
	private static byte getNumberGroup(byte from) {
		if (from == 0) {
			return 0;
		}
		else if (from == 1 || from == 3 || from == 7 || from == 9) {
			return 1;
		}
		else if (from == 2 || from == 8) {
			return 2;
		}
		else if (from == 4 || from == 6) {
			return 3;
		}
		else {
			return 4;
		}
	}
	
	public void build() {
		for (byte to = NUMBER_MIN; to <= NUMBER_MAX; to++) {
			if (isMovePossible(to)) {
				AndroidPatternLock child = new AndroidPatternLock(to, this);
				if (child.level < LENGTH_MAX) {
					child.build();
				}
			}
		}
	}
	
	public String toString(boolean pathOnly) {
		StringBuilder out = new StringBuilder();
		if (level >= LENGTH_MIN || pathOnly) {
			if (parent != null) {
				out.append(((AndroidPatternLock) parent).toString(true));
			}
			if (value >= NUMBER_MIN && value <= NUMBER_MAX) {
				out.append(value.toString());
			}
		}
		
		if (!pathOnly && children.size() > 0) {
			for (Tree<Byte> child : children) {
				if (out.length() > 0) {
					out.append("\n");
				}
				out.append(child.toString());
			}
		}
		return out.toString();
	}
	
	@Override
	public String toString() {
		return toString(false);
	}
	
	public static void main(String[] args) {
		AndroidPatternLock AndroidPatternLock = new AndroidPatternLock((byte) 0, null);
		AndroidPatternLock.build();
		
		try {
			PrintWriter writer = new PrintWriter("OUTPUT.txt", "UTF-8");
			for (Tree<Byte> tree : AndroidPatternLock.children) {
				writer.println(tree.toString());
			}
			writer.close();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("OUTPUT.txt created");
	}

}
