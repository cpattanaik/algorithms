/**
 * 
 */
package com.cpattanaik.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author c0p00fy
 *
 */
public class Tree<T> {
	private Node<T> root = null;

	/**
	 * @param T
	 */
	public void add(T value) {
		add(root, value);
	}

	/**
	 * @param root
	 * @param value
	 */
	private void add(Node<T> root, T value) {
		Node<T> temp = new Node<T>();
		temp.data =  value;
		temp.left = null;
		temp.right = null;
		
		if(root == null){
			this.root = temp;
			return;
		}
		
		Queue<Node<T>> q =  new LinkedList<Node<T>>();
		q.add(root);
		while(!q.isEmpty()){
			Node<T> node = q.poll();
			if (node.left == null){
				node.left  = temp;
				return;
			}else if(node.right == null){
				node.right  = temp;
				return ;
			}else{
				q.add(node.left);
				q.add(node.right);
			}
		}		
	}

	/**
	 * 
	 */
	public void show() {
		show(root);
		
	}

	/**
	 * @param root
	 */
	private void show(Node<T> root) {
		if(root == null){
			return;
		}
		
		Queue<Node<T>> q =  new LinkedList<Node<T>>();
		q.add(root);
		while(!q.isEmpty()){
			Node<T> node = q.poll();
			
			System.out.println(node.data);
			if (node.left != null){
				q.add(node.left);
			}
			
			if(node.right != null){
				q.add(node.right);
			}
		}		
		
	}
	
}
