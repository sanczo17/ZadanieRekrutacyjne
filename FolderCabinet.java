import java.util.*;

interface Cabinet {
    // zwraca dowolny element o podanej nazwie
    Optional<Folder>
    findFolderByName(String name);

    // zwraca wszystkie foldery podanego rozmiaru SMALL/MEDIUM/LARGE
    List<Folder> findFoldersBySize(FolderSize size);

    //zwraca liczbę wszystkich obiektów tworzących strukturę
    int count();
}

//public class FileCabinet implements Cabinet {
//    private List<Folder> folders;
//}

enum FolderSize {Small, Medium, Large}
interface Folder {
    String getName();
    FolderSize getSize();
}

interface MultiFolder extends Folder {
    List<Folder> getFolders();
}
public class FolderCabinet implements Cabinet {

    private List<Folder> folders;

    public FolderCabinet(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return findByNameRecursive(folders, name);
    }

    @Override
    public List<Folder> findFoldersBySize(FolderSize size) {
        List<Folder> result = new ArrayList<>();
        findBySizeRecursive(folders, size, result);
        return result;
    }

    @Override
    public int count() {
        return countRecursive(folders);
    }


    private Optional<Folder> findByNameRecursive(List<Folder> folders, String name) {
        for (Folder folder : folders) {
            if (folder.getName().equals(name)) {
                return Optional.of(folder);
            }
            if (folder instanceof MultiFolder) {
                Optional<Folder> found = findByNameRecursive(((MultiFolder) folder).getFolders(), name);
                if (found.isPresent()) {
                    return found;
                }
            }
        }
        return Optional.empty();
    }

    private void findBySizeRecursive(List<Folder> folders, FolderSize size, List<Folder> result) {
        for (Folder folder : folders) {
            if (folder.getSize() == size) {
                result.add(folder);
            }
            if (folder instanceof MultiFolder) {
                findBySizeRecursive(((MultiFolder) folder).getFolders(), size, result);
            }
        }
    }

    private int countRecursive(List<Folder> folders) {
        int count = 0;
        for (Folder folder : folders) {
            count++;
            if (folder instanceof MultiFolder) {
                count += countRecursive(((MultiFolder) folder).getFolders());
            }
        }
        return count;
    }

    public List<Folder> getAllFolders() {
        List<Folder> all = new ArrayList<>();
        collectAllFolders(folders, all);
        return all;
    }

    private void collectAllFolders(List<Folder> source, List<Folder> result) {
        for (Folder folder : source) {
            result.add(folder);
            if (folder instanceof MultiFolder) {
                collectAllFolders(((MultiFolder) folder).getFolders(), result);
            }
        }
    }

}
