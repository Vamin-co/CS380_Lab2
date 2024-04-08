class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * pre-order traversal
    * @param root The root of the tree/subtree
    */
   public void preOrderTraversal(Node root){
      if(root != null){
         System.out.println(root.value + " ");
         preOrderTraversal(root.left);
         preOrderTraversal(root.right);
      }
   }

   
   
   /**
    * in-order traversal
    * @param root the root of the tree/subtree
    */
   public void inOrderTraversal(Node root){
      if(root != null){
         inOrderTraversal(root.left);
         System.out.print(root.value + " ");
         inOrderTraversal(root.right);
      }
   }
   
   
   
   /**
    * post-order traversal
    * @param root the root of the tree/subtree
    */
   public void postOrderTraversal(Node root){
      if(root != null){
         postOrderTraversal(root.left);
         postOrderTraversal(root.right);
         System.out.print(root.value + " ");
     }
   }
   
   
   
   /**
    * finds the node in the tree with a specific value
    * @param root the root of the tree/subtree
    * @param key the key to search for
    * @return true if the key is found, false otherwise
    */
   public boolean find(Node root, int key){
      if(root == null){
         return false;
      }
      if(key == root.value){
          return true;
      } else if(key < root.value){
          return find(root.left, key);
      } else {
          return find(root.right, key);
      }          
   }
   
   /**
    * finds the node in the tree with the smallest key
    * @param root the root of the tree/subtree
    * @return the minimum key in the tree
    */
   public int getMin(Node root){
      Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.value;
   }
  
  
  
   /**
    * finds the node in the tree with the largest key
    * @param root the root of the tree/subtree
    * @return the maximum key in the tree
    */
   public int getMax(Node root){
      Node current = root;
      while(current.right != null){
          current = current.right;
      }
      return current.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}