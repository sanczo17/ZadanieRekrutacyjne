class FolderImp implements Folder {
    private String name;
    private FolderSize size;

    public FolderImp(String name, FolderSize size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public FolderSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Folder: " + name + " (" + size + ")";
    }
}