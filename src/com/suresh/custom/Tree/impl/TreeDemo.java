package com.suresh.custom.Tree.impl;

import java.util.Arrays;

/**
* 
* Tree structure demo to :
* 1. insert/store items 
* 2. print/retrieve items in the tree. Method : In-order traversal.
* 
* Basically a tree structure is used to store items in a sorted fashion.
*
* In-order traversal retrieves the data in the natural order of input data , regardless of the order they were inserted.
*
*/
public class TreeDemo {
	public static  BinaryTreeNode root;
	public TreeDemo(){
		this.root = null;
	}
	
	/**
	 * Method to insert into the tree structure
	 */
	public void insertBinaryTreeNode(int toBeInserted){
		BinaryTreeNode newNode = new BinaryTreeNode(toBeInserted);
		if(null==root){
			root = newNode;
			return;
		}
		BinaryTreeNode current = root;
		BinaryTreeNode parent = null;
		while(true){
			parent = current;
			if(toBeInserted<current.value){				
				current = current.left;
				if(null==current){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(null==current){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	/**
	 * Method to print the tree structure
	 */
	static void printTreeStructure(BinaryTreeNode root){
		if(null!=root){
			printTreeStructure(root.left);
			System.out.print(" " + root.value);
			printTreeStructure(root.right);
		}
	}
	public static void main(String arg[]){
		TreeDemo binaryTreeDemo = new TreeDemo();
		
		//You could use your own data, too.
		//Unsorted set of values for demo
		int[] listOfValues = {3,8,7,6,2,9,5};
		
		//Auto insert list of values into the tree	
		//NOTE: This is Java 8 way of iterating and inserting into the Binary Tree
		Arrays.stream(listOfValues).
				forEach(p -> binaryTreeDemo.insertBinaryTreeNode(p));
				
		
		System.out.println("Printing Tree (Sorted) - In-order traversal : ");
		printTreeStructure(binaryTreeDemo.root);		
	}
}

class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;	
	public BinaryTreeNode(int data){
		this.value = data;
		left = null;
		right = null;
	}
}