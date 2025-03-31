import java.util.*;

class SimpleMultiFolder implements MultiFolder {
    private String name;
    private String size;
    private List<Folder> subFolders;

    public SimpleMultiFolder(String name, String size, List<Folder> subFolders) {
        this.name = name;
        this.size = size;
        this.subFolders = subFolders;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public List<Folder> getFolders() {
        return subFolders;
    }

    @Override
    public String toString() {
        return "MultiFolder: " + name + " (" + size + ")";
    }
}