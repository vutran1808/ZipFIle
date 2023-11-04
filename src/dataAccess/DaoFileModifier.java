/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author ASUS
 */
public class DaoFileModifier {

    private static DaoFileModifier instance = null;

    public static DaoFileModifier Instance() {
        if (instance == null) {
            synchronized (DaoFileModifier.class) {
                if (instance == null) {
                    instance = new DaoFileModifier();
                }
            }
        }
        return instance;
    }

    public boolean zipFile(String path, String fileName, String dest) {
        try {
            File source = new File(path);
            File locate = new File(dest);
            File pathFileName = new File(dest + "\\" + fileName);
            if (source.exists()) {
                File data[] = source.listFiles();
                for (File file : data) {
                    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(pathFileName));
                    ZipEntry e = new ZipEntry(fileName);
                    out.putNextEntry(e);
                    out.closeEntry();
                    out.close();
                    return true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoFileModifier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean unzip(String source, String destination) {
        File destDir = new File(destination);
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
            ZipEntry zipEntry = zis.getNextEntry();
            byte[] buffer = new byte[1024];
            while (zipEntry != null) {
                System.out.println(zipEntry.getName());
                File newFile = new File(destDir + File.separator + zipEntry.getName());
                //make directory for sub directories in zip
                //Example: abc.zip -> abc -> abc.exe
                new File(newFile.getParent()).mkdir();
                FileOutputStream fos = new FileOutputStream(newFile);
                int length;
                while ((length = zis.read(buffer)) >= 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
                zis.closeEntry();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (IOException e) {
            System.out.println("File not found");
            return false;
        }
        return false;
    }
}
