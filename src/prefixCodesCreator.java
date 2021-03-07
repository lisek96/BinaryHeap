public class prefixCodesCreator {
    String[][] mergingHistory = new String[5][2];
    int index = 0;
    BinaryHeap binaryHeap;

    prefixCodesCreator(BinaryHeap binaryHeap) {
        this.binaryHeap = binaryHeap;
    }

    void prepareMergingHistory() {
        BH_Node BHNodeToMerge1 = null;
        BH_Node BHNodeToMerge2 = null;
        while (binaryHeap.nextIndex != 0) {
            if (index == mergingHistory.length) prepareSpace();
            BHNodeToMerge1 = binaryHeap.MIN();
            BHNodeToMerge2 = binaryHeap.MIN();
            if (!(binaryHeap.nextIndex == 0))
                binaryHeap.insertNode(new BH_Node(BHNodeToMerge1.label + BHNodeToMerge2.label, BHNodeToMerge1.value + BHNodeToMerge2.value, binaryHeap.nextIndex));
            mergingHistory[index] = new String[]{BHNodeToMerge1.label, BHNodeToMerge2.label};
            index++;
        }
        if (index == mergingHistory.length) prepareSpace();
        mergingHistory[index][0] = BHNodeToMerge1.label + BHNodeToMerge2.label;
    }

    void prepareSpace() {
        String[][] mergingHistory2 = new String[mergingHistory.length * 3 / 2][2];
        for (int i = 0; i < mergingHistory.length; i++) {
            mergingHistory2[i] = mergingHistory[i];
        }
        mergingHistory = mergingHistory2;
    }


}
