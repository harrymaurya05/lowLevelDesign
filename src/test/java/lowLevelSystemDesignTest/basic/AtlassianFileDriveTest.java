package lowLevelSystemDesignTest.basic;

import lowLevelSystemDesign.basic.atlassian.atlassianFileDrive.FileData;
import lowLevelSystemDesign.basic.atlassian.atlassianFileDrive.FileDrive;
import org.junit.Test;

public class AtlassianFileDriveTest {
    /*/
    file1.txt (size: 100)
file2.txt (size: 200) in collection "collection1"
file3.txt (size: 200) in collection "collection1"
file4.txt (size: 300) in collection "collection2"
file5.txt (size: 10)
     */
    @Test
    public void getTotalSize(){
        FileData fileData = new FileData("file1.txt",100,"");
        FileData fileData1 = new FileData("file2.txt",200,"collection1");
        FileData fileData2 = new FileData("file3.txt",200,"collection1");
        FileData fileData3 = new FileData("file14.txt",200,"collection2");
        FileData fileData4 = new FileData("file5.txt",200,"");
        FileData fileData5 = new FileData("file3.txt",200,"collection3");
        FileDrive fileDrive = new FileDrive();
        fileDrive.addFile(fileData);
        fileDrive.addFile(fileData1);
        fileDrive.addFile(fileData2);
        fileDrive.addFile(fileData3);
        fileDrive.addFile(fileData4);
        fileDrive.addFile(fileData5);
       // fileDrive.getTotalSize();
        System.out.println(fileDrive.getTotalSize());
        System.out.println(fileDrive.getKTopFileCollections(3).toString());
    }
}
