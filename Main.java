import java.util.*;
public class Main {
    public static void main(String[] args) {
        Folder f1 = new FolderImp("Dokumenty", "SMALL");
        Folder f2 = new FolderImp("Zdjęcia", "LARGE");
        Folder f3 = new FolderImp("Muzyka", "MEDIUM");

        Folder sub1 = new FolderImp("Notatki", "SMALL");
        Folder sub2 = new FolderImp("Rachunki", "MEDIUM");
        MultiFolder multi1 = new MultiFolderImpl("Domowe", "LARGE", List.of(sub1, sub2));

        List<Folder> allFolders = new ArrayList<>();
        allFolders.add(f1);
        allFolders.add(f2);
        allFolders.add(f3);
        allFolders.add(multi1);

        FolderCabinet cabinet = new FolderCabinet(allFolders);

        System.out.println("Szukam folderu 'Notatki':");
        System.out.println(cabinet.findFolderByName("Notatki").orElse(null));

        System.out.println("\nFoldery o rozmiarze 'SMALL':");
        for (Folder f : cabinet.findFoldersBySize("SMALL")) {
            System.out.println(f);
        }

        System.out.println("\nLiczba wszystkich folderów:");
        System.out.println(cabinet.count());
    }
}
