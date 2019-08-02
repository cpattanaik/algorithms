package com.pattanaik.ds;

public class TreeClient {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.addNode(50);
        tree.addNode(30);
        tree.addNode(20);
        tree.addNode(40);
        tree.addNode(70);
        tree.addNode(60);
        tree.addNode(80);
        tree.inOrder();
        
        Integer value = tree.search(80);
        if(value != null){
        	System.out.println("Search Result:" + value);
        }else{
        	System.out.println("Search Result:" + "empty");
        }
	}
}
