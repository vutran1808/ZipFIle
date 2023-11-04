/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.IModifierFile;
import repository.ModifierFile;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class FileManager extends Menu{

    private IModifierFile mn;
    static String[] mc = {"Compression", "Extraction", "Exit"};

    public FileManager() {
        super("Zipper Program", mc);
        mn = new ModifierFile();
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> mn.zipFile();
            case 2 -> mn.unzipFile();
            case 3 -> System.exit(0);
        }
    }
}
