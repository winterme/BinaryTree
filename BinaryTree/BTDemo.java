package com.chenparty.demo;

class BinaryTree {
	private class Node{
		// ����������ݣ������� Comparable�����࣬��Ϊ������������ܱȽ�
		private Comparable data;
		// ��������ߵĽڵ�
		private Node left;
		// �������ұߵĽڵ�
		private Node right;
		public Node(Comparable data) {
			this.data = data;
		}
		/**
		 * ��ӽڵ�
		 * @param node
		 */
		public void addNode(Node node) {
			if(this.data.compareTo(node.data)>0) {
				if(this.left==null) {
					this.left = node;
				}else {
					this.left.addNode(node);
				}
			}else {
				if(this.right==null) {
					this.right = node;
				}else {
					this.right.addNode(node);
				}
			}
		}
		/**
		 * �����������ת���� ��������
		 */
		public void toArryNode() {
			if(this.left != null) {
				this.left.toArryNode();
			}
			BinaryTree.this.resultDate[BinaryTree.this.foot++] = this.data;
			if(this.right != null) {
				this.right.toArryNode();
			}
			BinaryTree.index++;
		}
		/**
		 * ɾ���ڵ�
		 * @param node
		 * @param data
		 */
		public void remove(Node node,Comparable data) {
			if(this.right!=null) {
				if(this.left.data.equals(data)) {
					node.left = this.left.right;
					BinaryTree.this.count--;
				}else {
					this.left.remove(this, data);
				}
			}
			if(this.right!=null) {
				if(this.right.data.equals(data)) {
					node.right = this;
					BinaryTree.this.count--;
				}else {
					this.right.remove(this, data);
				}
			}
		}
		
	}
	
	//-------------------/
	// ���ڵ�
	private Node root;
	// �������ݵĸ���
	private Integer count = 0;
	// �ű�
	private Integer foot;
	// ��������
	private Object[] resultDate;
	
	public static int index = 0;
	
	/**
	 * �������������������
	 * @return Object[]
	 */
	public Object[] toArray() {
		// TODO Auto-generated method stub
		this.foot = 0;
		this.resultDate = new Object[this.count];
		this.root.toArryNode();
		return this.resultDate;
	}
	/**
	 * ��ӽڵ�
	 * @param data
	 */
	public void add(Object data) {
		// TODO Auto-generated method stub
		Node newNode = new Node((Comparable)data);
		if(this.root==null) {
			this.root = newNode;
		}else {
			this.root.addNode(newNode);
		}
		this.count++;
	}
	
	/**
	 * ɾ���ڵ�
	 * @param data
	 */
	public void remove(Comparable data) {
		if(this.root.data.equals(data)) {
			this.root = this.root.left.right;
		}else {
			this.root.remove(this.root, data);
		}
	}
	
}

public class BTDemo {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add("B");
		binaryTree.add("D");
		
		for(int x=0 ; x<binaryTree.toArray().length;x++) {
			System.out.println(binaryTree.toArray()[x]);
		}
		System.out.println(BinaryTree.index);
		
		
	}
}
