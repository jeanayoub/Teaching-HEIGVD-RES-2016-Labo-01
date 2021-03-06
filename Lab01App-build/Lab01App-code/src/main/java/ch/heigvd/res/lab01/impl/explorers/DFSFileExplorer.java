package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 * 
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor vistor) {
      
      vistor.visit(rootDirectory);
      File[] filesList = rootDirectory.listFiles();  
      
      if (filesList != null) {
          
          // Visits all the the files
          for (File file : filesList) {
               if (file.isFile())
                  vistor.visit(file);
              }
          
          // Explores all the directories
          for (File file : filesList) {
              if (file.isDirectory()) 
                  explore(file, vistor);
              
          }
          
        }
    }
}
