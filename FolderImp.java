class FolderImp implements Folder {
    private String name;
    private String size;

    public FolderImp(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Folder: " + name + " (" + size + ")";
    }
}