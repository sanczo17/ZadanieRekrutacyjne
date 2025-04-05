import java.util.*;
public class Main {
    public static void main(String[] args) {
        Folder f1 = new FolderImp("Dokumenty", FolderSize.Small);
        Folder f2 = new FolderImp("Zdjęcia", FolderSize.Large);
        Folder f3 = new FolderImp("Muzyka", FolderSize.Medium);

        Folder sub1 = new FolderImp("Notatki", FolderSize.Small);
        Folder sub2 = new FolderImp("Rachunki", FolderSize.Medium);
        MultiFolder multi1 = new MultiFolderImpl("Domowe", FolderSize.Large, List.of(sub1, sub2));
        MultiFolder multi2 = new MultiFolderImpl("Wszystko", FolderSize.Large, List.of(sub1, sub2, multi1, f1, f2, f3));


        List<Folder> allFolders = new ArrayList<>();
        allFolders.add(f1);
        allFolders.add(f2);
        allFolders.add(f3);
        allFolders.add(multi1);
        allFolders.add(multi2);

        FolderCabinet cabinet = new FolderCabinet(allFolders);

        System.out.println("Szukam folderu 'Notatki':");
        System.out.println(cabinet.findFolderByName("Notatki").orElse(null));

        System.out.println("\nFoldery o rozmiarze 'Small':");
        for (Folder f : cabinet.findFoldersBySize(FolderSize.Small)) {
            System.out.println(f);
        }
        System.out.println("\nFoldery o rozmiarze 'Large':");
        for (Folder f : cabinet.findFoldersBySize(FolderSize.Large)) {
            System.out.println(f);
        }
        System.out.println("-".repeat(50));
        System.out.println("\nWszystkie utworzone foldery:");
        for (Folder f : cabinet.getAllFolders()){
            System.out.println(f);
        }

        System.out.println("\nLiczba wszystkich folderów:");
        System.out.println(cabinet.count());
    }
}
