JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BTQueueNode.class BTQueue.class \
	 BinaryTreeNode.class BinaryTree.class \
         BinarySearchTree.class BinarySearchTreeTest.class \
	 LSData.class LSArray.class LSArrayApp.class \
	 Node.class Tree.class LSBSTApp.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run:
	@java -cp bin BinarySearchTreeTest

docs:
	javadoc -classpath bin/ -d doc src/*.java

cleandocs:
	rm -r doc/*
