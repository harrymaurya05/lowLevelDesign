package lowLevelSystemDesign.basic.atlassian.atlassianFileDrive;


public class FileData {
    private String fileName;
    private int fileSize;
    private String tag;

    public FileData(String fileName, int fileSize, String tag) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.tag = tag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
