


public class ResultTree {
    TreeNode root;
    String[][] resultSource;

    ResultTree(prefixCodesCreator pcc) {
        resultSource = pcc.mergingHistory;
        pcc.mergingHistory=null;
        root = new TreeNode(resultSource[pcc.index][0]);
    }

    void divide(int index, TreeNode parentNode) {
        if (resultSource[index] != null) {
            String leftLabel = resultSource[index][0];
            String rightLabel = resultSource[index][1];
            if (parentNode.label.startsWith(leftLabel)) {
                resultSource[index] = null;
                TreeNode right = new TreeNode(rightLabel, parentNode.code + "1");
                TreeNode left = new TreeNode(leftLabel, parentNode.code + "0");
                boolean divideLeft = true;
                boolean divideRight = true;
                if (left.label.length() == 1) {
                    System.out.println(left.label + " " + left.code);
                    divideLeft = false;
                }
                if (right.label.length() == 1) {
                    System.out.println(right.label + " " + right.code);
                    divideRight = false;
                }
                if (divideRight) divide(index - 1, right);
                if (divideLeft) divide( index - 1, left);
            } else divide(index - 1, parentNode);
        } else divide(index - 1, parentNode);
    }


}
