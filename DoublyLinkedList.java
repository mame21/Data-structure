class DoublyLinkedList {

	protected Node head;
	protected Node tail;
	public int size;

		public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

		public boolean isEmpty() {
		return this.head == null;
	}

		public int getSize() {
		return size;
	}

	
	public void addToHead(int val) {

		Node node1 = new Node(val, null, null);
		if (isEmpty())
			this.head = this.tail = node1;

		else {
			this.head.setLinkPrev(node1);
			node1.setLinkNext(this.head);
			this.head = node1;
		}
		size++;
	}

		public void addToTail(int val) {

		Node node = new Node(val, null, null);

		if (isEmpty())
			this.head = this.tail = node;

		else {
			node.setLinkPrev(this.tail);
			this.tail.setLinkNext(node);
			this.tail = node;
		}
		size++;
	}

		public void insertAtPos(int val, int pos) {
		Node node = new Node(val, null, null);
		if (pos == 1) {
			addToHead(val);
			return;
		}

		Node current = this.head;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node tmp = current.getLinkNext();
				current.setLinkNext(node);
				node.setLinkPrev(current);
				node.setLinkNext(tmp);
				tmp.setLinkPrev(node);
			}
			current = current.getLinkNext();
		}
		size++;
	}

	
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			if (size == 1) {
				this.head = null;
				size = 0;
				return;
			} else {
				this.head = this.head.getLinkNext();
				this.head.setLinkPrev(null);
				size--;
				return;
			}
		}

		if (pos == size) {
			this.tail = this.tail.getLinkPrev();
			this.tail.setLinkNext(null);
			size--;
		}

		Node ptr = this.head.getLinkNext();

		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				Node p = ptr.getLinkPrev();
				Node n = ptr.getLinkNext();
				p.setLinkNext(n);
				n.setLinkPrev(p);
				size--;
				return;
			}

			ptr = ptr.getLinkNext();
		}
	}


	public void display() {

		if (size == 0) {
			System.out.print("List Is Empty \n");
			return;
		}

		if (this.head.getLinkNext() == null) {
			System.out.println(this.head.getData());
			return;
		}

		Node ptr = this.head;
		System.out.println(this.head.getData());
		ptr = this.head.getLinkNext();

		while (ptr.getLinkNext() != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getLinkNext();
		}
		System.out.println(ptr.getData());
	}

    private static class Node {

        public Node() {
        }

        private Node(int val, Object object, Object object0) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private void setLinkPrev(Node node1) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private void setLinkNext(Node head) {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private Node getLinkNext() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private Node getLinkPrev() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }

        private boolean getData() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
