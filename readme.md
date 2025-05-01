# Squirrel Binary Tree

A Java implementation of a binary tree data structure that stores `Squirrel` objects.

## Project Structure

- `src/main/java/com/squirreltree/`: Main implementation of the binary tree
  - `Squirrel.java`: Class representing a squirrel with a name
  - `Node.java`: Node class that forms the binary tree structure
  - `BinaryTree.java`: Binary tree implementation with traversal methods
  - `Main.java`: Demo program showing how to use the binary tree

- `src/main/java/com/squirreltree/generic/`: Generic implementation of the binary tree
  - `GenericNode.java`: Generic node class that can store any type
  - `GenericBinaryTree.java`: Generic binary tree implementation
  - `GenericMain.java`: Demo program showing how to use the generic binary tree

## Building and Running

### Prerequisites
- Java 11 or higher
- Gradle 7.0 or higher

### Build the project
```bash
gradle build
```

### Run the main application
```bash
gradle run
```

### Run the tests
```bash
gradle test
```

## Usage Examples

```java
// Create squirrels
Squirrel cheeks = new Squirrel("Cheeks");
Squirrel squeaks = new Squirrel("Squeaks");
Squirrel fluffybutt = new Squirrel("Mr. Fluffy Butt");

// Create nodes
Node nodeOne = new Node(cheeks);
Node nodeTwo = new Node(squeaks);
Node nodeThree = new Node(fluffybutt);

// Set up tree structure
nodeOne.setLeft(nodeTwo);
nodeOne.setRight(nodeThree);

// Retrieve nodes
Node retrievedLeft = nodeOne.left();
Node retrievedRight = nodeOne.right();

// Create a tree with the root
BinaryTree tree = new BinaryTree();
tree.setRoot(nodeOne);
```

## Generic Binary Tree Usage

```java
// Create a generic tree of strings
GenericNode<String> root = new GenericNode<>("Root");
GenericNode<String> left = new GenericNode<>("Left Child");
GenericNode<String> right = new GenericNode<>("Right Child");

root.setLeft(left);
root.setRight(right);

GenericBinaryTree<String> tree = new GenericBinaryTree<>();
tree.setRoot(root);

// Traverse the tree
tree.inOrderTraversal(tree.getRoot(), System.out::println);
```
