package com.pcwerk.seck.file;

import java.io.File;
import java.util.ArrayList;

public class FileWalker {

  public void walk(String path, ArrayList<File> fileList) {

    File root = new File(path);
    File[] list = root.listFiles();

    if (fileList == null) {
      fileList = new ArrayList<File>();
    }

    for (File f : list) {
      if ( f.isDirectory() ) {
        walk(f.getAbsolutePath(), fileList);
        // System.out.println( "Dir:" + f.getAbsoluteFile() );
      }
      else {
        // System.out.println( "File:" + f.getAbsoluteFile() );
        fileList.add(f);
      }
    }
  }
}
