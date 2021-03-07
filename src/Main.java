import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryHeap bh = new BinaryHeap();
        Scanner scanner = new Scanner(new File("plik.txt"));
        int i=0;
        while(scanner.hasNextLine()){
            Scanner lineScanner = new Scanner(scanner.nextLine());
            bh.insertNode(new BH_Node(lineScanner.next(), Integer.parseInt(lineScanner.next()), i));
            i++;
        }
        if(bh.lastIndex==-1) return;
        bh.fixAfterFastConstruct();
        if(bh.lastIndex==0) System.out.println(bh.BHNodes[0] + " " + 0);
        else {
            prefixCodesCreator prefixCodesCreator = new prefixCodesCreator(bh);
            prefixCodesCreator.prepareMergingHistory();
            ResultTree resultTree = new ResultTree(prefixCodesCreator);
            resultTree.divide(prefixCodesCreator.index - 1, resultTree.root);
        }
    }
}
