JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=LSData.class FileIn.class BinaryTreeNode.class \
BTQueueNode.class BTQueue.class BinaryTree.class \
BinarySearchTree.class AVLTree.class LSBST.class LSBSTApp.class \
LSAVLT.class LSAVLTApp.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run:
	@java -cp bin LSBSTApp

docs:
	javadoc -classpath bin/ -d doc src/*.java

cleandocs:
	rm -r doc/*