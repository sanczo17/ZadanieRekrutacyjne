import java.util.*;
public class Main {
    public static void main(String[] args) {
        Folder f1 = new FolderImp("Dokumenty", FolderSize.Small);
        Folder f2 = new FolderImp("Zdjęcia", FolderSize.Large);
        Folder f3 = new FolderImp("Muzyka", FolderSize.Medium);

        Folder sub1 = new FolderImp("Notatki", FolderSize.Small);
        Folder sub2 = new FolderImp("Rachunki", FolderSize.Medium);
        MultiFolder multi1 = new MultiFolderImpl("Domowe", FolderSize.Large, List.of(sub1, sub2));

        List<Folder> allFolders = new ArrayList<>();
        allFolders.add(f1);
        allFolders.add(f2);
        allFolders.add(f3);
        allFolders.add(multi1);

        FolderCabinet cabinet = new FolderCabinet(allFolders);

        System.out.println("Szukam folderu 'Notatki':");
        System.out.println(cabinet.findFolderByName("Notatki").orElse(null));

        System.out.println("\nFoldery o rozmiarze 'SMALL':");
        for (Folder f : cabinet.findFoldersBySize(FolderSize.Small)) {
            System.out.println(f);
        }

        System.out.println("\nLiczba wszystkich folderów:");
        System.out.println(cabinet.count());
    }
}
