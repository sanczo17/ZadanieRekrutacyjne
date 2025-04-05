import java.util.*;

class MultiFolderImpl implements MultiFolder {
    private String name;
    private FolderSize size;
    private List<Folder> subFolders;

    public MultiFolderImpl(String name, FolderSize size, List<Folder> subFolders) {
        this.name = name;
        this.size = size;
        this.subFolders = subFolders;
    }

    public String getName() {
        return name;
    }

    public FolderSize getSize() {
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