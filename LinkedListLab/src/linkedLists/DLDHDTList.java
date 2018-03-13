package linkedLists;

import java.util.NoSuchElementException;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
		length = 0;
		header =  trailer = null;
		// ADD CODE HERE to generate empty linked list of this type 
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		DNode<E> td = (DNode<E>) target;
		DNode<E> nd = (DNode<E>) nuevo;
		DNode<E> prev = td.getPrev();
		td.setPrev(nd);
		nd.setNext(td);
		nd.setPrev(prev);
		if(prev != null)
			prev.setNext(nd);
		else
			header = nd;
		length++;// ADD CODE HERE
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}
   
	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		DNode<E> datan = ((DNode<E>) target).getNext(); 
		if (datan == null)  
			throw new NoSuchElementException("getNextNode(...) : target is the last node."); 
		else 
			return datan;// ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
	
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		DNode<E> datat = ((DNode<E>) target).getNext(); 
		if (datat == header)  
			throw new NoSuchElementException("getNextNode(...) : target is the last node."); 
		else 
			return datat;// ADD CODE HERE AND MODIFY RETURN ACCORDINGLY
		
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		DNode<E> datat = (DNode<E>) target;
		if(datat == header) {
			header = header.getNext();
		}
		else {
			datat.getPrev().setNext(datat.getNext());
			datat.getNext().setPrev(datat.getPrev());
		}
		datat.clean();
		length--;// ADD CODE HERE to disconnect target from the linked list, reduce lent, clean target...
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		destroy();
		header = trailer = null;
		length = 0;// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}

}
