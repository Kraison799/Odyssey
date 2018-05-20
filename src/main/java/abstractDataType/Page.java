package abstractDataType;

import Library.Song;

public class Page {
    private int size;
    private Song[] values;
    private Page[] children;
    private Page parent;
    private boolean leaf;

    // CONSTRUCTOR
    public Page(Page parent) {
        this.size = 6;
        this.values = new Song[size];
        this.children = new Page[size+1];
        this.parent = parent;
        this.leaf = true;
    }

    // METHODS
    public void insert(Song value) {
        if(this.leaf) {
            this.insertLeaf(value);
        } else {
            this.insertParent(value);
        }
    }
    public Song getValue(String name) {
        if(!this.leaf) {
            for(int i = 0; i < size; i++) {
                if(this.values[i].getName().compareTo(name) <= -1) {
                    return this.children[i].getValue(name);
                } else  if(this.values[i].getName().compareTo(name) >= 1 && i == 5) {
                    return this.children[i+1].getValue(name);
                }
            }
        } else {
            for(int x = 0; x < 6; x++) {
                if(this.values[x].getName().compareTo(name) == 1);
                return this.values[x];
            }
        }
        return null;
    }
    public void remove(String name) {
        if(this.leaf) {
            for(int c = 0; c < 6; c++) {
                if(this.values[c] == null) {
                    return;
                } else if(this.values[c].getName().compareTo(name) == 0) {
                    this.values[c] = null;
                    this.sort();
                }
            }
        } else {
            for(int c = 0; c < 6; c++) {
                if(this.values[c] == null) {
                    return;
                } else if(c == 5 && this.values[c].getName().compareTo(name) >= 1) {
                    this.children[6].remove(name);
                } else if(c == 5 && this.values[c].getName().compareTo(name) <= -1) {
                    this.children[5].remove(name);
                } else if(this.values[c].getName().compareTo(name) == 0) {
                    this.values[c] = this.children[c].getMax();
                } else if(this.values[c].getName().compareTo(name) <= -1 && this.values[c+1].getName().compareTo(name) >= 1) {
                    this.children[c].remove(name);
                }
            }
        }
    }
    public void addChild(Page fChild, Page sChild) {
        Page other = null;
        for(int x = 0; x < this.children.length; x++) {
            if(other == null) {
                if(this.children[x] == fChild) {
                    other = this.children[x+1];
                    this.children[x+1] = sChild;
                    ++x;
                }
            } else {
                sChild = this.children[x];
                this.children[x] = other;
                other = this.children[x];
            }
        }
    }

    // PRIVATE METHODS
//		private Song getMin() {
//			Song min = this.values[0];
//			for(int i = 0; i < 6; i ++) {
//				if(this.values[i].getName().compareTo(min.getName()) <= -1) {
//					min = this.values[i];
//				}
//			}
//			this.remove(min.getName());
//			return min;
//		}
    private Song getMax() {
        Song max = this.values[0];
        for(int i = 0; i < 6; i ++) {
            if(this.values[i].getName().compareTo(max.getName()) >= 1) {
                max = this.values[i];
            }
        }
        this.remove(max.getName());
        return max;
    }
    private void sort() {
        boolean change = false;
        int index = 0;
        while(index < 5 && this.values[index] != null && this.values[index+1] != null) {
            if(this.values[index].getName().compareTo(this.values[index+1].getName()) >= 1) {
                Song s1 = this.values[index];
                Song s2 = this.values[index+1];
                this.values[index] = s2;
                this.values[index+1] = s1;
                change = true;
            }
            index++;
        }
        if(change) {
            this.sort();
        }
    }
    private void insertLeaf(Song value) {
        for(int i = 0; i < 6; i++) {
            if(this.values[i] == null) {
                this.values[i] = value;
                this.sort();
                break;
            } else if(i == 5) {
                Song max = value;
                Song refer = null;
                for(int c = 0; c < 6; c++) {
                    if(max.getName().compareTo(this.values[c].getName()) >= 1) {
                        refer = this.values[c];
                        this.values[c] = max;
                        max = refer;
                    }
                }
                this.sort();
                Page fChild = new Page(this);
                Page sChild = new Page(this);
                for(int e = 0; e < 6; e++) {
                    fChild.values[0] = this.values[0];
                    fChild.values[1] = this.values[1];
                    fChild.values[2] = this.values[2];
                    sChild.values[0] = this.values[4];
                    sChild.values[1] = this.values[5];
                    sChild.values[2] = max;
                }
                refer = this.values[3];
                this.values = new Song[6];
                this.values[0] = refer;
            }
        }
    }
    private void insertParent(Song value) {
        for(int i = 0; i < 6; i++) {
            if(this.values[i].getName().compareTo(value.getName()) <= -1 && i == 5) {
                this.children[6].insert(value);
            } else if(this.values[i].getName().compareTo(value.getName()) >= 1) {
                this.children[i].insert(value);
            }
        }
    }
}
