/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ScannerFactory;
import dataAccess.DaoFileModifier;

/**
 *
 * @author ASUS
 */
public class ModifierFile implements IModifierFile {

    private ScannerFactory sc;

    public ModifierFile() {
        sc = new ScannerFactory();
    }

    @Override
    public void zipFile() {
        System.out.println("----- Compression -----");
        String filePath = sc.getFilePath("Enter Source Folder: ");
        System.out.println("Enter File Name: ");
        String fileName = sc.getScanner().nextLine();
        String fileDest = sc.getFilePath("Enter Destination Folder: ");
        if (DaoFileModifier.Instance().zipFile(filePath, fileName, fileDest)) {
            System.out.println("Compress File: Done");
        } else {
            System.out.println("Compress File: Failed");
        }
    }

    @Override
    public void unzipFile() {
        System.out.println("----- Extraction -----");
        String filePath = sc.getFilePath("Enter Source Folder: ");
        String fileDest = sc.getFilePath("Enter Destination Folder: ");
        if (DaoFileModifier.Instance().unzip(filePath, fileDest)) {
            System.out.println("Compress File: Done");
        } else {
            System.out.println("Compress File: Failed");
        }
    }
}
