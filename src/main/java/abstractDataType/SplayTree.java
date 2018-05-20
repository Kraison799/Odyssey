package abstractDataType;

import Library.Album;

public class SplayTree {
	public BinaryNode<Album> root;

	// CONSTRUCTOR
	public SplayTree() {
		this.root = null;
	}

	// METHODS
	// This method add a new node with a value provided into the tree.
	public void insert(Album value) {
		if(this.root == null) {
			this.root = new BinaryNode<Album>(value);
		} else {
			this.insert(value, this.root);
		}
	}
	// This method remove a node from the tree according to the value provided.
	public void remove(String name) {
		if(name == this.root.getValue().getName()) {
			if (root.getLeft() != null && root.getRight() != null) {
				Album newValue = this.findMin(this.root.getRight());
				root.setValue(newValue);
				this.remove(newValue, root.getRight());
			}else if(root.getLeft() != null) {
				this.root = root.getLeft();
			}else if(root.getRight() != null) {
				this.root=root.getRight();
			}
			else {
				this.root=null;
			}
		} else {
			this.remove(this.find(name), root);
		}
	}
	// This method search into the tree for a node according to the index provided.
	public Album find(String name) {
		if(this.root != null) {
			return this.find(name, this.root, null);
		} else {
			return null;
		}
	}

	// PRIVATE METHODS
	// This method inserts a value into the tree
	private void insert(Album value, BinaryNode<Album> current) {
		if(current.getLeft() == null && current.getRight() == null) {
			if(value.getName().compareTo(current.getValue().getName()) <= -1) {
				BinaryNode<Album> newNode = new BinaryNode<Album>(value);
				current.setLeft(newNode);
			} else if(value.getName().compareTo(current.getValue().getName()) >= 1) {
				BinaryNode<Album> newNode = new BinaryNode<Album>(value);
				current.setRight(newNode);
			}
		} else if(current.getLeft() != null && current.getRight() == null) {
			if(value.getName().compareTo(current.getValue().getName()) <= -1) {
				this.insert(value, current.getLeft());
			} else if(value.getName().compareTo(current.getValue().getName()) >= 1) {
				BinaryNode<Album> newNode = new BinaryNode<Album>(value);
				current.setRight(newNode);
			}
		} else if(current.getLeft() == null && current.getRight() != null) {
			if(value.getName().compareTo(current.getValue().getName()) <= -1) {
				BinaryNode<Album> newNode = new BinaryNode<Album>(value);
				current.setLeft(newNode);
			} else if(value.getName().compareTo(current.getValue().getName()) >= 1) {
				this.insert(value, current.getRight());
			}
		} else if(current.getLeft() != null && current.getRight() != null) {
			if(value.getName().compareTo(current.getValue().getName()) <= -1) {
				this.insert(value, current.getLeft());
			} else if(value.getName().compareTo(current.getValue().getName()) >= 1) {
				this.insert(value, current.getRight());
			}
		}
	}
	private void remove(Album value, BinaryNode<Album> node){
		BinaryNode<Album> left = node.getLeft();
		BinaryNode<Album> right = node.getRight();
		if(value == left.getValue()) {
			if (left.getLeft() != null && left.getRight() != null) {
				Album newValue = this.findMin(left.getRight());
				left.setValue(newValue);
				this.remove(newValue,left.getRight());
			}else if(left.getLeft() != null) {
				node.setLeft(left.getLeft());
			}else if(right.getRight() != null){
				node.setLeft(left.getRight());
			}else {
				node.setLeft(null);
			}
		} else if(value == right.getValue()) {
			if (right.getLeft() != null && right.getRight() != null) {
				Album newValue = this.findMin(right.getRight());
				right.setValue(newValue);
				this.remove(newValue,right.getRight());
			}else if(right.getLeft() != null) {
				node.setRight(right.getLeft());
			}else if(right.getRight() != null){
				node.setRight(right.getRight());
			}else {
				node.setRight(null);
			}
		} else {
			if (value.getName().compareTo(node.getValue().getName()) <= -1){
				this.remove(value, node.getLeft());
			} else if(value.getName().compareTo(node.getValue().getName()) >= 1){
				this.remove(value, node.getRight());
			}
		}
	}
	// This method finds a value into the tree
	private Album find(String name, BinaryNode<Album> current, BinaryNode<Album> prev) {
		if(current.getLeft() == null && current.getRight() == null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return null;
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				if(prev == null) {
					return this.root.getValue();
				} else {
					return current.getValue();
				}
			} else {
				return null;
			}
		} else if(current.getLeft() != null && current.getRight() == null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return this.find(name, current.getLeft(), current);
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				if(prev == null) {
					return this.root.getValue();
				} else {
					return current.getValue();
				}
			} else {
				return null;
			}
		} else if(current.getLeft() == null && current.getRight() != null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return null;
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				if(prev == null) {
					return this.root.getValue();
				} else {
					return current.getValue();
				}
			} else {
				return this.find(name, current.getRight(), current);
			}
		} else {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return this.find(name, current.getLeft(), current);
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				if(prev == null) {
					return this.root.getValue();
				} else {
					return current.getValue();
				}
			} else {
				return this.find(name, current.getRight(), current);
			}
		}
	}
	// This method find the Max. Value from a subtree with a root provided.
//	private Album findMax(BinaryNode<Album> current) {
//		while(current.getRight() != null) {
//			current = current.getRight();
//		}
//		return current.getValue();
//	}
	private Album findMin(BinaryNode<Album> current) {
		while(current.getRight() != null) {
			current = current.getLeft();
		}
		return current.getValue();
	}
	// This method takes a node and move it to the root
//	private void newRoot(BinaryNode<Album> parent, BinaryNode<Album> node) {
//		Album maxLeft = this.findMax(root.getLeft());
//	}
//	private void zig(BinaryNode<Album> n) {
//		BinaryNode<Album> n1 = n.getLeft();
//	}
//	private void zag(BinaryNode<Album> n) {
//		BinaryNode<Album> n1 = n.getRight();
//	}
}
