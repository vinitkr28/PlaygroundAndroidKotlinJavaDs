package ds1;

public class BinaryTreeYT {
	
	static class Node {
		int data;
		Node nodeLift;
		Node nodeRight;
		
		public Node(int data) {
			super();
			this.data = data;
			this.nodeLift = null;
			this.nodeRight = null;
		}
	
	}
	
	
	static class BinaryTree{
		static int idx = -1;
		
		public static Node buildTree(int nodes[]) {
			idx++;
			
			if (nodes[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);
			newNode.nodeLift = buildTree(nodes);
			newNode.nodeRight = buildTree(nodes);
			
			return newNode;
		}
	}
	
	//Pre-order Traversal [-Root	-Left subtree	-Right subtree]
	public static void preorder(Node root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preorder(root.nodeLift);
		preorder(root.nodeRight);
		
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		BinaryTree tree = new BinaryTree();
		Node node = tree.buildTree(nodes);
		
		System.out.println("Root:: " + node.data);
		
		preorder(node);
				
	}

}
