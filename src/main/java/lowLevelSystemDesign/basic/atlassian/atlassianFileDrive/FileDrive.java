package lowLevelSystemDesign.basic.atlassian.atlassianFileDrive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileDrive {
    private int totalFileSize;
    private Map<String, FileData> fileDataMap;
    public FileDrive() {
        fileDataMap = new HashMap<>();
    }
    public void addFile(FileData fileData){
        totalFileSize += fileData.getFileSize();
        if(fileData.getTag().length() !=0){
            if(fileDataMap.containsKey(fileData.getTag())){
                FileData fileData1 = fileDataMap.get(fileData.getTag());
                fileData1.setFileSize(fileData.getFileSize()+fileData1.getFileSize());
                fileDataMap.put(fileData.getTag(),fileData1);
            }else {
                fileDataMap.put(fileData.getTag(),fileData);
            }
        }

    }
    public int getTotalSize(){
        return totalFileSize;
    }
    public List<String> getKTopFileCollections(int numberOfCollection){
        List<FileData> fileDatas = new ArrayList<>();
        for(Map.Entry<String,FileData> entry : fileDataMap.entrySet()){
            System.out.println(entry.getValue().getFileSize());
            fileDatas.add(entry.getValue());
        }
        Collections.sort(fileDatas, new Comparator<FileData>(){
            public int compare(FileData o1, FileData o2){
                return o2.getFileSize() - o1.getFileSize();
            }
        });
        List<String> result = new ArrayList<>();
        for(int i=0; i<numberOfCollection; i++){
            result.add(fileDatas.get(i).getTag());
        }
        return result;

    }

}
