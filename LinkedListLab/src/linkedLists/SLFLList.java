package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(first); 
		first = last =(SNode<E>) nuevo; 
		length++; // TODO Auto-generated method stub
		
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		 SNode<E> snTarget = (SNode<E>) target; 
         SNode<E> snNuevo = (SNode<E>) nuevo;
         snNuevo.setNext(snTarget.getNext()); 
         snTarget.setNext(snNuevo); 
         if(snTarget == last) {
        	last = snNuevo; 
         }
         length++;// TODO Auto-generated method stub
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		SNode<E> snTarget = (SNode<E>) target; 
        SNode<E> snNuevo = (SNode<E>) nuevo;
        if(snTarget == first) {
        	this.addFirstNode(snNuevo);
        } 
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != snTarget) 
				prev = prev.getNext();
			this.addNodeAfter(prev, nuevo); 
		}
        length++;// TODO Auto-generated method stub
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (first == null)
			throw new NoSuchElementException("getFirstNode() : linked list is empty...");
		return first;// TODO Auto-generated method stub
		
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (first == null)
			throw new NoSuchElementException("getLastNode(): Empty list."); 
		SNode<E> temp = first; 
		while (((SNode<E>) temp).getNext() != null)
			temp = temp.getNext();
		return temp; 
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> snTarget = ((SNode<E>) target).getNext();
		if(snTarget == null)
			throw new NoSuchElementException("getNextNode(...) : target is the last node."); 
		return snTarget;// TODO Auto-generated method stub
		
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		// TODO Auto-generated method stub
		
			SNode<E> snTarget = (SNode<E>) target;
			if(snTarget == first) {
				throw new NoSuchElementException("getPrevNode(...) : target is the first node.");
			}
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != snTarget) 
				prev = prev.getNext();
			return prev;
	}

	public int length() {
		// TODO Auto-generated method stub
		return length;
	}

	public void removeNode(Node<E> target) {
		// TODO Auto-generated method stub
		SNode<E> snTarget = (SNode<E>) target;
		if (snTarget == first) 
			first = first.getNext(); 
		else { 
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(snTarget); 
			prevNode.setNext(snTarget.getNext()); 
		}
		snTarget.clean();   // clear all references from target
		length--; 
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}

}
