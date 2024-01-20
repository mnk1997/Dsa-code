package in.cdac.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import in.cdac.binarytree.RecoverBST.TreeNode;

public class RecoverBSTOne {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
		public static TreeNode setTreeNode(ArrayList<Integer> list) {
			System.out.println("list size" + list.size());
			TreeNode head = null;
			Queue<TreeNode> q = new LinkedList<>();
			for (int i = 0; i < list.size(); i += 2) {

				if (i == 0) {
					head = new TreeNode(list.get(0));
					if (list.get(i + 1) == -1)
						head.left = null;
					else {
						head.left = new TreeNode(list.get(i + 1));
						q.add(head.left);
					}
					if (list.get(i + 2) == -1)
						head.right = null;
					else {
						head.right = new TreeNode(list.get(i + 2));
						q.add(head.right);
					}

				} else {
					if (q.isEmpty()) {
						break;
					}
					TreeNode curr = q.poll();
					if (i + 1 >= list.size()) {
						curr.left = null;
						curr.right = null;
						continue;
					}

					if (i + 1 < list.size() && list.get(i + 1) == -1)
						curr.left = null;
					else {
						curr.left = new TreeNode(list.get(i + 1));
						q.add(curr.left);
					}
					if (i + 2 >= list.size()) {
						curr.right = null;
						continue;
					}
					if (i + 2 < list.size() && list.get(i + 2) == -1)
						curr.right = null;
					else {
						curr.right = new TreeNode(list.get(i + 2));
						q.add(curr.right);
					}

				}
			}
			return head;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = TreeNode.setTreeNode(new ArrayList<Integer>(Arrays.asList(344, 162, 345, 152, 181, -1, -1, 106,
				161, 173, 261, 92, 133, 157, -1, 165, 178, 256, 329, 86, 104, 108, 137, 154, 160, 163, 171, 174, 179,
				210, 258, 265, 335, 83, 87, 102, 105, 107, 114, 134, 147, 153, 155, 159, -1, -1, 164, 170, 172, -1, 176,
				-1, 180, 182, 221, 257, 259, 264, 311, 334, 337, 80, 85, -1, 90, 96, 103, -1, -1, -1, -1, 109, 132, -1,
				135, 144, 148, -1, -1, -1, 156, 158, -1, -1, -1, 167, -1, -1, -1, 175, 177, -1, -1, -1, 202, 219, 223,
				-1, -1, -1, 260, 262, -1, 278, 314, 331, -1, 336, 339, 79, 82, 84, -1, 88, 91, 93, 97, -1, -1, -1, 113,
				117, -1, -1, 136, 139, 145, -1, 150, -1, -1, -1, -1, 166, 168, -1, -1, -1, -1, 186, 208, 214, 220, 222,
				245, -1, -1, -1, 263, 269, 304, 313, 319, 330, 333, -1, -1, 338, 341, -1, -1, 81, -1, -1, -1, -1, 89,
				-1, -1, -1, 95, -1, 98, 110, -1, 115, 125, -1, -1, 138, 141, -1, 146, 149, 151, -1, -1, -1, 169, 185,
				193, 203, 209, 213, 218, -1, -1, -1, -1, 241, 247, -1, -1, 268, 276, 297, 307, 312, -1, 317, 328, -1,
				-1, 332, -1, -1, -1, 340, 343, -1, -1, -1, -1, 94, -1, -1, 99, -1, 111, 116, -1, 120, 128, -1, -1, 140,
				142, -1, -1, -1, -1, -1, -1, -1, -1, 184, -1, 192, 198, -1, 206, -1, -1, 211, -1, 215, -1, 224, 244,
				246, 250, 267, -1, 275, 277, 291, 299, 306, 308, -1, -1, 316, 318, 320, -1, -1, -1, -1, -1, 342, -1, -1,
				-1, -1, 101, -1, 112, -1, -1, 118, 122, 126, 130, -1, -1, -1, 143, 183, -1, 189, -1, 195, 200, 205, 207,
				-1, 212, -1, 217, -1, 227, 243, -1, -1, -1, 248, 251, 266, -1, 274, -1, -1, -1, 281, 295, 298, 301, 305,
				-1, -1, 309, 315, -1, -1, -1, -1, 323, -1, -1, 100, -1, -1, -1, -1, 119, 121, 124, -1, 127, 129, 131,
				-1, -1, -1, -1, 187, 190, 194, 196, 199, 201, 204, -1, -1, -1, -1, -1, 216, -1, 226, 239, 242, -1, -1,
				249, -1, 253, -1, -1, 270, -1, 280, 290, 294, 296, -1, -1, 300, 302, -1, -1, -1, 310, -1, -1, 321, 325,
				-1, -1, -1, -1, -1, -1, 123, -1, -1, -1, -1, -1, -1, -1, -1, 188, -1, 191, -1, -1, -1, 197, -1, -1, -1,
				-1, -1, -1, -1, -1, 225, -1, 231, 240, -1, -1, -1, -1, 252, 254, -1, 272, 279, -1, 283, -1, 292, -1, -1,
				-1, -1, -1, -1, 303, -1, -1, -1, 322, 324, 327, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 228, 232, -1,
				-1, -1, -1, -1, 255, 271, 273, -1, -1, 282, 284, -1, 293, -1, -1, -1, -1, -1, -1, 326, -1, -1, 229, -1,
				238, -1, -1, -1, -1, -1, -1, -1, -1, -1, 285, -1, -1, -1, -1, -1, 230, 237, -1, -1, 287, -1, -1, 235,
				-1, 286, 288, 233, 236, -1, -1, -1, 289, -1, 234, -1, -1, -1, -1, -1, -1)));
		
		for(int ele:recoverTree(A))
		{
			System.out.println(ele);
		}

	}

	
		public static ArrayList<Integer> recoverTree(TreeNode A) {
			ArrayList<Integer> op = new ArrayList<>();
			if (A == null)
				return op;
			TreeNode curr = A;
			TreeNode prev = null;
			TreeNode first = null;
			TreeNode second = null;
			while (curr != null) {
				if (curr.left == null) {
					// Process current node
					if (prev != null && prev.val > curr.val) {
						if (first == null) {
							first = prev;
							second = curr;
						} else {
							second = curr;
						}
					}
					prev = curr;
					curr = curr.right;
				} else {
					// Find the inorder predecessor
					TreeNode predecessor = curr.left;
					while (predecessor.right != null && predecessor.right != curr) {
						predecessor = predecessor.right;
					}
					if (predecessor.right == null) {
						// Make the current node as the right child of its inorder predecessor
						predecessor.right = curr;
						curr = curr.left;
					} else {
						// Revert the changes made in the if branch and process the current node
						predecessor.right = null;
						if (prev != null && prev.val > curr.val) {
							if (first == null) {
								first = prev;
								second = curr;
							} else {
								second = curr;
							}
						}
						prev = curr;
						curr = curr.right;
					}
				}
			}
			if (first != null && second != null) {
				op.add(Math.min(first.val, second.val));
				op.add(Math.max(first.val, second.val));
			}
			return op;
		}
	}


