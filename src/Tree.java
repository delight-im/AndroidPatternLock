/*
 * Copyright (c) delight.im <info@delight.im>
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

import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

	public Tree<T> parent;
	public T value;
	public int level;
	public List<Tree<T>> children;

	public Tree(T v, Tree<T> p) {
		parent = p;
		value = v;
		level = parent == null ? 0 : parent.level + 1;
		children = new LinkedList<Tree<T>>();
		if (parent != null) {
			parent.children.add(this);
		}
	}

	public boolean hasAncestor(T value) {
		if (value != null && parent != null) {
			return parent.value == value || parent.hasAncestor(value);
		}
		else {
			return false;
		}
	}

}
