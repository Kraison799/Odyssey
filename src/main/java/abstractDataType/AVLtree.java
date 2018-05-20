package abstractDataType;

import Library.Artist;

public class AVLtree {
	private BinaryNode<Artist> root;

	// CONSTRUCTOR
	public AVLtree() {
		this.root = null;
	}

	// METHODS
	public void insert(Artist value) {
		if(this.root == null) {
			this.root = new BinaryNode<Artist>(value);
		} else {
			this.insert(value, this.root);
		}
	}
	public void remove(String name) {
		if(name == this.root.getValue().getName()) {
			if (root.getLeft() != null && root.getRight() != null) {
				Artist newValue = this.findMin(this.root.getRight());
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
	public Artist find(String name) {
		if(this.root != null) {
			return this.find(name, this.root);
		} else {
			return null;
		}
	}

	// PRIVATE METHODS
	private void insert(Artist value, BinaryNode<Artist> current) {
		if(current.getLeft() == null && value.getName().compareTo(current.getValue().getName()) <= -1) {
			current.setLeft(new BinaryNode<Artist>(value));
		} else if(current.getRight() == null && value.getName().compareTo(current.getValue().getName()) >= 1) {
			current.setRight(new BinaryNode<Artist>(value));
		} else if(current.getLeft() != null && value.getName().compareTo(current.getValue().getName()) <= -1) {
			this.insert(value, current.getLeft());
		} else if(current.getRight() != null && value.getName().compareTo(current.getValue().getName()) >= 1) {
			this.insert(value, current.getRight());
		}
	}
	private void remove(Artist value, BinaryNode<Artist> node){
		BinaryNode<Artist> left = node.getLeft();
		BinaryNode<Artist> right = node.getRight();
		if(value == left.getValue()) {
			if (left.getLeft() != null && left.getRight() != null) {
				Artist newValue = this.findMin(left.getRight());
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
				Artist newValue = this.findMin(right.getRight());
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
	private Artist find(String name, BinaryNode<Artist> current) {
		if(current.getLeft() == null && current.getRight() == null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return null;
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				return current.getValue();
			} else {
				return null;
			}
		} else if(current.getLeft() != null && current.getRight() == null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return this.find(name, current.getLeft());
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				return current.getValue();
			} else {
				return null;
			}
		} else if(current.getLeft() == null && current.getRight() != null) {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return null;
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				return current.getValue();
			} else {
				return this.find(name, current.getRight());
			}
		} else {
			if(name.compareTo(current.getValue().getName()) <= -1) {
				return this.find(name, current.getLeft());
			} else if(name.compareTo(current.getValue().getName()) == 0) {
				return current.getValue();
			} else {
				return this.find(name, current.getRight());
			}
		}
	}
	public Artist findMin() {
		if (root.getLeft()==null) {
			return root.getValue();
		}else {
			return findMin(root);
		}
	}
	private Artist findMin(BinaryNode<Artist> node) {
		if (node.getLeft() == null) {
			return node.getValue();
		} else {
			return findMin(node.getLeft());
		}
	}
	public Artist findMax() {
		if (root.getRight()==null) {
			return this.root.getValue();
		} else {
			return findMax(root);
		}
	}
	private Artist findMax(BinaryNode<Artist> node) {
		if (node.getRight() == null) {
			return node.getValue();
		} else {
			return findMax(node.getRight());
		}
	}
	// This method is used to get the height for a node
//	private int getHeight(BinaryNode<Artist> current, int count) {
//		if(current.getLeft() == null && current.getRight() == null) {
//			return count;
//		} else if(current.getLeft() != null && current.getRight() == null) {
//			return this.getHeight(current.getLeft(), count+1);
//		} else if(current.getLeft() == null && current.getRight() != null) {
//			return this.getHeight(current.getRight(), count+1);
//		} else {
//			if(this.getHeight(current.getLeft(), count+1) > this.getHeight(current.getRight(), count+1)) {
//				return this.getHeight(current.getLeft(), count+1);
//			} else {
//				return this.getHeight(current.getRight(), count+1);
//			}
//		}
//	}
//	private void leftLeft(BinaryNode<Artist> node) {
//		BinaryNode<Artist> n = node;
//		BinaryNode<Artist> n1 = node.getLeft();
//		n.setLeft(n1.getRight());
//		n1.setRight(n);
//		node = n1;
//	}
//	private void rightRight(BinaryNode<Artist> node) {
//		BinaryNode<Artist> n = node;
//		BinaryNode<Artist> n1 = node.getRight();
//		n.setRight(n1.getLeft());
//		n1.setLeft(n);
//		node = n1;
//	}
}
