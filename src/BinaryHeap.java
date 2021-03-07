import java.util.Arrays;

public class BinaryHeap {
    BH_Node[] BHNodes = new BH_Node[15];
    int nextIndex = 0;
    int lastIndex = -1;

    void insertNode(BH_Node BHNode) {
        BHNodes[nextIndex] = BHNode;
        nextIndex++;
        lastIndex++;
        if (nextIndex == BHNodes.length) prepareSpace();
    }

    BH_Node MIN() {
        BH_Node min = BHNodes[0];
        if (lastIndex != 0) {
            swapNodes(BHNodes[0], BHNodes[lastIndex]);
        }
        BHNodes[lastIndex] = null;
        nextIndex--;
        lastIndex--;
        if (BHNodes[0] != null)
            fixFrom(BHNodes[0]);
        else BHNodes = null;
        return min;
    }

    void prepareSpace() {
        BH_Node[] nodes2 = new BH_Node[BHNodes.length * 3 / 2];
        for (int i = 0; i < BHNodes.length; i++) {
            nodes2[i] = BHNodes[i];
        }
        BHNodes = nodes2;
    }

    void fixAfterFastConstruct() {
        int startingPoint = lastIndex / 2;
        for (int i = startingPoint; i >= 0; i--) fixFrom(BHNodes[i]);
    }

    void fixFrom(BH_Node BHNode) {
        if (lastIndex / 2 >= BHNode.index) {
            BH_Node leftChild = BHNodes[2 * BHNode.index + 1];
            BH_Node rightChild = BHNodes[2 * BHNode.index + 2];
            if (rightChild != null && leftChild != null) {
                BH_Node toSwap = rightChild.value > leftChild.value ? leftChild : rightChild;
                if (toSwap.value < BHNode.value) {
                    swapNodes(BHNode, toSwap);
                    fixFrom(BHNode);
                }
                return;
            } else if (rightChild != null && rightChild.value < BHNode.value) {
                swapNodes(BHNode, rightChild);
                return;
            } else if (leftChild != null && leftChild.value < BHNode.value) {
                swapNodes(BHNode, leftChild);
                return;
            }
        }
    }


    void swapNodes(BH_Node BHNode1, BH_Node BHNode2) {
        int tmp = BHNode1.index;
        BHNode1.index = BHNode2.index;
        BHNode2.index = tmp;
        BHNodes[BHNode1.index] = BHNode1;
        BHNodes[BHNode2.index] = BHNode2;
    }


}
