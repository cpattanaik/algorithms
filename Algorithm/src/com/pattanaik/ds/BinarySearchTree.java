package com.pattanaik.ds;

import java.util.PriorityQueue;

public class BinarySearchTree {
	private TreeNode root = null;
	public void addNode(Integer data){
		root = addNode(root, data);
	}
	
	private TreeNode addNode(TreeNode root, Integer data) {
		if(root == null){
			root = new TreeNode();
			root.left =  null;
			root.right = null;
			root.data = data;
			return root;
		}
		if(root.data > data){
			root.left = addNode(root.left,  data);
		}else{
			root.right = addNode(root.right,  data);
		}
		return root;
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(TreeNode root) {
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public Integer search(Integer data) {
		TreeNode node = search(root,data);
		if(node == null){
			return null;
		}else{
			return node.data;
		}
			
	}
	
	private TreeNode search(TreeNode root, Integer data) {
		if(root == null || root.data == data){
			return root;
		}
		
		PriorityQueue<Integer> pQueue =  
	             new PriorityQueue<Integer>(); 
	  
		TreeNode left = search(root.left, data);
		TreeNode right = search(root.right, data);
		return left != null ? left : right; 
	}
	
	
}
